package com.example.otp.services;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.otp.bean.OTP;
import com.example.otp.dao.OtpDao;
import com.example.otp.exceptions.ExceededAttemptsException;
import com.example.otp.exceptions.NegativeException;
import com.example.otp.sendEmail.SendEmail;

@Service
public class OtpServicesImpl implements OtpServices {

	@Autowired
	OtpDao otpDao;

	@Override
	public int getOtp(int userId, int orderId, String channelName) throws NegativeException {

		if (userId <= 0 || orderId <= 0) {
			throw new NegativeException();
		}

		int otp = (int) (Math.floor(100000 + Math.random() * 900000));

		OTP objOtp = new OTP(userId, orderId, channelName, otp);

		SendEmail.sendEmail("aarushgandhi2007@gamil.com", otp, userId, orderId);

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				objOtp.setOtp(0);
				otpDao.save(objOtp);
			}
		}, 60000);

		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				objOtp.setAttempts(0);
				otpDao.save(objOtp);
			}
		}, 300000);

		otpDao.save(objOtp);
		return otp;
	}

	@Override
	public String validateOtp(int userId, int orderId, String channelName, int otp)
			throws NegativeException, ExceededAttemptsException {

		if (userId <= 0 || orderId <= 0 || otp <= 0) {
			throw new NegativeException();
		}

		OTP objOtp = otpDao.findById(orderId).get();

		if (objOtp.getAttempts() >= 5)
			throw new ExceededAttemptsException();

		objOtp.setAttempts(objOtp.getAttempts() + 1);
		otpDao.save(objOtp);

		if (userId != objOtp.getUserId())
			return "UserId doesn't match";
		else if (!channelName.equals(objOtp.getChannelName()))
			return "Channel Name doesn't match";
		else if (objOtp.getOtp() == 0)
			return "Timeout for this OTP! Try Again";
		else if (otp != objOtp.getOtp())
			return "Invalid OTP";
		else {
			objOtp.setAttempts(objOtp.getAttempts()-1);
			otpDao.save(objOtp);
			return "OTP Validated";
		}

	}
	
	boolean checkEmail(String email,String emailFormat) {
		if(email.matches(emailFormat)) return true;
		else return false;
	}

}

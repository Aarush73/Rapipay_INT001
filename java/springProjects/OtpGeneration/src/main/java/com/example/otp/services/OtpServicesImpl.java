package com.example.otp.services;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.otp.bean.OTP;
import com.example.otp.dao.OtpDao;
import com.example.otp.exceptions.ExceededAttemptsException;
import com.example.otp.exceptions.InvalidEmailException;
import com.example.otp.exceptions.NegativeException;
import com.example.otp.sendEmail.SendEmail;

@Service
public class OtpServicesImpl implements OtpServices {

	@Value("${validTime}")
	public int validTime;

	@Value("${attemptsTimeout}")
	public int attemptsTimeout;

	@Autowired
	private OtpDao otpDao;

	@Autowired
	private SendEmail send;

	@Override
	public int getOtp(OTP objectOTP) throws NegativeException, InvalidEmailException {

		if (objectOTP.getUserId() <= 0 || objectOTP.getOrderId() <= 0) {
			throw new NegativeException();
		}

		int otp = (int) (Math.floor(100000 + Math.random() * 900000));

		OTP objOtp = new OTP(objectOTP.getUserId(), objectOTP.getOrderId(), objectOTP.getChannelName(),
				objectOTP.getEmail());
		objOtp.setOtp(otp);

		if (checkEmail(objectOTP.getEmail())) {

			send.sendEmail(objectOTP.getEmail(), otp, objectOTP.getUserId(), objectOTP.getOrderId());

			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					objOtp.setOtp(0);
					otpDao.save(objOtp);
				}
			}, validTime);

			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					objOtp.setAttempts(0);
					otpDao.save(objOtp);
				}
			}, attemptsTimeout);

			otpDao.save(objOtp);
			return otp;
		} else {
			throw new InvalidEmailException();
		}
	}

	@Override
	public String validateOtp(int userId, int orderId, String channelName, int otp)
			throws NegativeException, ExceededAttemptsException {

		if (userId <= 0 || orderId <= 0 || otp < 0) {
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
			objOtp.setAttempts(0);
			otpDao.save(objOtp);
			return "OTP Validated";
		}

	}

	public boolean checkEmail(String email) {
		String re = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
		if (email.matches(re))
			return true;
		else
			return false;
	}

}

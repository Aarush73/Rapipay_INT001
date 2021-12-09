package com.rapipay.otp.service;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rapipay.otp.bean.Agent;
import com.rapipay.otp.bean.Client;
import com.rapipay.otp.bean.OTP1;
import com.rapipay.otp.dao.OTPDao;
import com.rapipay.otp.email.SendEmail;

@Service
public class OTPServiceImpl implements OTPService {

	@Value("${validTime}")
	public int validTime;

	@Autowired
	private SendEmail send;

	@Autowired
	private OTPDao otpDao;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public int generateOTP(int agentId, int clientId, String type) {
		int otp = (int) (Math.floor(100000 + Math.random() * 900000));

		OTP1 objectOtp = new OTP1(agentId, clientId);
		objectOtp.setOtp(otp);
		
		otpDao.saveAndFlush(objectOtp);

		Agent a = restTemplate.getForObject("http://localhost:7075/agent/" + agentId, Agent.class);
		Client c = restTemplate.getForObject("http://localhost:7071/client/" + clientId, Client.class);

		if (type.equals("AtoC") && checkEmail(a.getAgentEmail()))
			send.sendEmail(a.getAgentEmail(), otp, objectOtp.getAgentId(), objectOtp.getClientId());
		else if (type.equals("CtoA") && checkEmail(c.getClientEmail()))
			send.sendEmail(c.getClientEmail(), otp, objectOtp.getAgentId(), objectOtp.getClientId());
		else
			return 0;

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				objectOtp.setOtp(0);
				otpDao.save(objectOtp);
			}
		}, validTime);

		return otp;
	}

	@Override
	public boolean validateOTP(int agentId, int clientId, int otp) {
		OTP1 savedObj = otpDao.findById(clientId).get();

		if (otp == savedObj.getOtp())
			return true;
		else
			return false;
	}

	public boolean checkEmail(String email) {
		String re = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
		if (email.matches(re))
			return true;
		else
			return false;
	}
}

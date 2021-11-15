package com.example.otp.OtpGeneration.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.otp.bean.OTP;
import com.example.otp.services.OtpServicesImpl;

class OTPServiceImplsTest {

//	@Test
//	@DisplayName("Validate Email 1")
//	void testCheckEmail1() {
//		// fail("Not yet implemented");
//		OtpServicesImpl otpService = new OtpServicesImpl();
//		boolean expected = true;
//		boolean actual = otpService.checkEmail("abc@gmail.com");
//		assertEquals(expected, actual);
//	}

//	@Test
//	@DisplayName("Validate Email 2")
//	void testCheckEmail2() {
//		// fail("Not yet implemented");
//		OtpServicesImpl otpService = new OtpServicesImpl();
//		boolean expected = false;
//		boolean actual = otpService.checkEmail("abc@gmail.");
//		assertEquals(expected, actual);
//	}
//
	@Test
	void testGetOTP() {
		// fail("Not yet implemented");
		OtpServicesImpl otpService = new OtpServicesImpl();
//		OTP otp = new OTP(1, 1, "email", 1);
		assertThrows(Exception.class, () -> {
			otpService.getOtp(1, 1, "email");
		});
	}

	@Test
	void testVerifyOTP() {
		// fail("Not yet implemented");
		OtpServicesImpl otpService = new OtpServicesImpl();
//		OTP otp = new OTP(1, 1, "email", 1);

		assertThrows(Exception.class, () -> {
			otpService.validateOtp(1,1,"email", 1);
		});
	}

	@Test
	void testSendOTPSMS() {
		OtpServicesImpl otpService = new OtpServicesImpl();
//		OTP otp = new OTP(51, "sms", "9897630233");
//		assertThrows(Exception.class, ()->{
//			otpService.verifyOTP(otp);
//	});
//		String expected = otpService.sendOTPSMS(otp);
		String actual = "successfully";
//		assertEquals(expected, actual);
	}
}
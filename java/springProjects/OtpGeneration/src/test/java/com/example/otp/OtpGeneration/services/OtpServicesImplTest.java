package com.example.otp.OtpGeneration.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.otp.bean.OTP;
import com.example.otp.services.OtpServicesImpl;

class OTPServiceImplsTest {

	@Test
	@DisplayName("Validate Email 1")
	void testCheckEmail1() {
		OtpServicesImpl otpService = new OtpServicesImpl();
		boolean expected = true;
		boolean actual = otpService.checkEmail("abc@gmail.com");
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Validate Email 2")
	void testCheckEmail2() {
		OtpServicesImpl otpService = new OtpServicesImpl();
		boolean expected = true;
		boolean actual = otpService.checkEmail("something@kiet.edu");
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Validate Email 3")
	void testCheckEmail3() {
		OtpServicesImpl otpService = new OtpServicesImpl();
		boolean expected = false;
		boolean actual = otpService.checkEmail("54@34");
		assertEquals(expected, actual);
	}

	@Test
	void testGetOTP() {
		OtpServicesImpl otpService = new OtpServicesImpl();
		OTP otp = new OTP(1, 1, "email", "something@kiet.edu");
		assertThrows(Exception.class, () -> {
			otpService.getOtp(otp);
		});
	}

	@Test
	void testVerifyOTP() {
		OtpServicesImpl otpService = new OtpServicesImpl();

		assertThrows(Exception.class, () -> {
			otpService.validateOtp(1,1,"email", 1);
		});
	}
	
	@Test
	void testLengthOTP() {
		OtpServicesImpl otpService = new OtpServicesImpl();
		
		OTP otp = new OTP(1, 1, "email", "something@kiet.edu");
		
		assertThrows(Exception.class, () -> {
			int expected = 6;
			int actual = (otpService.getOtp(otp) + "").length();
			assertEquals(expected, actual);
		});
		
	}
}
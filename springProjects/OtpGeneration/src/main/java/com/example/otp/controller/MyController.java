package com.example.otp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.otp.bean.OTP;
import com.example.otp.exceptions.ExceededAttemptsException;
import com.example.otp.exceptions.InvalidEmailException;
import com.example.otp.exceptions.NegativeException;
import com.example.otp.services.OtpServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1")
public class MyController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyController.class);
	Logger logger = LoggerFactory.getLogger(MyController.class);
	 
	@Autowired
	private OtpServices otps;
	
	@Operation(summary="Enter UserId, OrderId, ChannelName and email to generate OTP", tags="POST")
	@ApiResponses(value= {
	@ApiResponse(responseCode="200",description="Connection Established"),
	@ApiResponse(responseCode="401",description="UnAuthorised Access"),
	@ApiResponse(responseCode="404",description="Not Found"),
	})
	@PostMapping("/getOtp")
	public Object getOtp(@RequestBody OTP objectOTP) {
		try {
			LOGGER.info("for informational purpose");
			return otps.getOtp(objectOTP);
		} catch (NegativeException e) { 
			return e.toString();
		} catch (InvalidEmailException e1) {
			return e1.toString();
		} catch (Exception e2) {
			return e2.toString();
		} 
	}

	
	@Operation(summary="Write OrderId, UserId, ChannelName, OTP to validate OTP", tags="GET")
	@ApiResponses(value= {
	@ApiResponse(responseCode="200",description="Connection Established"),
	@ApiResponse(responseCode="401",description="UnAuthorised Access"),
	@ApiResponse(responseCode="404",description="Not Found"),
	})
	@GetMapping("/validateOtp")
	public Object validateOtp(@RequestParam int userId, @RequestParam int orderId, @RequestParam String channelName, @RequestParam int otp) {
		try {
			LOGGER.info("for informational purpose");
			return otps.validateOtp(userId, orderId, channelName, otp);
		} catch (NegativeException e) {
			return e.toString();
		} catch (ExceededAttemptsException e1) {
			return e1.toString();
		} catch (Exception e2) {
			return e2.toString();
		}
	}
	
	@Operation(summary="Made for Test", tags="GET")
	@ApiResponses(value= {
	@ApiResponse(responseCode="200",description="Connection Established"),
	@ApiResponse(responseCode="401",description="UnAuthorised Access"),
	@ApiResponse(responseCode="404",description="Not Found"),
	})
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@Operation(summary = "check Monitor", tags = "GET")
	@GetMapping("/monitor")
	public String monitor() {
	LOGGER.info("Inside Monitor controller");

	try {
	boolean condition=true;
	while(condition)
	{
	Runnable r =  () -> {
	while(true)
	{

	}
	};
	new Thread(r).start();
	Thread.sleep(5000);
	}
	} catch (Exception e) {
	// TODO: handle exception
	}
	return "OTP api monitor running";
	}

}

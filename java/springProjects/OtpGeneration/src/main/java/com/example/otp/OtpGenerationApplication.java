package com.example.otp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

//@EnableMongoRepositories
//@EnableSwagger2
@SpringBootApplication
@OpenAPIDefinition(info=@Info (title="OTP API", version="3.0", description="Otp generation and validation"))
public class OtpGenerationApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtpGenerationApplication.class, args);
	}

}

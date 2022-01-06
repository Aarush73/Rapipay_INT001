package com.example.otp.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.otp.bean.OTP;

public interface OtpDao extends MongoRepository<OTP, Integer>{

}

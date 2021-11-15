package com.example.otp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.otp.bean.OTP;

public interface OtpDao extends JpaRepository<OTP, Integer>{

}

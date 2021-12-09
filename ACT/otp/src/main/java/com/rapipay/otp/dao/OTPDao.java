package com.rapipay.otp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rapipay.otp.bean.OTP1;

public interface OTPDao extends JpaRepository<OTP1, Integer>{

}

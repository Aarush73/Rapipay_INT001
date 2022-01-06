//package com.rapipay.ACT.mini_project.exceptions;
//
//import java.time.LocalTime;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class MyExceptionHandler {
//
//	@ExceptionHandler
//	public ResponseEntity<ExceptionTemplate> Exception1(NotFoundException nfe) {
//		ExceptionTemplate template = new ExceptionTemplate();
//
//		template.setCurrentTime(LocalTime.now());
//		template.setExceptionMsg(nfe.toString());
//
//		return new ResponseEntity<ExceptionTemplate>(template, HttpStatus.BAD_REQUEST);
//	}
//	
//	@ExceptionHandler
//	public ResponseEntity<ExceptionTemplate> Exception2(MinBalanceException mbe) {
//		ExceptionTemplate template = new ExceptionTemplate();
//
//		template.setCurrentTime(LocalTime.now());
//		template.setExceptionMsg(mbe.toString());
//
//		return new ResponseEntity<ExceptionTemplate>(template, HttpStatus.BAD_REQUEST);
//	}
//}

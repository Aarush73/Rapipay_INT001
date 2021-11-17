package com.rapipay.add.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapipay.add.entity.Addition;
import com.rapipay.add.repository.AdditionRepo;

@Service
public class AdditionServiceImpl implements AdditionService {

	@Autowired
	private AdditionRepo addDB;
	
	@Override
	public double sum(double a, double b) {
		
		Addition add = new Addition();
		add.setA(a);
		add.setB(b);
		add.setSum(a+b);
		addDB.save(add);
		
		return a+b;
	}

}

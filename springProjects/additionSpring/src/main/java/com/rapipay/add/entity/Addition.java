package com.rapipay.add.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Addition {
	@Id
	private double a;
	private double b;
	private double sum;
}

package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TicketDetailsTest {

	@Test
	@DisplayName("Test")
	public void doTest() {
		Set<Integer> num1 = new HashSet<Integer>();
		Set<Integer> num2 = new HashSet<Integer>();
		
		num1.add(1);
		num1.add(2);
		num1.add(3);
		
		num2.add(1);
		num2.add(2);
		num2.add(3);
		
		Iterator<Integer> itr1 = num1.iterator();
		Iterator<Integer> itr2 = num2.iterator();
		
		assertEquals(itr1, itr2);
	}
}

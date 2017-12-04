package com.lin.luo.tian.domain;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import org.junit.Test;

public class DateTest {
	@Test
	public void test1() {
		LocalDate now = LocalDate.now();
		System.out.println(now.getDayOfYear());
		System.out.println(now.getDayOfMonth());
		
		Date date = new Date();
		Instant instant = date.toInstant();
		System.out.println(instant);
	}
}

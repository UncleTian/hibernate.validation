package com.lin.luo.tian.domain;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;

public class CarTest extends BaseTest {

	@Test
	public void test() {
		Car car = new Car("jim", "123@16e.com", "BaoMa");
		Set<ConstraintViolation<Car>> validate = VALIDATOR.validate(car);
		assertEquals(1, validate.size());
		assertEquals("Domestic brand, BaoMa is not a authorized brand", validate.iterator().next().getMessage());
	}

}

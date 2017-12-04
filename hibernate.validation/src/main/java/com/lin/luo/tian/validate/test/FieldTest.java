package com.lin.luo.tian.validate.test;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

import com.lin.luo.tian.domain.Car;

public class FieldTest {
	@Test
	public void test1() {
		Car car = new Car(null, "1111@123.com", "baoma");
		car.setName(null);
		car.setPrice(100.0);
		
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<Car>> validate = validator.validate(car);
		assertEquals(1, validate.size());
		ConstraintViolation<Car> constraintViolation = validate.iterator().next();
		assertEquals("must not be null", constraintViolation.getMessage());
		Path propertyPath = constraintViolation.getPropertyPath();
		System.out.println(propertyPath);
	}
}

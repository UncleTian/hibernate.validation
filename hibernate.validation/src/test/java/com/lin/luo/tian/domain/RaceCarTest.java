package com.lin.luo.tian.domain;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

import com.lin.luo.tian.checks.OrderedChecks;

public class RaceCarTest {
	private static final Validator VALIDATOR;

	static {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		VALIDATOR = validatorFactory.getValidator();
	}

	@Test
	public void test() {
		RaceCar raceCar = new RaceCar(null, true, true);
		Set<ConstraintViolation<RaceCar>> validate = VALIDATOR.validate(raceCar);
		validate.forEach(v -> {
			System.out.println(v.getMessage());
		});
		assertEquals(1, validate.size());
	}

}

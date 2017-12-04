package com.lin.luo.tian.domain;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;

public class BaseTest {
	protected static final Validator VALIDATOR;
	protected static final ExecutableValidator EXECUTABLEVALIDATOR;

	static {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		VALIDATOR = validatorFactory.getValidator();
		EXECUTABLEVALIDATOR = VALIDATOR.forExecutables();
	}
	
	
}

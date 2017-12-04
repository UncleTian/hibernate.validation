package com.lin.luo.tian.domain;

import static org.junit.Assert.assertEquals;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ExecutableValidator;

import org.junit.Test;

public class CustomerTest {
	private static final String REGEX_EMAIL = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
	private static final Validator VALIDATOR;
	private static final String REGEX1 = "^(\\.)+$";

	static {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		VALIDATOR = validatorFactory.getValidator();
	}

	@Test
	public void test() {
		Customer customer = new Customer(1, "jack");
		customer.setName("444");
		customer.setEmail("111@163");
		Set<ConstraintViolation<Customer>> constraintViolations = VALIDATOR.validate(customer);
		Iterator<ConstraintViolation<Customer>> iterator = constraintViolations.iterator();
		while (iterator.hasNext()) {
			ConstraintViolation<Customer> constraintViolation = iterator.next();
			System.out.println(constraintViolation.getMessage());
		}
	}

	@Test
	public void testDate() throws ParseException {
		Customer customer = new Customer(1, null);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = df.parse("2016-11-08");
		customer.setDate(date);
		Set<ConstraintViolation<Customer>> validate = VALIDATOR.validate(customer);
		assertEquals(1, validate.size());
	}

	@Test
	public void testCounstructor() throws NoSuchMethodException, SecurityException {
		ExecutableValidator validator = VALIDATOR.forExecutables();
		Object[] parameterValues = { 1, null };
		Set<ConstraintViolation<Customer>> validateConstructorParameters = validator.validateConstructorParameters(
				Customer.class.getConstructor(Integer.class, String.class), parameterValues);
		assertEquals(1, validateConstructorParameters.size());

		Class<? extends Annotation> annotationType = validateConstructorParameters.iterator().next()
				.getConstraintDescriptor().getAnnotation().annotationType();
		assertEquals(NotNull.class, annotationType);
	}

	@Test
	public void testReturnValue() throws NoSuchMethodException, SecurityException {
		ExecutableValidator validator = VALIDATOR.forExecutables();
		Customer customer = new Customer(1, "jack");
		Method method = Customer.class.getMethod("getGoodsList");
		List<String> returnValue = new ArrayList<>();
		Set<ConstraintViolation<Customer>> validateReturnValue = validator.validateReturnValue(customer, method,
				returnValue);
		assertEquals(validateReturnValue.size(), 1);
		assertEquals("size must be between 1 and 2147483647", validateReturnValue.iterator().next().getMessage());
	}

	@Test
	public void test2() {
		String email = "..1";
		Pattern compile = Pattern.compile(REGEX1);
		Matcher matcher = compile.matcher(email);
		boolean matches = matcher.matches();
		System.out.println(matches);
	}

	@Test
	public void test3() {
		Father f = new Son();
		f.test();
	}

}

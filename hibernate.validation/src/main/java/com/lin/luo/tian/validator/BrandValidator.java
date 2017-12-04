package com.lin.luo.tian.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;

import com.lin.luo.tian.annotation.AuthorizedBrand;
import com.lin.luo.tian.types.BrandTypes;

public class BrandValidator implements ConstraintValidator<AuthorizedBrand, String> {
	private BrandTypes brandTypes;

	@Override
	public void initialize(AuthorizedBrand constraintAnnotation) {
		brandTypes = constraintAnnotation.type();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean flag = false;
		String message = context.getDefaultConstraintMessageTemplate();
		if (BrandTypes.ABROAD.getValue().equals(brandTypes)) {
			message = "Abroad brand, " + message;
			if ("BaoMa".equalsIgnoreCase(value)) {
				flag = true;
			}
		} else {
			message = "Domestic brand, " + message;
			if ("Harvard".equalsIgnoreCase(value)) {
				flag = true;
			}
		}

		context.disableDefaultConstraintViolation();
		context.buildConstraintViolationWithTemplate(message).addConstraintViolation();

		return flag;
	}

}

package com.lin.luo.tian.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.lin.luo.tian.types.BrandTypes;
import com.lin.luo.tian.validator.BrandValidator;

@Target({ FIELD, METHOD, PARAMETER, TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = BrandValidator.class)
@Documented
@Repeatable(AuthorizedBrand.List.class)
public @interface AuthorizedBrand {

	String message() default "${validatedValue} is not a authorized brand";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	BrandTypes type();

	@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		AuthorizedBrand[] value();
	}
}

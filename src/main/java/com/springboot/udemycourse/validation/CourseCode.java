package com.springboot.udemycourse.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import javax.lang.model.element.Element;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    public String value() default "LUV";
    public String message() default "must start with 'LUV'";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}

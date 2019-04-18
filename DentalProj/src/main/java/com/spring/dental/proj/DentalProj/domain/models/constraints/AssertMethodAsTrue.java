package com.spring.dental.proj.DentalProj.domain.models.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

import org.hibernate.tool.schema.TargetType;

@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {AssertMethodAsTrueValidator.class} )
@Documented
public @interface AssertMethodAsTrue {
    String message() default "{value} returned false";
    String value() default "isValid";
    Class[] groups() default {};
    Class[] payload() default {};       
}

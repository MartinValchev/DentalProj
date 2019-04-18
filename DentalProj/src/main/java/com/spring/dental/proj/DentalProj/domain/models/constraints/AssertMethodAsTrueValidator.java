package com.spring.dental.proj.DentalProj.domain.models.constraints;

import java.lang.reflect.Method;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AssertMethodAsTrueValidator implements ConstraintValidator<AssertMethodAsTrue, Object>{
	
    private String methodName;
    
    public void initialize(AssertMethodAsTrue assertMethodAsTrue) {
        methodName =  assertMethodAsTrue.value();
    }
    public boolean isValid(Object object,
                           ConstraintValidatorContext constraintValidatorContext) {
        
        try {
            Class clazz = object.getClass();
            Method validate = clazz.getMethod(methodName, new Class[0]);
            return (Boolean) validate.invoke(object);
        } catch (Throwable e) {
            System.err.println(e);
        }
        return false;
    }
}

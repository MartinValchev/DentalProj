package com.spring.dental.proj.DentalProj.domain.models.constraints;

import java.lang.reflect.Method;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateRangeValidator implements ConstraintValidator<ValidateDateRange,Object>{
    private String start;
    private String end;
    
    public void initialize(ValidateDateRange validateDateRange) {
        start = validateDateRange.start();
        end =  validateDateRange.end();
    }

    @Override
    public boolean isValid(Object object,
                           ConstraintValidatorContext constraintValidatorContext) {
        try {
            @SuppressWarnings("rawtypes")
			Class clazz = object.getClass();
            Date startDate = null;
            @SuppressWarnings("unchecked")
			Method startGetter = clazz.getMethod(getAccessorMethodName(start), new Class[0]);
            Object startGetterResult = startGetter.invoke(object, null);
            if (startGetterResult != null && startGetterResult instanceof Date){
                startDate = (Date) startGetterResult;
            }else{
                return false;
            }
            Date endDate = null;
            @SuppressWarnings("unchecked")
			Method endGetter = clazz.getMethod(getAccessorMethodName(end), new Class[0]);
            Object endGetterResult = endGetter.invoke(object, null);
            if (endGetterResult == null){
                return true;
            }
            if (endGetterResult instanceof Date){
                endDate = (Date) endGetterResult;
            }
            return (startDate.before(endDate));           
        } catch (Throwable e) {
            System.err.println(e);
        }

        return false;
    }
    private String getAccessorMethodName(String property){
        StringBuilder builder = new StringBuilder("get");
        builder.append(Character.toUpperCase(property.charAt(0))); 
        builder.append(property.substring(1));
        return builder.toString();
    }

}



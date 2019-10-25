package com.fat.pweb2.gestaofesta.model.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class DataNascimentoValidator implements ConstraintValidator<DataNascimento, Date> {

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context){
        try{
            if(value.compareTo(new Date(System.currentTimeMillis())) < 0) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }

        return false;
    }

}

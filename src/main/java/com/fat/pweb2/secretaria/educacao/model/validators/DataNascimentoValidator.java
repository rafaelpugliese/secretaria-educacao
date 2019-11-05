package com.fat.pweb2.secretaria.educacao.model.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;
import java.util.Date;

public class DataNascimentoValidator implements ConstraintValidator<DataNascimento, Date> {

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext context) {

        if (date == null) {
            return false;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR) >= 2019;
    }

}

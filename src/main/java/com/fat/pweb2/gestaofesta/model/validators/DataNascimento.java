package com.fat.pweb2.gestaofesta.model.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DataNascimentoValidator.class)
@Documented
public @interface DataNascimento {

    String message() default "{DataNascimento.invalid}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

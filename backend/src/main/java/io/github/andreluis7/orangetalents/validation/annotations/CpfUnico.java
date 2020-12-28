package io.github.andreluis7.orangetalents.validation.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;

import io.github.andreluis7.orangetalents.validation.validators.CpfUnicoValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CpfUnicoValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfUnico {

    String message() default "{io.github.monthalcantara.nossobancodigital.validation.annotations.UnicoCPF}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
package io.github.andreluis7.orangetalents.validation.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import io.github.andreluis7.orangetalents.validation.validators.UnicoEmailValidator;

@Documented
@Constraint(validatedBy = UnicoEmailValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailUnico {

    String message() default "{io.github.monthalcantara.nossobancodigital.validation.annotations.UnicoEmail}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
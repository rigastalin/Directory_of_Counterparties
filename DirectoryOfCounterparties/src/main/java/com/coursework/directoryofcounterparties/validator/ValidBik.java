package com.coursework.directoryofcounterparties.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Аннотация для проверки корректности БИК контрагента.
 */
@Documented
@Constraint(validatedBy = BikValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidBik {

    /**
     * Сообщение об ошибке, которое будет возвращено в случае невалидного БИК.
     *
     * @return сообщение об ошибке
     */
    String message() default "Invalid BIK";

    /**
     * Группы ограничений, к которым относится данная аннотация.
     *
     * @return группы ограничений
     */
    Class<?>[] groups() default {};

    /**
     * Параметры для передачи дополнительных метаданных при использовании аннотации.
     *
     * @return параметры аннотации
     */
    Class<? extends Payload>[] payload() default {};
}

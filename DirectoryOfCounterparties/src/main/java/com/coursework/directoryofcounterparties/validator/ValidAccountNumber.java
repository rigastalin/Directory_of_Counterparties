package com.coursework.directoryofcounterparties.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Аннотация для проверки корректности банковского номера счета контрагента.
 */
@Constraint(validatedBy = AccountNumberValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidAccountNumber {

    /**
     * Сообщение об ошибке, которое будет возвращено в случае невалидного номера счета.
     *
     * @return сообщение об ошибке
     */
    String message() default "Invalid bank account";

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

    /**
     * Возвращает массив строк, представляющих значения по умолчанию для параметра.
     *
     * @return массив строк, содержащий значения по умолчанию для параметра.
     */
    String[] param() default {};

    /**
     * Возвращает класс BikProvider, который предоставляет значение БИК для проверки.
     *
     * @return класс BikProvider
     */
    Class<? extends BikProvider> bikProvider();
}

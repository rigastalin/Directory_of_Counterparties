package com.coursework.directoryofcounterparties.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Валидатор для проверки корректности БИК (Банковский идентификационный код) контрагента.
 */
public class BikValidator implements ConstraintValidator<ValidBik, String> {

    /**
     * Инициализация валидатора.
     *
     * @param constraintAnnotation аннотация, связанная с валидируемым полем
     */
    @Override
    public void initialize(ValidBik constraintAnnotation) {
    }

    /**
     * Проверка валидности БИК контрагента.
     *
     * @param bik                         строка, содержащая БИК
     * @param constraintValidatorContext контекст валидатора
     * @return {@code true}, если БИК валиден, {@code false} в противном случае
     */
    @Override
    public boolean isValid(String bik, ConstraintValidatorContext constraintValidatorContext) {
        if (bik == null) {
            return false;
        }

        // Проверяем ограничение для первых двух цифр - должны быть 04
        String firstTwoDigits = bik.substring(0, 2);
        if (!firstTwoDigits.equals("04")) {
            return false;
        }

        // Проверяем ограничение для последних трех цифр - должны быть от 050 до 999
        String lastThreeDigits = bik.substring(bik.length() - 3);
        int lastThreeDigitsValue = Integer.parseInt(lastThreeDigits);
        if (lastThreeDigitsValue < 50 || lastThreeDigitsValue > 999) {
            return false;
        }

        // Проверяем ограничение для 5-й и 6-й цифр - должны быть от 00 до 99
        String fifthAndSixthDigits = bik.substring(4, 6);
        int fifthAndSixthDigitsValue = Integer.parseInt(fifthAndSixthDigits);
        return fifthAndSixthDigitsValue >= 0 && fifthAndSixthDigitsValue <= 99;
    }
}

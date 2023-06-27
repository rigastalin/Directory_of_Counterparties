package com.coursework.directoryofcounterparties.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Валидатор для проверки корректности номера счета контрагента.
 */
public class AccountNumberValidator implements ConstraintValidator<ValidAccountNumber, String> {
    private Class<? extends BikProvider> bikProviderClass;

    /**
     * Инициализация валидатора.
     *
     * @param constraintAnnotation аннотация, связанная с валидируемым полем
     */
    @Override
    public void initialize(ValidAccountNumber constraintAnnotation) {
        bikProviderClass = constraintAnnotation.bikProvider();
    }

    /**
     * Проверка валидности номера счета.
     *
     * @param accountNumber                номер счета для проверки
     * @param constraintValidatorContext   контекст валидатора
     * @return {@code true}, если номер счета валиден, {@code false} в противном случае
     */
    @Override
    public boolean isValid(String accountNumber, ConstraintValidatorContext constraintValidatorContext) {
        String bik = new String();
        try {
            BikProvider bikProvider = bikProviderClass.getDeclaredConstructor().newInstance();
            bik = bikProvider.getBik();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (accountNumber == null || accountNumber.length() != 20) {
            return false;
        }

        boolean creditOrg = accountNumber.charAt(6) == '0' && accountNumber.charAt(7) == '0';

        if (creditOrg) {
            String bikLastThreeDigits = bik.substring(bik.length() - 3);
            String validationString = bikLastThreeDigits + accountNumber;

            int[] weightCoefficients = {7,1,3,7,1,3,7,1,3,7,1,3,7,1,3,7,1,3,7,1,3,7,1};

            int sum = 0;
            for (int i = 0; i < validationString.length(); i++) {
                int digit = Character.getNumericValue(validationString.charAt(i));
                sum += digit * weightCoefficients[i];
            }
            return sum % 10 == 0;
        }
        return true;
    }
}

package com.coursework.directoryofcounterparties.exception;

/**
 * Исключение, выбрасываемое при отсутствии контрагента.
 */
public class CounterpartyNotFoundException extends RuntimeException{

    /**
     * Конструктор с сообщением об ошибке.
     *
     * @param message Сообщение об ошибке.
     */
    public CounterpartyNotFoundException(String message) {
        super(message);
    }
}

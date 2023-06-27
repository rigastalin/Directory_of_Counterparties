package com.coursework.directoryofcounterparties.validator;

/**
 * Интерфейс для получения значения БИК (Банковский идентификационный код).
 */
public interface BikProvider {

    /**
     * Возвращает значение БИК.
     *
     * @return значение БИК
     */
    String getBik();
}

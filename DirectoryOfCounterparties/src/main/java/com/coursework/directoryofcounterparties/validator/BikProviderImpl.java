package com.coursework.directoryofcounterparties.validator;

import com.coursework.directoryofcounterparties.model.Counterparty;

/**
 * Реализация интерфейса BikProvider, использующая объект Counterparty для получения значения БИК.
 */
public class BikProviderImpl implements BikProvider {
    private final Counterparty counterparty;

    /**
     * Создает экземпляр класса BikProviderImpl с указанным объектом Counterparty.
     *
     * @param counterparty объект Counterparty для получения значения БИК
     */
    public BikProviderImpl(Counterparty counterparty) {
        this.counterparty = counterparty;
    }

    /**
     * Создает экземпляр класса BikProviderImpl с новым объектом Counterparty.
     */
    public BikProviderImpl() {
        this.counterparty = new Counterparty();
    }

    /**
     * Возвращает значение БИК, полученное из объекта Counterparty.
     *
     * @return значение БИК
     */
    @Override
    public String getBik() {
        return counterparty.getBik();
    }
}

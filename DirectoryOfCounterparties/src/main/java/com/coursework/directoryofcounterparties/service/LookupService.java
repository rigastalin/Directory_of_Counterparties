package com.coursework.directoryofcounterparties.service;

import com.coursework.directoryofcounterparties.model.Counterparty;

/**
 * Сервис для поиска контрагентов.
 */
public interface LookupService {

    /**
     * Доступ к контрагенту по его наименованию.
     *
     * @param name наименование контрагента
     * @return найденный контрагент
     */
    Counterparty getCounterpartyByName(String name);

    /**
     * Доступ контрагента по его БИК и номеру счета.
     *
     * @param bik           БИК контрагента
     * @param accountNumber номер счета контрагента
     * @return найденный контрагент
     */
    Counterparty getCounterpartyByBikAndAccountNumber(String bik, String accountNumber);
}
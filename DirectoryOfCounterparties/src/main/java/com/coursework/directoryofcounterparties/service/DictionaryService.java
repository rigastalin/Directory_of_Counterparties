package com.coursework.directoryofcounterparties.service;

import com.coursework.directoryofcounterparties.model.Counterparty;


/**
 * Сервис для управления сущностями контрагентов.
 */
public interface DictionaryService {

    /**
     * Создание нового контрагента.
     *
     * @param counterparty Новый контрагент.
     * @return Созданный контрагент.
     */
    Counterparty createCounterparty(Counterparty counterparty);

    /**
     * Обновление контрагента по его идентификатору.
     *
     * @param id           Идентификатор контрагента.
     * @param counterparty Обновленные данные контрагента.
     * @return Обновленный контрагент.
     */
    Counterparty updateCounterparty(Long id, Counterparty counterparty);

    /**
     * Обновление контрагента по его наименованию.
     *
     * @param name         Наименование контрагента.
     * @param counterparty Обновленные данные контрагента.
     * @return Обновленный контрагент.
     */
    Counterparty updateCounterpartyByName(String name, Counterparty counterparty);

    /**
     * Удаление контрагента по его идентификатору.
     *
     * @param id Идентификатор контрагента.
     */
    void deleteCounterparty(Long id);

    /**
     * Удаление контрагента по его наименованию.
     *
     * @param name Наименование контрагента.
     */
    void deleteCounterpartyByName(String name);
}

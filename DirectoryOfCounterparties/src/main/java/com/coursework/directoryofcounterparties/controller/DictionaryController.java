package com.coursework.directoryofcounterparties.controller;

import com.coursework.directoryofcounterparties.service.DictionaryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coursework.directoryofcounterparties.model.Counterparty;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер, отвечающий за обработку запросов к справочнику контрагентов.
 */
@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

    private final DictionaryService dictionaryService;

    /**
     * Конструктор объекта DictionaryController в качестве параметра принимает DictionaryService.
     *
     * @param dictionaryService DictionaryService, который будет использоваться контроллером
     */
    public DictionaryController(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    /**
     * API для создания контрагента.
     *
     * @param counterparty Контрагент, который будет создан.
     * @return Созданный контрагент.
     */
    @PostMapping("/counterparty")
    public Counterparty createCounterparty(@RequestBody Counterparty counterparty) {
        return dictionaryService.createCounterparty(counterparty);
    }

    /**
     * API для изменения контрагента по идентификатору.
     *
     * @param id           Идентификатор контрагента, который будет изменен.
     * @param counterparty Контрагент с новыми данными.
     * @return Измененный контрагент.
     */
    @PutMapping("/counterparty/update/id/{id}")
    public Counterparty updateCounterparty(@PathVariable Long id, @RequestBody Counterparty counterparty) {
        return dictionaryService.updateCounterparty(id, counterparty);
    }

    /**
     * API для изменения контрагента по наименованию.
     *
     * @param name         Наименование контрагента, который будет изменен.
     * @param counterparty Контрагент с новыми данными.
     * @return Измененный контрагент.
     */
    @PutMapping("/counterparty/update/name/{name}")
    public Counterparty updateCounterpartByName(@PathVariable String name, @RequestBody Counterparty counterparty) {
        return dictionaryService.updateCounterpartyByName(name, counterparty);
    }

    /**
     * API для удаления контрагента по идентификатору.
     *
     * @param id Идентификатор контрагента, который будет удален.
     */
    @DeleteMapping("/counterparty/delete/id/{id}")
    public void deleteCounterparty(@PathVariable Long id) {
        dictionaryService.deleteCounterparty(id);
    }

    /**
     * API для удаления контрагента по наименованию.
     *
     * @param name Наименование контрагента, который будет удален.
     */
    @DeleteMapping("/counterparty/delete/name/{name}")
    public void deleteCounterpartyByName(@PathVariable String name) {
        dictionaryService.deleteCounterpartyByName(name);
    }
}

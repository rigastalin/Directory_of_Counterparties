package com.coursework.directoryofcounterparties.controller;

import com.coursework.directoryofcounterparties.model.Counterparty;
import com.coursework.directoryofcounterparties.service.LookupService;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер, отвечающий за поиск контрагентов.
 */
@RestController
@RequestMapping("/lookup")
public class LookupController {
    private final LookupService lookupService;

    /**
     * Конструктор экземпляра класса LookupController в качестве параметра принмает LookupService.
     *
     * @param lookupService LookupService, используемый контроллером для выполнения операций поиска.
     */
    public LookupController(LookupService lookupService) {
        this.lookupService = lookupService;
    }

    /**
     * API для поиска контрагента по наименованию.
     *
     * @param name Наименование контрагента.
     * @return Контрагент с указанным наименованием.
     */
    @GetMapping("/counterpartyByName")
    public Counterparty getCounterpartyByName(@RequestParam String name) {
        return lookupService.getCounterpartyByName(name);
    }

    /**
     * API для поиска контрагента по БИК и номеру счета.
     *
     * @param bik           БИК контрагента.
     * @param accountNumber Номер счета контрагента.
     * @return Контрагент, у которого совпадает указанный БИК и номер счета.
     */
    @GetMapping("/counterpartyByBikAndAccountNumber")
    public Counterparty getCounterpartyByBikAndAccountNumber(@RequestParam String bik, @RequestParam String accountNumber) {
        return lookupService.getCounterpartyByBikAndAccountNumber(bik, accountNumber);
    }
}

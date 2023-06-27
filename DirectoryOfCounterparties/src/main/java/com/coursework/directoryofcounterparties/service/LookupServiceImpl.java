package com.coursework.directoryofcounterparties.service;

import com.coursework.directoryofcounterparties.exception.CounterpartyNotFoundException;
import com.coursework.directoryofcounterparties.model.Counterparty;
import com.coursework.directoryofcounterparties.repository.CounterpartyRepository;
import org.springframework.stereotype.Service;

/**
 * Реализация сервиса для поиска контрагентов.
 */
@Service
public class LookupServiceImpl implements LookupService {
    private final CounterpartyRepository counterpartyRepository;

    /**
     * Конструктор экземпляра класса LookupServiceImpl. В качестве параметра принимает репозиторий контрагентов.
     *
     * @param counterpartyRepository репозиторий контрагентов, используемый сервисом для выполнения операций поиска.
     */
    public LookupServiceImpl(CounterpartyRepository counterpartyRepository) {
        this.counterpartyRepository = counterpartyRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Counterparty getCounterpartyByName(String name) {
        return counterpartyRepository.findByName(name)
                .orElseThrow(() -> new CounterpartyNotFoundException("Counterparty not found with name: " + name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Counterparty getCounterpartyByBikAndAccountNumber(String bik, String accountNumber) {
        return counterpartyRepository.findByBikAndAccountNumber(bik, accountNumber)
                .orElseThrow(() -> new CounterpartyNotFoundException("Counterparty not found with bik: " + bik + " and account number: " + accountNumber));
    }
}

package com.coursework.directoryofcounterparties.service;

import com.coursework.directoryofcounterparties.exception.CounterpartyNotFoundException;
import com.coursework.directoryofcounterparties.model.Counterparty;
import com.coursework.directoryofcounterparties.repository.CounterpartyRepository;
import org.springframework.stereotype.Service;

/**
 * Реализация сервиса для управления сущностями контрагентов.
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {
    private final CounterpartyRepository counterpartyRepository;

    /**
     * Конструктор объекта DictionaryServiceImpl. В качестве аргумента принимает репозиторий контрагентов.
     *
     * @param counterpartyRepository репозиторий контрагентов, используемый сервисом
     */
    public DictionaryServiceImpl(CounterpartyRepository counterpartyRepository) {
        this.counterpartyRepository = counterpartyRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Counterparty createCounterparty(Counterparty counterparty) {
        return counterpartyRepository.save(counterparty);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Counterparty updateCounterparty(Long id, Counterparty counterparty) {
        Counterparty existingCounterparty = counterpartyRepository.findById(id)
                .orElseThrow(() -> new CounterpartyNotFoundException("Counterparty not found with id: " + id));
        existingCounterparty.setName(counterparty.getName());
        existingCounterparty.setInn(counterparty.getInn());
        existingCounterparty.setKpp(counterparty.getKpp());
        existingCounterparty.setAccountNumber(counterparty.getAccountNumber());
        existingCounterparty.setBik(counterparty.getBik());
        return counterpartyRepository.save(existingCounterparty);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Counterparty updateCounterpartyByName(String name, Counterparty counterparty) {
        Counterparty existingCounterparty = counterpartyRepository.findByName(name)
                .orElseThrow(() -> new CounterpartyNotFoundException("Counterparty not found with name: " + name));
        existingCounterparty.setName(counterparty.getName());
        existingCounterparty.setInn(counterparty.getInn());
        existingCounterparty.setKpp(counterparty.getKpp());
        existingCounterparty.setAccountNumber(counterparty.getAccountNumber());
        existingCounterparty.setBik(counterparty.getBik());
        return counterpartyRepository.save(existingCounterparty);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteCounterparty(Long id) {
        counterpartyRepository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteCounterpartyByName(String name) {
        Counterparty existingCounterparty = counterpartyRepository.findByName(name)
                .orElseThrow(() -> new CounterpartyNotFoundException("Counterparty not found with name: " + name));
        counterpartyRepository.delete(existingCounterparty);
    }
}

package com.coursework.directoryofcounterparties.repository;

import com.coursework.directoryofcounterparties.model.Counterparty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Репозиторий для доступа к сущностям контрагентов.
 */
@Repository
public interface CounterpartyRepository extends JpaRepository<Counterparty, Long> {

    /**
     * Поиск контрагента по наименованию.
     *
     * @param name Наименование контрагента.
     * @return Optional, содержащий найденного контрагента. Либо пустой, если контрагент не найден.
     */
    Optional<Counterparty> findByName(String name);

    /**
     * Поиск контрагента по БИК и номеру счета.
     *
     * @param bik           БИК контрагента.
     * @param accountNumber Номер счета контрагента.
     * @return Optional, содержащий найденного контрагента. Либо пустой, если контрагент не найден.
     */
    Optional<Counterparty> findByBikAndAccountNumber(String bik, String accountNumber);
}

package com.coursework.directoryofcounterparties.model;

import com.coursework.directoryofcounterparties.validator.*;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Модель контрагента.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "counterparties_db")
@Access(AccessType.FIELD)
public class Counterparty {
    /**
     * Id контрагента. Генерируется автоматически.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Наименование контрагента.
     */
    @Column(nullable = false, unique = true)
    @Size(max = 200)
    private String name;

    /**
     * ИНН (Идентификационный номер налогоплательщика) контрагента.
     * Должен состоять из 10 или 12 цифр.
     */
    @Column(nullable = false, unique = true)
    @Pattern(regexp = "\\d{10}|\\d{12}")
    private String inn;

    /**
     * КПП (Код причины постановки на учет) контрагента.
     * Должен состоять из 9 цифр.
     */
    @Column(nullable = false)
    @Size(min = 9, max = 9)
    @Pattern(regexp = "\\d{9}")
    private String kpp;

    /**
     * БИК (Банковский идентификационный код) банка контрагента.
     * Должен состоять из 9 цифр.
     * Подвергается дополнительной валидации с использованием аннотации @ValidBik.
     */
    @Column(nullable = false)
    @Size(min = 9, max = 9)
    @Pattern(regexp = "\\d{9}")
    @ValidBik
    private String bik;

    /**
     * Номер банковского счета контрагента.
     * Должен состоять из 20 цифр.
     * Подвергается дополнительной валидации с использованием аннотации @ValidAccountNumber.
     */
    @Column(nullable = false)
    @Pattern(regexp = "\\d{20}")
    @ValidAccountNumber(bikProvider = BikProviderImpl.class)
    private String accountNumber;
}

package com.coursework.directoryofcounterparties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Главный класс приложения "Directory of Counterparties".
 * Запускает приложение и конфигурирует основные компоненты.
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.coursework.directoryofcounterparties.repository")
public class DirectoryOfCounterpartiesApplication {

    /**
     * Метод запуска приложения.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        SpringApplication.run(DirectoryOfCounterpartiesApplication.class, args);
    }
}

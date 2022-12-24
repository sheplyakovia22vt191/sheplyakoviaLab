package tech.reliab.course.sheplyakovia.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Objects;

@Getter
@Setter
@Builder
public class Bank implements Entity{
    /** Id банка */
    private int id;

    /** Имя банка */
    private String name;

    /** Офисы */
    private ArrayList<BankOffice> bankOffices;

    /** Банкоматы */
    private ArrayList<BankAtm> bankATMS;

    /** Сотрудники */
    private ArrayList<Employee> employees;

    /** Кол-во клиентов */
    private ArrayList<User> clients;

    /** Рейтинг банка */
    private int rate;

    /** Всего денег в банке */
    private long moneyAmount;

    /** Процентная ставка */
    private int interestRate;

    @Override
    public String toString() {
        return "Bank {" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", offices count = " + bankOffices.size() +
                ", atms count = " + bankATMS.size() +
                ", employees count = " + employees.size() +
                ", clients count = " + clients.size() +
                ", rate = " + rate +
                ", money amount = " + moneyAmount +
                ", interest rate=" + interestRate +
                '}';
    }

    @Override
    public String getSimpleName() {
        return "Bank";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return id == bank.id && rate == bank.rate && moneyAmount == bank.moneyAmount && interestRate == bank.interestRate && Objects.equals(name, bank.name) && Objects.equals(bankOffices, bank.bankOffices) && Objects.equals(bankATMS, bank.bankATMS) && Objects.equals(employees, bank.employees) && Objects.equals(clients, bank.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, bankOffices, bankATMS, employees, clients, rate, moneyAmount, interestRate);
    }
}
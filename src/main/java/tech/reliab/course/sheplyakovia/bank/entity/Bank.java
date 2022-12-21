package tech.reliab.course.sheplyakovia.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@Builder
public class Bank {
    /** Id банка */
    private long id;

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
        return "Bank{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", offices count =" + bankOffices.size() +
                ", atms count = " + bankATMS.size() +
                ", employees count = " + employees.size() +
                ", clients count = " + clients.size() +
                ", rate = " + rate +
                ", money amount = " + moneyAmount +
                ", interest rate=" + interestRate +
                '}';
    }
}
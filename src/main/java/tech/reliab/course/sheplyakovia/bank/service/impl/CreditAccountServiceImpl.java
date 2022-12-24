package tech.reliab.course.sheplyakovia.bank.service.impl;

import tech.reliab.course.sheplyakovia.bank.entity.*;
import tech.reliab.course.sheplyakovia.bank.service.CreditAccountService;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class CreditAccountServiceImpl implements CreditAccountService {

    private int id = 0;
    private final ArrayList<CreditAccount> creditAccounts = new ArrayList<>(0);


    /**
     * Создает объект кредитного счета.
     *  @param user           Пользователь кредитного счета.
     * @param bankName       Имя банка.
     * @param creditBegin    Дата начала кредита
     * @param creditEnd      Дата окончания кредита
     * @param creditAmount   Сумма кредита.
     * @param mouthPayment   Ежемесячный платеж.
     * @param employee       Сотрудник, который выдал кредит.
     * @param paymentAccount Платежный счет в банке с которого будет осуществляться погашени данного кредита
     * @param bank           Банк, где взят кредит
     * @return
     */
    @Override
    public CreditAccount create(User user, String bankName, LocalDate creditBegin, LocalDate creditEnd,
                                Long creditAmount, Long mouthPayment, Employee employee,
                                PaymentAccount paymentAccount, Bank bank) {

        CreditAccount creditAccount = CreditAccount
                .builder()
                .id(this.id++)
                .user(user)
                .bank(bank)
                .creditStart(creditBegin)
                .creditEnd(creditEnd)
                .creditMonthCount(Period.between(creditBegin, creditEnd).getMonths())
                .creditAmount(creditAmount)
                .monthPayment(mouthPayment)
                .interestRate(bank.getInterestRate())
                .creditor(employee)
                .paymentAccount(paymentAccount)
                .build();

        user.getCreditAccounts().add(creditAccount);
        creditAccounts.add(creditAccount);
        return creditAccount;
    }

    /**
     * Возвращает объект кредитного счета.
     *
     * @param id Id кредитного счета.
     * @return Объект кредитного счета.
     */
    @Override
    public CreditAccount getCreditAccount(int id) {
        return this.creditAccounts.get(id);
    }

    /**
     * Обновляет объект кредитного счета
     *
     * @param userId        Id кредитного счета у пользователя.
     * @param id            Id кредитного счета.
     * @param creditAccount Новый кредитный счет.
     * @param user          Пользоваль кредитного счета.
     */
    @Override
    public void update(int userId, int id, CreditAccount creditAccount, User user) {
        user.getCreditAccounts().set(userId, creditAccount);
        this.creditAccounts.set(id, creditAccount);
    }

    /**
     * Удаляет объект кредитного счета.
     *
     * @param userId        Id кредитного счета у пользователя.
     * @param id            Id кредитного счета.
     * @param creditAccount Кредитный счет.
     * @param user          Пользоваль кредитного счета.
     */
    @Override
    public void delete(int userId, int id, CreditAccount creditAccount, User user) {
        user.getCreditAccounts().remove(userId);
        this.creditAccounts.remove(creditAccount);
    }

    /**
     *
     * @return Все кредитные счета.
     */
    @Override
    public ArrayList<CreditAccount> getCreditAccounts() {
        return this.creditAccounts;
    }
}

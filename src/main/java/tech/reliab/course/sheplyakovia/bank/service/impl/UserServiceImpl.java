package tech.reliab.course.sheplyakovia.bank.service.impl;

import tech.reliab.course.sheplyakovia.bank.entity.Bank;
import tech.reliab.course.sheplyakovia.bank.entity.CreditAccount;
import tech.reliab.course.sheplyakovia.bank.entity.PaymentAccount;
import tech.reliab.course.sheplyakovia.bank.entity.User;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.FCs;
import tech.reliab.course.sheplyakovia.bank.service.UserService;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

public class UserServiceImpl implements UserService {

    private int id = 0;
    private final ArrayList<User> users = new ArrayList<>(0);

    /**
     * Создает объект пользователя
     *
     * @param fcs       ФИО
     * @param workPlace Место работы
     */
    @Override
    public void create(FCs fcs, String workPlace, Bank bank) {
        Random random = new Random();
        var userIncome = random.nextInt(100_000);

        User user = User
                .builder()
                .id(id++)
                .fcs(fcs)
                .birthday(Date.from(Instant.now()))
                .workPlace(workPlace)
                .income(userIncome)
                .banks(new ArrayList<>(0))
                .paymentAccounts(new ArrayList<>(0))
                .creditAccounts(new ArrayList<>(0))
                .rate(userIncome / 10)
                .build();

        user.getBanks().add(bank);
        bank.getClients().add(user);
        users.add(user);
    }

    /**
     * Возвращает объект пользователя.
     *
     * @param id Id пользователя.
     * @return Объект пользователя
     */
    @Override
    public User getUser(int id) {
        return this.users.get(id);
    }

    /**
     * Обновляет пользователя.
     *
     * @param id   Id пользователя.
     * @param user Новый пользователь.
     */
    @Override
    public void update(int id, User user) {
        this.users.set(id, user);
    }

    /**
     * Удаляет объект пользователя.
     *
     * @param id Id пользователя.
     */
    @Override
    public void delete(int id) {
        this.users.remove(id);
    }

    /**
     * Добавляет банк пользователю.
     *
     * @param id   Id пользователя.
     * @param bank Банк, который нужно добавить.
     */
    @Override
    public void addBank(int id, Bank bank) {
        this.users.get(id).getBanks().add(bank);
    }

    /**
     * Удаляет банк у пользователя.
     *
     * @param id   Id пользователя.
     * @param bank Банк, который удалить.
     */
    @Override
    public void deleteBank(int id, Bank bank) {
        this.users.get(id).getBanks().remove(bank);
    }

    /**
     * Добавляет кредитный аккаунт пользователю.
     *
     * @param id            ID пользователя.
     * @param creditAccount Кредитный аккаунт.
     */
    @Override
    public void addCreditAccount(int id, CreditAccount creditAccount) {
        this.users.get(id).getCreditAccounts().add(creditAccount);
    }

    /**
     * Удаялет кредитный аккаунт у пользователя.
     *
     * @param id            ID пользователя.
     * @param creditAccount Кредитный аккаунт.
     */
    @Override
    public void deleteCreditAccount(int id, CreditAccount creditAccount) {
        this.users.get(id).getCreditAccounts().remove(creditAccount);
    }

    /**
     * Добавляет платежный аккаунт пользователю.
     *
     * @param id             ID пользователя.
     * @param paymentAccount Платежный аккаунт.
     */
    @Override
    public void addPaymentAccount(int id, PaymentAccount paymentAccount) {
        this.users.get(id).getPaymentAccounts().add(paymentAccount);
    }

    /**
     * Удаляет платежный аккаунт у пользователя.
     *
     * @param id             ID пользователя.
     * @param paymentAccount Платежный аккаунт.
     */
    @Override
    public void deletePaymentAccount(int id, PaymentAccount paymentAccount) {
        this.users.get(id).getPaymentAccounts().remove(paymentAccount);
    }
}
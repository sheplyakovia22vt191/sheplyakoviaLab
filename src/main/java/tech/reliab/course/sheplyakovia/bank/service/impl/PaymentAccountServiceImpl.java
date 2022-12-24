package tech.reliab.course.sheplyakovia.bank.service.impl;

import tech.reliab.course.sheplyakovia.bank.entity.Bank;
import tech.reliab.course.sheplyakovia.bank.entity.PaymentAccount;
import tech.reliab.course.sheplyakovia.bank.entity.User;
import tech.reliab.course.sheplyakovia.bank.service.PaymentAccountService;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class PaymentAccountServiceImpl implements PaymentAccountService {

    private int id = 0;
    private final ArrayList<PaymentAccount> paymentAccounts = new ArrayList<>(0);

    /**
     * Создает объект платёжного счета.
     *
     * @param user Воаделец платёжного счета.
     * @param bank Банк, в котором открыт платёжный счет.
     */
    @Override
    public void create(User user, Bank bank) {
        Random random = new Random();

        PaymentAccount paymentAccount = PaymentAccount
                .builder()
                .id(this.id++)
                .user(user)
                .bank(bank)
                .moneyAmount(random.nextInt(500_000))
                .build();

        user.getPaymentAccounts().add(paymentAccount);
        paymentAccounts.add(paymentAccount);
    }

    /**
     * Возвращает объект платёжного счета.
     *
     * @param id Id платёжного счета
     * @return Объект платёжного счета.
     */
    @Override
    public PaymentAccount getPaymentAccount(int id) {
        return this.paymentAccounts.get(id);
    }

    /**
     * Обновляет объект платёжного счета.
     *
     * @param userId         Id платёжного счета у пользователя.
     * @param id             Id платёжного счета.
     * @param paymentAccount Новый платёжный счет.
     * @param user           Пользоваль платёжного счета.
     */
    @Override
    public void update(int userId, int id, PaymentAccount paymentAccount, User user) {
        user.getPaymentAccounts().set(userId, paymentAccount);
        this.paymentAccounts.set(id, paymentAccount);
    }

    /**
     * Удаляет объект платёжного счета.
     *
     * @param userId         Id платёжного счета у пользователя.
     * @param id             Id платёжного счета.
     * @param paymentAccount Платёжный счет.
     * @param user           Пользоваль платёжного счета.
     */
    @Override
    public void delete(int userId, int id, PaymentAccount paymentAccount, User user) {
        user.getPaymentAccounts().remove(userId);
        this.paymentAccounts.remove(paymentAccount);
    }

    /**
     *
     * @return Все платёжные счета.
     */
    @Override
    public ArrayList<PaymentAccount> getPaymentAccounts() {
        return this.paymentAccounts;
    }
}

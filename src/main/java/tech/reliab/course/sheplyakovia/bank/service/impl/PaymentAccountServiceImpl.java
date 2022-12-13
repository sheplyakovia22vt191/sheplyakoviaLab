package tech.reliab.course.sheplyakovia.bank.service.impl;

import tech.reliab.course.sheplyakovia.bank.entity.Bank;
import tech.reliab.course.sheplyakovia.bank.entity.PaymentAccount;
import tech.reliab.course.sheplyakovia.bank.entity.User;
import tech.reliab.course.sheplyakovia.bank.service.PaymentAccountService;

import java.util.Objects;
import java.util.Random;

public class PaymentAccountServiceImpl implements PaymentAccountService {

    private PaymentAccount paymentAccount;
    private Long id = 0L;
    @Override
    public PaymentAccount create(User user, Bank bank) {
        Random random = new Random();

        this.paymentAccount = PaymentAccount
                .builder()
                .id(this.id++)
                .user(user)
                .bank(bank)
                .moneyAmount(random.nextInt(100_000))
                .build();

        return this.paymentAccount;
    }

    @Override
    public PaymentAccount getPaymentAccount() {
        return this.paymentAccount;
    }

    @Override
    public void update(PaymentAccount paymentAccounts) {
        this.paymentAccount = paymentAccounts;
    }

    @Override
    public void delete(PaymentAccount paymentAccount) {
        if (Objects.equals(this.paymentAccount, paymentAccount)) {
            this.paymentAccount = null;
        }
    }
}

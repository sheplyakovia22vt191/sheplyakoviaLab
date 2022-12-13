package tech.reliab.course.sheplyakovia.bank.service;

import tech.reliab.course.sheplyakovia.bank.entity.Bank;
import tech.reliab.course.sheplyakovia.bank.entity.PaymentAccount;
import tech.reliab.course.sheplyakovia.bank.entity.User;

public interface PaymentAccountService {
    PaymentAccount create(User user, Bank bank);

    PaymentAccount getPaymentAccount();

    void update(PaymentAccount paymentAccount);
    void delete(PaymentAccount paymentAccount);
}

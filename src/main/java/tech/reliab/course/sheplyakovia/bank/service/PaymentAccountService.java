package tech.reliab.course.sheplyakovia.bank.service;

import tech.reliab.course.sheplyakovia.bank.entity.Bank;
import tech.reliab.course.sheplyakovia.bank.entity.PaymentAccount;
import tech.reliab.course.sheplyakovia.bank.entity.User;

public interface PaymentAccountService {
    void create(User user, Bank bank);
    PaymentAccount getPaymentAccount(int id);
    void update(int userId, int id, PaymentAccount paymentAccount, User user);
    void delete(int userId, int id, PaymentAccount paymentAccount, User user);
}

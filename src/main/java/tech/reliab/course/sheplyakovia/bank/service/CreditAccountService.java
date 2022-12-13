package tech.reliab.course.sheplyakovia.bank.service;

import tech.reliab.course.sheplyakovia.bank.entity.*;

import java.time.LocalDate;

public interface CreditAccountService {
    CreditAccount create(User user, String bankName, LocalDate creditBegin, LocalDate creditEnd, Long creditAmount,
                         Long mouthPayment, Employee employee, PaymentAccount paymentAccount, Bank bank);

    CreditAccount getCreditAccount();

    void update(CreditAccount creditAccount);

    void delete(CreditAccount creditAccount);
}

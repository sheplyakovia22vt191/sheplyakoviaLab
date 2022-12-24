package tech.reliab.course.sheplyakovia.bank.service;

import tech.reliab.course.sheplyakovia.bank.entity.*;

import java.time.LocalDate;
import java.util.ArrayList;

public interface CreditAccountService {
    CreditAccount create(User user, String bankName, LocalDate creditBegin, LocalDate creditEnd, Long creditAmount,
                         Long mouthPayment, Employee employee, PaymentAccount paymentAccount, Bank bank);
    CreditAccount getCreditAccount(int id);
    void update(int userId, int id, CreditAccount creditAccount, User user);
    void delete(int userId, int id, CreditAccount creditAccount, User user);

    ArrayList<CreditAccount> getCreditAccounts();
}

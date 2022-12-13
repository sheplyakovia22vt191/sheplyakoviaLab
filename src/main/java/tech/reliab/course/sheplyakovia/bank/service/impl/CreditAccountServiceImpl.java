package tech.reliab.course.sheplyakovia.bank.service.impl;

import tech.reliab.course.sheplyakovia.bank.entity.*;
import tech.reliab.course.sheplyakovia.bank.service.CreditAccountService;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class CreditAccountServiceImpl implements CreditAccountService {

    private CreditAccount creditAccount;
    private long id;

    @Override
    public CreditAccount create(User user, String bankName, LocalDate creditBegin, LocalDate creditEnd,
                                Long creditAmount, Long mouthPayment, Employee employee,
                                PaymentAccount paymentAccount, Bank bank) {

        this.creditAccount = CreditAccount
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
        return null;
    }

    @Override
    public CreditAccount getCreditAccount() {
        return this.creditAccount;
    }

    @Override
    public void update(CreditAccount creditAccount) {
        this.creditAccount = creditAccount;
    }

    @Override
    public void delete(CreditAccount creditAccount) {
        if (Objects.equals(this.creditAccount, creditAccount)) {
            this.creditAccount = null;
        }
    }
}

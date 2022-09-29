package tech.reliab.course.sheplyakovia.bank.entity;

import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.FIO;
import tech.reliab.course.sheplyakovia.bank.service.UserService;

import java.util.Date;
import java.util.Random;

public class User implements UserService {

    private int id;
    private FIO fio;
    private Date birthDate;
    private int monthlyIncome;
    private Bank bank;
    private CreditAccount creditAccount;
    private PaymentAccount paymentAccount;
    private int creditRating;

    public User(
            int id,
            FIO fio,
            Date birthDate,
            int monthlyIncome,
            Bank bank,
            CreditAccount creditAccount,
            PaymentAccount paymentAccount,
            int creditRating
    ) {
        Random random = new Random();

        this.id = random.nextInt();
        this.fio = fio;
        this.birthDate = birthDate;
        this.monthlyIncome = monthlyIncome;
        this.bank = bank;
        this.creditAccount = creditAccount;
        this.paymentAccount = paymentAccount;
        this.creditRating = creditRating;
    }

    public void updateUser(
            FIO fio,
            Date birthDate,
            int monthlyIncome,
            Bank bank,
            CreditAccount creditAccount,
            PaymentAccount paymentAccount,
            int creditRating
    ) {
        this.fio = fio;
        this.birthDate = birthDate;
        this.monthlyIncome = monthlyIncome;
        this.bank = bank;
        this.creditAccount = creditAccount;
        this.paymentAccount = paymentAccount;
        this.creditRating = creditRating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FIO getFio() {
        return fio;
    }

    public void setFio(FIO fio) {
        this.fio = fio;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public CreditAccount getCreditAccount() {
        return creditAccount;
    }

    public void setCreditAccount(CreditAccount creditAccount) {
        this.creditAccount = creditAccount;
    }

    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public int getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(int creditRating) {
        this.creditRating = creditRating;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fio=" + fio +
                ", birthDate=" + birthDate +
                ", monthlyIncome=" + monthlyIncome +
                ", bank=" + bank +
                ", creditAccount=" + creditAccount +
                ", paymentAccount=" + paymentAccount +
                ", creditRating=" + creditRating +
                '}';
    }
}

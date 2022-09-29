package tech.reliab.course.sheplyakovia.bank.entity;

import tech.reliab.course.sheplyakovia.bank.service.PaymentAccountService;

import java.util.Random;

public class PaymentAccount implements PaymentAccountService {
    private int id;
    private User user;
    private Bank bank;
    private int amount;

    public PaymentAccount(User user, Bank bank) {
        Random random = new Random();

        this.id = random.nextInt();
        this.user = user;
        this.bank = bank;
        this.amount = 0;
    }

    public void updatePaymentAccount(User user, Bank bank, int amount) {
        this.user = user;
        this.bank = bank;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PaymentAccount{" +
                "id=" + id +
                ", user=" + user +
                ", bank=" + bank +
                ", amount=" + amount +
                '}';
    }
}

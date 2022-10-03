package tech.reliab.course.sheplyakovia.bank;

import tech.reliab.course.sheplyakovia.bank.entity.Bank;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Tinkoff", 10, 23, 32, 43, 100_000_000);
        System.out.println(bank);
        bank = null;
    }
}

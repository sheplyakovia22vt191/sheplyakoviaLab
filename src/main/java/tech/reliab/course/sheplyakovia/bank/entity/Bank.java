package tech.reliab.course.sheplyakovia.bank.entity;

import tech.reliab.course.sheplyakovia.bank.service.BankService;

import java.util.Random;

public class Bank implements BankService {
    private int id;
    private String name;
    private int officeCount;
    private int atmCount;
    private int employeeCount;
    private int rating;
    private int allMoney;
    private int interestRate;

    public Bank(String name) {
        Random random = new Random();

        this.id = random.nextInt();
        this.name = name;
        this.officeCount = 0;
        this.atmCount = 0;
        this.employeeCount = 0;
        this.rating = random.nextInt(100);
        this.allMoney = random.nextInt(1_000_000);
        this.interestRate = countInterestRateByRating();
    }

    public int countInterestRateByRating() {
        if (this.rating == 0) {
            return 20;
        }
        return Math.ceilDiv(20, this.rating);
    }

    public void addOffice() {
        this.officeCount++;
    }

    public void addBankAtm() {
        this.atmCount++;
    }

    public void addEmployee() {
        this.employeeCount++;
    }
}

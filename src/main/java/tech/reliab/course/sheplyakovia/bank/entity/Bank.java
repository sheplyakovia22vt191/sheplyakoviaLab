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

    public Bank(String name, int officeCount, int atmCount, int employeeCount, int rating, int allMoney) {
        Random random = new Random();

        this.id = random.nextInt();
        this.name = name;
        this.officeCount = officeCount;
        this.atmCount = atmCount;
        this.employeeCount = employeeCount;
        this.rating = rating;
        this.allMoney = allMoney;
        this.interestRate = this.countInterestRateByRating();
    }

    public void updateBank(String name, int officeCount, int atmCount, int employeeCount, int rating, int allMoney, int interestRate) {
        this.name = name;
        this.officeCount = officeCount;
        this.atmCount = atmCount;
        this.employeeCount = employeeCount;
        this.rating = rating;
        this.allMoney = allMoney;
        this.interestRate = interestRate;
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

    public int getInterestRate() {
        return interestRate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOfficeCount() {
        return officeCount;
    }

    public void setOfficeCount(int officeCount) {
        this.officeCount = officeCount;
    }

    public int getAtmCount() {
        return atmCount;
    }

    public void setAtmCount(int atmCount) {
        this.atmCount = atmCount;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getAllMoney() {
        return allMoney;
    }

    public void setAllMoney(int allMoney) {
        this.allMoney = allMoney;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", officeCount=" + officeCount +
                ", atmCount=" + atmCount +
                ", employeeCount=" + employeeCount +
                ", rating=" + rating +
                ", allMoney=" + allMoney +
                ", interestRate=" + interestRate +
                '}';
    }
}

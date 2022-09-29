package tech.reliab.course.sheplyakovia.bank.entity;

import tech.reliab.course.sheplyakovia.bank.service.CreditAccountService;

import java.util.Date;
import java.util.Random;

public class CreditAccount implements CreditAccountService {
    private int id;
    private User user;
    private Bank bank;
    private Date startDate;
    private Date endDate;
    private int countMonth;
    private int loanAmount;
    private int monthlyPayment;
    private int interestRate;
    private String employeeIssuedLoan;
    private int bankPaymentAccount;


    public void updateCreditAccount(
            User user,
            Bank bank,
            Date startDate,
            Date endDate,
            int countMonth,
            int loanAmount,
            int monthlyPayment,
            String employeeIssuedLoan,
            int bankPaymentAccount
    ) {
        this.user = user;
        this.bank = bank;
        this.startDate = startDate;
        this.endDate = endDate;
        this.countMonth = countMonth;
        this.loanAmount = loanAmount;
        this.monthlyPayment = monthlyPayment;
        this.interestRate = bank.getInterestRate();
        this.employeeIssuedLoan = employeeIssuedLoan;
        this.bankPaymentAccount = bankPaymentAccount;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getCountMonth() {
        return countMonth;
    }

    public void setCountMonth(int countMonth) {
        this.countMonth = countMonth;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(int monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public String getEmployeeIssuedLoan() {
        return employeeIssuedLoan;
    }

    public void setEmployeeIssuedLoan(String employeeIssuedLoan) {
        this.employeeIssuedLoan = employeeIssuedLoan;
    }

    public int getBankPaymentAccount() {
        return bankPaymentAccount;
    }

    public void setBankPaymentAccount(int bankPaymentAccount) {
        this.bankPaymentAccount = bankPaymentAccount;
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                "id=" + id +
                ", user=" + user +
                ", bank=" + bank +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", countMonth=" + countMonth +
                ", loanAmount=" + loanAmount +
                ", monthlyPayment=" + monthlyPayment +
                ", interestRate=" + interestRate +
                ", employeeIssuedLoan='" + employeeIssuedLoan + '\'' +
                ", bankPaymentAccount=" + bankPaymentAccount +
                '}';
    }
}

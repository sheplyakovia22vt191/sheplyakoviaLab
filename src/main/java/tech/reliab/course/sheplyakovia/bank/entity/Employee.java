package tech.reliab.course.sheplyakovia.bank.entity;

import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.FIO;
import tech.reliab.course.sheplyakovia.bank.service.EmployeeService;

import java.util.Date;
import java.util.Random;

public class Employee implements EmployeeService {
    private int id;
    private FIO fio;
    private Date birthDate;
    private String post;
    private Bank bank;
    private String officeOrRemotely;
    private String bankOffice;
    private Boolean canIssueLoans;
    private int salaryAmount;

    public Employee(
            FIO fio,
            Date birthDate,
            String post,
            Bank bank,
            String officeOrRemotely,
            String bankOffice,
            Boolean canIssueLoans,
            int salaryAmount
    ) {

        Random random = new Random();
        this.id = random.nextInt();
        this.fio = fio;
        this.birthDate = birthDate;
        this.post = post;
        this.bank = bank;
        this.officeOrRemotely = officeOrRemotely;
        this.bankOffice = bankOffice;
        this.canIssueLoans = canIssueLoans;
        this.salaryAmount = salaryAmount;
    }

    public void updateEmployee(
            FIO fio,
            Date birthDate,
            String post,
            Bank bank,
            String officeOrRemotely,
            String bankOffice,
            Boolean canIssueLoans,
            int salaryAmount
    ) {
        this.fio = fio;
        this.birthDate = birthDate;
        this.post = post;
        this.bank = bank;
        this.officeOrRemotely = officeOrRemotely;
        this.bankOffice = bankOffice;
        this.canIssueLoans = canIssueLoans;
        this.salaryAmount = salaryAmount;
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getOfficeOrRemotely() {
        return officeOrRemotely;
    }

    public void setOfficeOrRemotely(String officeOrRemotely) {
        this.officeOrRemotely = officeOrRemotely;
    }

    public String getBankOffice() {
        return bankOffice;
    }

    public void setBankOffice(String bankOffice) {
        this.bankOffice = bankOffice;
    }

    public Boolean getCanIssueLoans() {
        return canIssueLoans;
    }

    public void setCanIssueLoans(Boolean canIssueLoans) {
        this.canIssueLoans = canIssueLoans;
    }

    public int getSalaryAmount() {
        return salaryAmount;
    }

    public void setSalaryAmount(int salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fio=" + fio +
                ", birthDate=" + birthDate +
                ", post='" + post + '\'' +
                ", bank=" + bank +
                ", officeOrRemotely='" + officeOrRemotely + '\'' +
                ", bankOffice='" + bankOffice + '\'' +
                ", canIssueLoans=" + canIssueLoans +
                ", salaryAmount=" + salaryAmount +
                '}';
    }
}

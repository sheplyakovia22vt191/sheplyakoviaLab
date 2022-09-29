package tech.reliab.course.sheplyakovia.bank.entity;

import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.Address;
import tech.reliab.course.sheplyakovia.bank.service.BankOfficeService;

import java.util.Random;

public class BankOffice implements BankOfficeService {
    private int id;
    private String name;
    private Address address;
    private Boolean isWork;
    private Boolean isPossibleToPlaceAtm;
    private int countBank;
    private Boolean isPossibleToApplyLoan;
    private Boolean isWorkForIssuingMoney;
    private Boolean isItPossibleToDepositMoney;
    private int countMoney;
    private int costRenting;

    public BankOffice(
            String name,
            Address address,
            Boolean isWork,
            Boolean isPossibleToPlaceAtm,
            int countBank,
            Boolean isPossibleToApplyLoan,
            Boolean isWorkForIssuingMoney,
            Boolean isItPossibleToDepositMoney,
            int countMoney,
            int costRenting
    ) {
        Random random = new Random();

        this.id = random.nextInt();
        this.name = name;
        this.address = address;
        this.isWork = isWork;
        this.isPossibleToPlaceAtm = isPossibleToPlaceAtm;
        this.countBank = countBank;
        this.isPossibleToApplyLoan = isPossibleToApplyLoan;
        this.isWorkForIssuingMoney = isWorkForIssuingMoney;
        this.isItPossibleToDepositMoney = isItPossibleToDepositMoney;
        this.countMoney = countMoney;
        this.costRenting = costRenting;
    }

    public void updateBankOffice(
            String name,
            Address address,
            Boolean isWork,
            Boolean isPossibleToPlaceAtm,
            int countBank,
            Boolean isPossibleToApplyLoan,
            Boolean isWorkForIssuingMoney,
            Boolean isItPossibleToDepositMoney,
            int countMoney,
            int costRenting
    ) {
        this.name = name;
        this.address = address;
        this.isWork = isWork;
        this.isPossibleToPlaceAtm = isPossibleToPlaceAtm;
        this.countBank = countBank;
        this.isPossibleToApplyLoan = isPossibleToApplyLoan;
        this.isWorkForIssuingMoney = isWorkForIssuingMoney;
        this.isItPossibleToDepositMoney = isItPossibleToDepositMoney;
        this.countMoney = countMoney;
        this.costRenting = costRenting;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Boolean getWork() {
        return isWork;
    }

    public void setWork(Boolean work) {
        isWork = work;
    }

    public Boolean getPossibleToPlaceAtm() {
        return isPossibleToPlaceAtm;
    }

    public void setPossibleToPlaceAtm(Boolean possibleToPlaceAtm) {
        isPossibleToPlaceAtm = possibleToPlaceAtm;
    }

    public int getCountBank() {
        return countBank;
    }

    public void setCountBank(int countBank) {
        this.countBank = countBank;
    }

    public Boolean getPossibleToApplyLoan() {
        return isPossibleToApplyLoan;
    }

    public void setPossibleToApplyLoan(Boolean possibleToApplyLoan) {
        isPossibleToApplyLoan = possibleToApplyLoan;
    }

    public Boolean getWorkForIssuingMoney() {
        return isWorkForIssuingMoney;
    }

    public void setWorkForIssuingMoney(Boolean workForIssuingMoney) {
        isWorkForIssuingMoney = workForIssuingMoney;
    }

    public Boolean getItPossibleToDepositMoney() {
        return isItPossibleToDepositMoney;
    }

    public void setItPossibleToDepositMoney(Boolean itPossibleToDepositMoney) {
        isItPossibleToDepositMoney = itPossibleToDepositMoney;
    }

    public int getCountMoney() {
        return countMoney;
    }

    public void setCountMoney(int countMoney) {
        this.countMoney = countMoney;
    }

    public int getCostRenting() {
        return costRenting;
    }

    public void setCostRenting(int costRenting) {
        this.costRenting = costRenting;
    }

    @Override
    public String toString() {
        return "BankOffice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", isWork=" + isWork +
                ", isPossibleToPlaceAtm=" + isPossibleToPlaceAtm +
                ", countBank=" + countBank +
                ", isPossibleToApplyLoan=" + isPossibleToApplyLoan +
                ", isWorkForIssuingMoney=" + isWorkForIssuingMoney +
                ", isItPossibleToDepositMoney=" + isItPossibleToDepositMoney +
                ", countMoney=" + countMoney +
                ", costRenting=" + costRenting +
                '}';
    }
}

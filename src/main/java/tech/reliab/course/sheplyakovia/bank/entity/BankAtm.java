package tech.reliab.course.sheplyakovia.bank.entity;

import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.Address;
import tech.reliab.course.sheplyakovia.bank.service.AtmService;

import java.util.Random;

public class BankAtm implements AtmService {
    private int id;
    private String name;
    private Address address;
    private String status;
    private Bank bank;
    private Address bankAddress;
    private Employee serviceEmployee;
    private Boolean isIssuingMoney;
    private Boolean isPossibleToDepositMoney;
    private int countMoney;
    private int serviceCost;

    public BankAtm(
            String name,
            Address address,
            String status,
            Bank bank,
            Address bankAddress,
            Employee serviceEmployee,
            Boolean isIssuingMoney,
            Boolean isPossibleToDepositMoney,
            int countMoney,
            int serviceCost
    ) {

        Random random = new Random();

        this.id = random.nextInt();
        this.name = name;
        this.address = address;
        this.status = status;
        this.bank = bank;
        this.bankAddress = bankAddress;
        this.serviceEmployee = serviceEmployee;
        this.isIssuingMoney = isIssuingMoney;
        this.isPossibleToDepositMoney = isPossibleToDepositMoney;
        this.countMoney = countMoney;
        this.serviceCost = serviceCost;
    }

    public void updateBankAtm(
            String name,
            Address address,
            String status,
            Bank bank,
            Address bankAddress,
            Employee serviceEmployee,
            Boolean isIssuingMoney,
            Boolean isPossibleToDepositMoney,
            int countMoney,
            int serviceCost
    ) {
        this.name = name;
        this.address = address;
        this.status = status;
        this.bank = bank;
        this.bankAddress = bankAddress;
        this.serviceEmployee = serviceEmployee;
        this.isIssuingMoney = isIssuingMoney;
        this.isPossibleToDepositMoney = isPossibleToDepositMoney;
        this.countMoney = countMoney;
        this.serviceCost = serviceCost;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Address getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(Address bankAddress) {
        this.bankAddress = bankAddress;
    }

    public Employee getServiceEmployee() {
        return serviceEmployee;
    }

    public void setServiceEmployee(Employee serviceEmployee) {
        this.serviceEmployee = serviceEmployee;
    }

    public Boolean getIssuingMoney() {
        return isIssuingMoney;
    }

    public void setIssuingMoney(Boolean issuingMoney) {
        isIssuingMoney = issuingMoney;
    }

    public Boolean getPossibleToDepositMoney() {
        return isPossibleToDepositMoney;
    }

    public void setPossibleToDepositMoney(Boolean possibleToDepositMoney) {
        isPossibleToDepositMoney = possibleToDepositMoney;
    }

    public int getCountMoney() {
        return countMoney;
    }

    public void setCountMoney(int countMoney) {
        this.countMoney = countMoney;
    }

    public int getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(int serviceCost) {
        this.serviceCost = serviceCost;
    }

    @Override
    public String toString() {
        return "BankAtm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", status='" + status + '\'' +
                ", bank=" + bank +
                ", bankAddress=" + bankAddress +
                ", serviceEmployee=" + serviceEmployee +
                ", isIssuingMoney=" + isIssuingMoney +
                ", isPossibleToDepositMoney=" + isPossibleToDepositMoney +
                ", countMoney=" + countMoney +
                ", serviceCost=" + serviceCost +
                '}';
    }
}

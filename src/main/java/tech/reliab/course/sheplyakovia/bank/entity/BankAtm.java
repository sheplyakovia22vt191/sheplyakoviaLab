package tech.reliab.course.sheplyakovia.bank.entity;

import tech.reliab.course.sheplyakovia.bank.service.AtmService;

import java.util.Random;

public class BankAtm implements AtmService {
    private int id;
    private String name;
    private String address;
    private String status;
    private Bank bank;
    private String bankAddress;
    private Employee serviceEmployee;
    private Boolean isIssuingMoney;
    private Boolean isPossibleToDepositMoney;
    private int countMoney;
    private int serviceCost;

    public BankAtm(int id,
                   String name,
                   String address,
                   String status,
                   Bank bank,
                   String bankAddress,
                   Employee serviceEmployee,
                   Boolean isIssuingMoney,
                   Boolean isPossibleToDepositMoney,
                   int countMoney,
                   int serviceCost) {

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
}

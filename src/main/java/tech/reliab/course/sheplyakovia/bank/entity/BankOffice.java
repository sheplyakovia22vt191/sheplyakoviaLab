package tech.reliab.course.sheplyakovia.bank.entity;

import tech.reliab.course.sheplyakovia.bank.service.BankOfficeService;

import java.util.Random;

public class BankOffice implements BankOfficeService {
    private int id;
    private String name;
    private String address;
    private Boolean isWork;
    private Boolean isPossibleToPlaceAtm;
    private int countBank;
    private Boolean isPossibleToApplyLoan;
    private Boolean isWorkForIssuingMoney;
    private Boolean isItPossibleToDepositMoney;
    private int countMoney;
    private int costRenting;


    public BankOffice(int id,
                      String name,
                      String address,
                      Boolean isWork,
                      Boolean isPossibleToPlaceAtm,
                      int countBank,
                      Boolean isPossibleToApplyLoan,
                      Boolean isWorkForIssuingMoney,
                      Boolean isItPossibleToDepositMoney,
                      int countMoney,
                      int costRenting) {
        Random random = new Random();

        this.id = id;
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
}

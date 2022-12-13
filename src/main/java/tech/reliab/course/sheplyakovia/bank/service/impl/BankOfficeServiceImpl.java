package tech.reliab.course.sheplyakovia.bank.service.impl;

import tech.reliab.course.sheplyakovia.bank.entity.Bank;
import tech.reliab.course.sheplyakovia.bank.entity.BankOffice;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.Address;
import tech.reliab.course.sheplyakovia.bank.enums.WorkStatus;
import tech.reliab.course.sheplyakovia.bank.service.BankOfficeService;

import java.util.Objects;
import java.util.Random;

public class BankOfficeServiceImpl implements BankOfficeService {
    private BankOffice bankOffice;
    private Random random = new Random();
    private long id;


    @Override
    public BankOffice create(String name, Address address, Bank bank) {
        this.bankOffice = BankOffice
                .builder()
                .id(this.id++)
                .name(name)
                .address(address)
                .status(WorkStatus.getRandomStatus())
                .placeAtmAvailable(random.nextBoolean())
                .atmCount(bank.getAtmCount())
                .creditAvailable(random.nextBoolean())
                .extradition(random.nextBoolean())
                .introduction(random.nextBoolean())
                .moneyAmount(bank.getMoneyAmount())
                .rentCost(random.nextInt(100_000))
                .bank(bank)
                .build();
        return bankOffice;
    }

    @Override
    public BankOffice getBankOffice() {
        return this.bankOffice;
    }

    @Override
    public void update(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    @Override
    public void delete(BankOffice bankOffice) {
        if(Objects.equals(this.bankOffice, bankOffice)) {
            this.bankOffice = null;
        }
    }
}

package tech.reliab.course.sheplyakovia.bank.service.impl;

import tech.reliab.course.sheplyakovia.bank.entity.Bank;
import tech.reliab.course.sheplyakovia.bank.service.BankService;

import java.util.Objects;
import java.util.Random;

public class BankServiceImpl implements BankService {

    private long id = 0;
    private Bank bank;
    /**
     * создает банк
     */
    @Override
    public Bank createBank(String name) {
        Random random = new Random();
        int rate = random.nextInt(100);

        this.bank = Bank
                .builder()
                .id(id++)
                .name(name)
                .officeCount(0)
                .atmCount(0)
                .employeeCount(0)
                .clientCount(0)
                .rate(rate)
                .moneyAmount(random.nextLong(1_000_000L))
                .interestRate((int) (20 - rate / 10D))
                .build();
        return bank;
    }
    @Override
    public Bank getBank() {
        return this.bank;
    }

    @Override
    public void update(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void delete(Bank bank) {
        if(Objects.equals(this.bank, bank)) {
            this.bank = null;
        }
    }

    @Override
    public void addAtm(Bank bank) {
        int bankAtmCount = bank.getAtmCount();
        bank.setAtmCount(++bankAtmCount);
        this.update(bank);
    }

    @Override
    public void deleteAtm(Bank bank) {
        int bankAtmCount = bank.getAtmCount();
        bank.setAtmCount(--bankAtmCount);
        this.update(bank);
    }

    @Override
    public void addBankOffice(Bank bank) {
        int officeCount = bank.getOfficeCount();
        bank.setOfficeCount(++officeCount);
        this.update(bank);
    }

    @Override
    public void deleteBankOffice(Bank bank) {
        int officeCount = bank.getOfficeCount();
        bank.setOfficeCount(--officeCount);
        this.update(bank);
    }

    @Override
    public void addEmployee(Bank bank) {
        int employeeCount = bank.getEmployeeCount();
        bank.setEmployeeCount(++employeeCount);
        this.update(bank);
    }

    @Override
    public void deleteEmployee(Bank bank) {
        var employeeCount = bank.getEmployeeCount();
        bank.setEmployeeCount(--employeeCount);
        this.update(bank);
    }

    @Override
    public void addClient(Bank bank) {
        int clientCount = bank.getClientCount();
        bank.setClientCount(++clientCount);
        this.update(bank);
    }

    @Override
    public void deleteClient(Bank bank) {
        int clientCount = bank.getClientCount();
        bank.setClientCount(--clientCount);
        this.update(bank);
    }
}

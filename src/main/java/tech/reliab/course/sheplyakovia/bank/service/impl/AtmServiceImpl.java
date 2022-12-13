package tech.reliab.course.sheplyakovia.bank.service.impl;

import tech.reliab.course.sheplyakovia.bank.entity.Bank;
import tech.reliab.course.sheplyakovia.bank.entity.BankAtm;
import tech.reliab.course.sheplyakovia.bank.entity.BankOffice;
import tech.reliab.course.sheplyakovia.bank.entity.Employee;
import tech.reliab.course.sheplyakovia.bank.enums.WorkStatus;
import tech.reliab.course.sheplyakovia.bank.service.AtmService;
import tech.reliab.course.sheplyakovia.bank.service.BankService;

import java.util.Objects;
import java.util.Random;

public class AtmServiceImpl implements AtmService {
    private long id = 0;
    Random random = new Random();
    private BankService bankService;
    BankAtm bankAtm;
    /**
     * Создает новый банкомат и увеличивает кол-ло банкоматов в банке
     */
    @Override
    public BankAtm create(String name, Bank bank, BankOffice office, Employee employee) {

        this.bankAtm = BankAtm
                .builder()
                .id(id++)
                .name(name)
                .location(office.getAddress())
                .status(WorkStatus.getRandomStatus())
                .bank(bank)
                .servingEmployee(employee)
                .extradition(random.nextBoolean())
                .introduction(random.nextBoolean())
                .moneyAmount(bank.getMoneyAmount())
                .build();

        return bankAtm;
    }

    @Override
    public BankAtm getBankAtm() {
        return bankAtm;
    }

    @Override
    public void delete(BankAtm bankAtm) {
        if(Objects.equals(this.bankAtm, bankAtm)) {
            this.bankAtm = null;
        }
    }

    @Override
    public void update(BankAtm bankAtm) {
        this.bankAtm = bankAtm;
    }
}

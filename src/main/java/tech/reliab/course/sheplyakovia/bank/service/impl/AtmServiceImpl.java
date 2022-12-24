package tech.reliab.course.sheplyakovia.bank.service.impl;

import tech.reliab.course.sheplyakovia.bank.entity.Bank;
import tech.reliab.course.sheplyakovia.bank.entity.BankAtm;
import tech.reliab.course.sheplyakovia.bank.entity.BankOffice;
import tech.reliab.course.sheplyakovia.bank.entity.Employee;
import tech.reliab.course.sheplyakovia.bank.enums.WorkStatus;
import tech.reliab.course.sheplyakovia.bank.service.AtmService;

import java.util.ArrayList;

import java.util.Random;

public class AtmServiceImpl implements AtmService {

    private int id = 0;
    private final ArrayList<BankAtm> bankAtms = new ArrayList<>(0);

    /**
     * @param name     Имя банкомата.
     * @param bank     Банк, которому принадлежит банкомат.
     * @param office   Офис, в котором находится банкомат.
     * @param employee Обслуживающий сотрудник.
     */
    @Override
    public BankAtm create(String name, Bank bank, BankOffice office, Employee employee) {
        Random random = new Random();

        BankAtm bankAtm = BankAtm
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

        bankAtms.add(bankAtm);
        bank.getBankATMS().add(bankAtm);
        office.getBankAtms().add(bankAtm);

        return bankAtm;
    }

    /**
     * Возвращает объект банкомата.
     *
     * @param id   Id банкомата.
     * @param bank Банк, которому пренадлежит банкомат.
     * @return Объект банкомата.
     */
    @Override
    public BankAtm getBankAtm(int id, Bank bank) {
        return bank.getBankATMS().get(id);
    }

    /**
     * Обновляет банкомат в банке.
     *
     * @param id      Id банкомата.
     * @param bank    Банк, которому пренадлежит банкомат.
     * @param bankAtm Новый банкомат.
     */
    @Override
    public void update(int id, Bank bank, BankAtm bankAtm) {
        bank.getBankATMS().set(id, bankAtm);
    }

    /**
     * Удаляет объект банкомата.
     *
     * @param bankAtm   Id банкомата.
     * @param bank Банк, которому пренадлежит банкомат.
     */
    @Override
    public void delete(BankAtm bankAtm, Bank bank) {
        bank.getBankATMS().remove(bankAtm);
        bankAtms.remove(bankAtm);
    }

    /**
     *
     * @return Все банкоматы.
     */
    @Override
    public ArrayList<BankAtm> getAtms() {
        return this.bankAtms;
    }
}

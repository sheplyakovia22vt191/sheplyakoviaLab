package tech.reliab.course.sheplyakovia.bank.service.impl;

import tech.reliab.course.sheplyakovia.bank.entity.Bank;
import tech.reliab.course.sheplyakovia.bank.entity.BankOffice;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.Address;
import tech.reliab.course.sheplyakovia.bank.enums.WorkStatus;
import tech.reliab.course.sheplyakovia.bank.service.BankOfficeService;

import java.util.ArrayList;
import java.util.Random;

public class BankOfficeServiceImpl implements BankOfficeService {
    private int id = 0;
    private final ArrayList<BankOffice> bankOffices = new ArrayList<>(0);


    /**
     * Создает объект банковского офиса.
     *
     * @param name    Название офиса.
     * @param address Адресс банковского офиса.
     * @param bank    Банк, к которому пренадлежит банковский офис.
     */
    @Override
    public BankOffice create(String name, Address address, Bank bank) {
        Random random = new Random();

        BankOffice bankOffice = BankOffice
                .builder()
                .id(this.id++)
                .name(name)
                .address(address)
                .status(WorkStatus.WORKING)
                .placeAtmAvailable(random.nextBoolean())
                .bankAtms(new ArrayList<>())
                .creditAvailable(true)
                .extradition(random.nextBoolean())
                .introduction(random.nextBoolean())
                .moneyAmount(bank.getMoneyAmount())
                .rentCost(random.nextInt(100_000))
                .bank(bank)
                .build();

        bank.getBankOffices().add(bankOffice);
        bankOffices.add(bankOffice);

        return bankOffice;
    }

    /**
     * Возвращает объект банковского офиса.
     *
     * @param id Id банковского офиса.
     * @return Банковский офис.
     */
    @Override
    public BankOffice getBankOffice(int id) {
        return this.bankOffices.get(id);
    }


    /**
     * Обновляет банковский офис в банке.
     *
     * @param id         Id банковского офиса.
     * @param bank       Банк, которому пренадлежит офис.
     * @param bankOffice Новый офис.
     */
    @Override
    public void update(int id, Bank bank, BankOffice bankOffice) {
        bank.getBankOffices().set(id, bankOffice);
    }

    /**
     * Удаляет объект банковского офиса.
     *
     * @param bankOffice Банковский офис.
     * @param bank       Банк, которому пренадлежит офис.
     */
    @Override
    public void delete(BankOffice bankOffice, Bank bank) {
        bank.getBankOffices().remove(bankOffice);
        bankOffices.remove(bankOffice);
    }

    /**
     *
     * @return Все банковские офисы.
     */
    @Override
    public ArrayList<BankOffice> getBankOffices() {
        return this.bankOffices;
    }
}
package tech.reliab.course.sheplyakovia.bank.service.impl;

import tech.reliab.course.sheplyakovia.bank.entity.*;
import tech.reliab.course.sheplyakovia.bank.service.BankService;

import java.util.ArrayList;
import java.util.Random;

public class BankServiceImpl implements BankService {

    private int id = 0;
    private final ArrayList<Bank> banks = new ArrayList<>(0);

    /**
     * Создает объект банка.
     *
     * @param name Имя банка.
     * @return
     */
    @Override
    public Bank createBank(String name) {
        Random random = new Random();
        int rate = random.nextInt(100);

        Bank bank = Bank
                .builder()
                .id(id++)
                .name(name)
                .bankOffices(new ArrayList<>())
                .bankATMS(new ArrayList<>())
                .employees(new ArrayList<>())
                .clients(new ArrayList<>())
                .rate(rate)
                .moneyAmount(random.nextLong(1_000_000L, 10_000_000L))
                .interestRate((int) (20 - rate / 10D))
                .build();

        this.banks.add(bank);
        return bank;
    }

    /**
     * Возвращает объект банка.
     *
     * @param id Id банка.
     * @return Объект банка.
     */
    @Override
    public Bank getBank(int id) {
        return this.banks.get(id);
    }

    /**
     * Обновляет объект банка.
     *
     * @param id   Id банка.
     * @param bank Новый объект банка.
     */
    @Override
    public void update(int id, Bank bank) {
        this.banks.set(id, bank);
    }

    /**
     * Удаляет объект банка.
     *
     * @param id ID банка, который нужно удалить.
     */
    @Override
    public void delete(int id) {
        this.banks.remove(id);
    }

    /**
     * Добавляет банкомат.
     *
     * @param id      Id банка.
     * @param bankAtm Банкомат, который нужно добавить.
     */
    @Override
    public void addAtm(int id, BankAtm bankAtm) {
        this.banks.get(id).getBankATMS().add(bankAtm);
    }

    /**
     * Удаляет банкомат в банке.
     *
     * @param id      Id банка.
     * @param bankAtm Банкомат, который нужно удалить.
     */
    @Override
    public void deleteAtm(int id, BankAtm bankAtm) {
        this.banks.get(id).getBankATMS().remove(bankAtm);
    }


    /**
     * Добавляет банковский офис.
     *
     * @param id         Id банка.
     * @param bankOffice Банковский офис, который нужно добавить.
     */
    @Override
    public void addBankOffice(int id, BankOffice bankOffice) {
        this.banks.get(id).getBankOffices().add(bankOffice);
    }


    /**
     * Удаляет банковский офис.
     *
     * @param id         Id банка.
     * @param bankOffice Банковский офис, который нужно удалить.
     */
    @Override
    public void deleteBankOffice(int id, BankOffice bankOffice) {
        this.banks.get(id).getBankOffices().remove(bankOffice);
    }

    /**
     * Добавляет сотрудника в банк.
     *
     * @param id       Id банка.
     * @param employee Сотрудник, которого нужно добавить.
     */
    @Override
    public void addEmployee(int id, Employee employee) {
        this.banks.get(id).getEmployees().add(employee);
    }

    /**
     * Удаляет сотрудника из банка.
     *
     * @param id       Id банка.
     * @param employee Сотрудник, которого нужно удалить.
     */
    @Override
    public void deleteEmployee(int id, Employee employee) {
        this.banks.get(id).getEmployees().remove(employee);
    }

    /**
     * Добавляет клиента в банк.
     *
     * @param id   Id банка.
     * @param user Клиент, которого нужно добавить.
     */
    @Override
    public void addClient(int id, User user) {
        this.banks.get(id).getClients().add(user);
    }

    /**
     * Удаляет клиента из банка.
     *
     * @param id   Id банка.
     * @param user Клиент, которого нужно удалить.
     */
    @Override
    public void deleteClient(int id, User user) {
        this.banks.get(id).getClients().remove(user);
    }

    /**
     *
     * @return Все банки.
     */
    @Override
    public ArrayList<Bank> getBanks() {
        return this.banks;
    }
}
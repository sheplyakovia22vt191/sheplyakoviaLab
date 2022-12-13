package tech.reliab.course.sheplyakovia.bank.service;

import tech.reliab.course.sheplyakovia.bank.entity.Bank;

public interface BankService {
    Bank createBank(String name);
    Bank getBank();
    void update(Bank bank);
    void delete(Bank bank);

    void addAtm(Bank bank);
    void deleteAtm(Bank bank);

    void addBankOffice(Bank bank);
    void deleteBankOffice(Bank bank);

    void addEmployee(Bank bank);
    void deleteEmployee(Bank bank);

    void addClient(Bank bank);
    void deleteClient(Bank bank);
}

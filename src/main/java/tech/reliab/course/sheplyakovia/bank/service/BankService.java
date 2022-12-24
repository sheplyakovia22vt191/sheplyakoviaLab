package tech.reliab.course.sheplyakovia.bank.service;

import tech.reliab.course.sheplyakovia.bank.entity.*;

import java.util.ArrayList;


public interface BankService {

    void createBank(String name);
    Bank getBank(int id);
    void update(int id, Bank bank);
    void delete(int id);

    void addAtm(int id, BankAtm bankAtm);
    void deleteAtm(int id, BankAtm bankAtm);

    void addBankOffice(int id, BankOffice bankOffice);
    void deleteBankOffice(int id, BankOffice bankOffice);

    void addEmployee(int id, Employee employee);
    void deleteEmployee(int id, Employee employee);

    void addClient(int id, User user);
    void deleteClient(int id, User user);

    ArrayList<Bank> getBanks();
}

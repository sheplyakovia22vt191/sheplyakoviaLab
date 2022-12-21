package tech.reliab.course.sheplyakovia.bank.service;

import tech.reliab.course.sheplyakovia.bank.entity.Bank;
import tech.reliab.course.sheplyakovia.bank.entity.BankAtm;
import tech.reliab.course.sheplyakovia.bank.entity.BankOffice;
import tech.reliab.course.sheplyakovia.bank.entity.Employee;

public interface AtmService {
    void create(String name, Bank bank, BankOffice office, Employee employee);
    BankAtm getBankAtm(int id, Bank bank);
    void delete(int id, Bank bank);
    void update(int id, Bank bank, BankAtm bankAtm);
}

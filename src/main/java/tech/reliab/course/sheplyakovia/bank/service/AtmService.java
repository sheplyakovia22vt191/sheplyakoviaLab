package tech.reliab.course.sheplyakovia.bank.service;

import tech.reliab.course.sheplyakovia.bank.entity.Bank;
import tech.reliab.course.sheplyakovia.bank.entity.BankAtm;
import tech.reliab.course.sheplyakovia.bank.entity.BankOffice;
import tech.reliab.course.sheplyakovia.bank.entity.Employee;

public interface AtmService {
    BankAtm create(String name, Bank bank, BankOffice office, Employee employee);
    BankAtm getBankAtm();
    void delete(BankAtm bankAtm);
    void update(BankAtm bankAtm);
}

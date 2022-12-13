package tech.reliab.course.sheplyakovia.bank.service;

import tech.reliab.course.sheplyakovia.bank.entity.Bank;
import tech.reliab.course.sheplyakovia.bank.entity.BankOffice;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.Address;

public interface BankOfficeService {
    BankOffice create(String name, Address address, Bank bank);
    BankOffice getBankOffice();
    void update(BankOffice bankOffice);
    void delete(BankOffice bankOffice);
}

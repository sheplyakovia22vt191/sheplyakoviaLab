package tech.reliab.course.sheplyakovia.bank.service;

import tech.reliab.course.sheplyakovia.bank.entity.Bank;
import tech.reliab.course.sheplyakovia.bank.entity.BankOffice;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.Address;

import java.util.ArrayList;

public interface BankOfficeService {
    BankOffice create(String name, Address address, Bank bank);
    BankOffice getBankOffice(int id);
    void update(int id, Bank bank, BankOffice bankOffice);
    void delete(BankOffice bankOffice, Bank bank);
    ArrayList<BankOffice> getBankOffices();
}

package tech.reliab.course.sheplyakovia.bank.service;

import tech.reliab.course.sheplyakovia.bank.entity.Bank;
import tech.reliab.course.sheplyakovia.bank.entity.BankOffice;
import tech.reliab.course.sheplyakovia.bank.entity.Employee;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.FCs;

public interface EmployeeService {
    Employee create(FCs fcs, String post, Bank bank, BankOffice office);
    Employee getEmployee();
    void update(Employee employee);
    void delete(Employee employee);
}

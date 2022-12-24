package tech.reliab.course.sheplyakovia.bank.service;

import tech.reliab.course.sheplyakovia.bank.entity.Bank;
import tech.reliab.course.sheplyakovia.bank.entity.BankOffice;
import tech.reliab.course.sheplyakovia.bank.entity.Employee;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.FCs;

import java.util.ArrayList;

public interface EmployeeService {
    void create(FCs fcs, String post, Bank bank, BankOffice office);
    Employee getEmployee(int id);
    void update(int id,Employee employee);
    void delete(Employee employee);
    ArrayList<Employee> getEmployees();
}

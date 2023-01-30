package tech.reliab.course.sheplyakovia.bank.service.impl;

import tech.reliab.course.sheplyakovia.bank.entity.Bank;
import tech.reliab.course.sheplyakovia.bank.entity.BankOffice;
import tech.reliab.course.sheplyakovia.bank.entity.Employee;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.FCs;
import tech.reliab.course.sheplyakovia.bank.service.EmployeeService;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class EmployeeServiceImpl implements EmployeeService {

    private int id = 0;
    private final ArrayList<Employee> employees = new ArrayList<>(0);

    @Override
    public Employee create(FCs fcs, String post, Bank bank, BankOffice office) {

        Random random = new Random();
        Employee employee = Employee
                .builder()
                .id(this.id++)
                .fcs(fcs)
                .birthday(Date.from(Instant.now()))
                .post(post)
                .bank(bank)
                .isRemotely(random.nextBoolean())
                .office(office)
                .creditAvailable(random.nextBoolean())
                .salary(random.nextInt(100_000))
                .build();

        bank.getEmployees().add(employee);
        this.employees.add(employee);
        return employee;
    }

    /**
     * Возвращает объект сотрудника.
     *
     * @param id Id сотрудника.
     * @return Объект сотрудника.
     */
    @Override
    public Employee getEmployee(int id) {
        return this.employees.get(id);
    }

    /**
     * Обновляет объект сотрудника.
     *
     * @param id       Id сотрудника.
     * @param employee Объект сотрудника.
     */
    @Override
    public void update(int id, Employee employee) {
        this.employees.set(id, employee);
    }

    /**
     * Удаляет сотрудника.
     *
     * @param employee Объект сотрудника, который нужно удалить.
     */
    @Override
    public void delete(Employee employee) {
        this.employees.remove(employee);
    }

    /**
     *
     * @return Все работяги.
     */
    @Override
    public ArrayList<Employee> getEmployees() {
        return this.employees;
    }
}

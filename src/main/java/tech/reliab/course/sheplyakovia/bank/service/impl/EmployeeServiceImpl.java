package tech.reliab.course.sheplyakovia.bank.service.impl;

import tech.reliab.course.sheplyakovia.bank.entity.Bank;
import tech.reliab.course.sheplyakovia.bank.entity.BankOffice;
import tech.reliab.course.sheplyakovia.bank.entity.Employee;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.FCs;
import tech.reliab.course.sheplyakovia.bank.service.EmployeeService;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

public class EmployeeServiceImpl implements EmployeeService {

    private Employee employee;
    private Long id = 0L;

    @Override
    public Employee create(FCs fcs, String post, Bank bank, BankOffice office) {

        Random random = new Random();
        employee = Employee
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
        return employee;
    }

    @Override
    public Employee getEmployee() {
        return this.employee;
    }

    @Override
    public void update(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void delete(Employee employee) {
        if (Objects.equals(this.employee, employee)) {
            this.employee = null;
        }
    }
}

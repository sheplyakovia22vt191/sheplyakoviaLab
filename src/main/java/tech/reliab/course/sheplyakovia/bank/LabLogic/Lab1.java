package tech.reliab.course.sheplyakovia.bank.LabLogic;

import tech.reliab.course.sheplyakovia.bank.ObjectsCreator;
import tech.reliab.course.sheplyakovia.bank.entity.*;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.Address;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.FCs;
import tech.reliab.course.sheplyakovia.bank.service.impl.*;

import java.time.LocalDate;

public class Lab1 {
    private final Address address;

    Lab1() {
        this.address = new Address(
                "Russia",
                "Belgorod",
                "Michurina",
                "41d"
        );
    }

    public void run() {
        var objectsCreator = new ObjectsCreator(
                new BankServiceImpl(),
                new AtmServiceImpl(),
                new BankOfficeServiceImpl(),
                new UserServiceImpl(),
                new EmployeeServiceImpl(),
                new CreditAccountServiceImpl(),
                new PaymentAccountServiceImpl(),
                this.address
        );
        objectsCreator.create();

        // Создает объект банка.
        Bank bank = objectsCreator.bankService.createBank("Tinkoff");

        // Создает объект офиса.
        BankOffice bankOffice = objectsCreator.bankOfficeService.create("Tinkoff bank office", this.address, bank);

        // Создает объект сотрудника.
        Employee employee = objectsCreator.employeeService.create(
                new FCs("Dmitry", "Ampilogov", "Vadimovich"),
                "Tester",
                bank,
                bankOffice
        );

        // Создает объект банкомата.
        BankAtm bankAtm = objectsCreator.atmService.create("Tinkoff atm", bank, bankOffice, employee);

        User user = objectsCreator.userService.create(
                new FCs("Igor", "Sheplyakov", "Alexandrovich"),
                "Programmer",
                bank
        );

        // Создает объект платёжного счета.
        PaymentAccount paymentAccount = objectsCreator.paymentAccountService.create(user, bank);

        // Создает объект кредитного счета.
        CreditAccount creditAccount = objectsCreator.creditAccountService.create(
                user,
                bank.getName(),
                LocalDate.of(2022, 2, 24),
                LocalDate.of(2022, 12, 24),
                100_000L,
                10_000L,
                employee,
                paymentAccount,
                bank
        );


        System.out.println(bank);
        System.out.println(bankOffice);
        System.out.println(employee);
        System.out.println(bankAtm);
        System.out.println(user);
        System.out.println(paymentAccount);
        System.out.println(creditAccount);

    }
}

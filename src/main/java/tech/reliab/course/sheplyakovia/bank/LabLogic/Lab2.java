package tech.reliab.course.sheplyakovia.bank.LabLogic;

import tech.reliab.course.sheplyakovia.bank.ObjectsCreator;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.Address;
import tech.reliab.course.sheplyakovia.bank.service.impl.*;

public class Lab2 {
    private final Address address;
    private final static int BANK_COUNT = 5;

    Lab2() {
        this.address = new Address(
                "Russia",
                "Moscow",
                "Lenina",
                "28"
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

        for (var i = 0; i < BANK_COUNT; i++) {
            System.out.println(objectsCreator.bankService.getBank(i));
        }

        for (var i = 0; i < 5; i++) {
            System.out.println(objectsCreator.userService.getUser(i));
        }
    }
}

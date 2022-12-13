package tech.reliab.course.sheplyakovia.bank;


import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.Address;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.FCs;
import tech.reliab.course.sheplyakovia.bank.service.*;
import tech.reliab.course.sheplyakovia.bank.service.impl.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Address address = new Address(
                "Russia",
                "Belgorod",
                "Orlova",
                "63"
        );


        // Bank
        BankService bankService = new BankServiceImpl();
        bankService.createBank("SberBank");

        // Bank office
        BankOfficeService bankOfficeService = new BankOfficeServiceImpl();
        bankOfficeService.create(
                "SberBankOffice",
                address,
                bankService.getBank()
        );

        // Employee
        FCs fcsEmployee = new FCs("Igor", "Sheplyakov", "Alexandrovich");
        EmployeeService employeeService = new EmployeeServiceImpl();
        employeeService.create(
                fcsEmployee,
                "Programmer",
                bankService.getBank(),
                bankOfficeService.getBankOffice()
        );

        //Bank ATM
        AtmService atmService = new AtmServiceImpl();
        atmService.create(
                "Vostochniy",
                bankService.getBank(),
                bankOfficeService.getBankOffice(),
                employeeService.getEmployee()
        );

        // User
        FCs fcsUser = new FCs("Ivan", "Ivanov", "Ivanovich");
        UserService userService = new UserServiceImpl();
        userService.create(
                fcsEmployee,
                "Programmer",
                bankService.getBank()
        );

        // Payment Account
        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
        paymentAccountService.create(
                userService.getUser(),
                bankService.getBank()
        );

        //Credit Account
        CreditAccountService creditAccountService = new CreditAccountServiceImpl();
        creditAccountService.create(
                userService.getUser(),
                userService.getUser().getBanks().getName(),
                LocalDate.of(2022, 10, 28),
                LocalDate.of(2023, 10, 28),
                60_000L,
                5_000L,
                employeeService.getEmployee(),
                paymentAccountService.getPaymentAccount(),
                bankService.getBank()

        );


        System.out.println(bankService.getBank());
        System.out.println(bankOfficeService.getBankOffice());
        System.out.println(employeeService.getEmployee());
        System.out.println(atmService.getBankAtm());
        System.out.println(userService.getUser());
        System.out.println(creditAccountService.getCreditAccount());
        System.out.println(paymentAccountService.getPaymentAccount());
    }
}

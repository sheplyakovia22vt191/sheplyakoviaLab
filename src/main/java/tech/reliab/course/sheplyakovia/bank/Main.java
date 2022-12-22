package tech.reliab.course.sheplyakovia.bank;


import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.Address;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.FCs;
import tech.reliab.course.sheplyakovia.bank.service.*;
import tech.reliab.course.sheplyakovia.bank.service.impl.*;

import java.time.LocalDate;

public class Main {
    private final static int BANK_COUNT = 5;
    private final static int ATM_COUNT = 3;
    private final static int EMPLOYEES_COUNT = 5;

    public static void main(String[] args) {
        lab2Main();
    }

    private static void lab3Main() {

    }

    private static void lab2Main() {
        BankService bankService = new BankServiceImpl();
        AtmService atmService = new AtmServiceImpl();
        BankOfficeService bankOfficeService = new BankOfficeServiceImpl();
        UserService userService = new UserServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();
        CreditAccountService creditAccountService = new CreditAccountServiceImpl();
        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();


        Address address = new Address(
                "Russia",
                "Belgorod",
                "Michurina",
                "41d"
        );


        // создаём 5 банков.
        for (int i = 0; i < BANK_COUNT; i++) {
            bankService.createBank("Bank " + i);

            // для каждого банка создаём 3 банкомата и 3 офиса.
            for (int j = 0; j < ATM_COUNT; j++) {

                bankOfficeService.create(
                        "BankOffice " + j,
                        address,
                        bankService.getBank(i)
                );

                // для каждого офиса создаем 5 сотрудников и 5 пользователей.
                for (int k = 0; k < EMPLOYEES_COUNT; k++) {
                    employeeService.create(
                            new FCs("Dmitry", "Ampilogov " + k, "Vadimovich"),
                            "Testers",
                            bankService.getBank(i),
                            bankOfficeService.getBankOffice(j)
                    );

                    userService.create(
                            new FCs("Igor", "Sheplyakov " + k, "Aleksandrovich"),
                            "MineCraft Mods Lead Developer",
                            bankService.getBank(i)
                    );

                    for (int h = 0; h < 2; h++) {
                        paymentAccountService.create(
                                userService.getUser(k),
                                bankService.getBank(i)
                        );
                        creditAccountService.create(
                                userService.getUser(k),
                                bankService.getBank(i).getName(),
                                LocalDate.now(),
                                LocalDate.now(),
                                100_100L,
                                20_000L,
                                employeeService.getEmployee(k),
                                paymentAccountService.getPaymentAccount(h),
                                bankService.getBank(i)
                        );
                    }

                }

                atmService.create(
                        "Atm " + j,
                        bankService.getBank(i),
                        bankOfficeService.getBankOffice(j),
                        employeeService.getEmployee(j)
                );
            }
        }

        for (var i = 0; i < BANK_COUNT; i++) {
            System.out.println(bankService.getBank(i));
        }

        for (var i = 0; i < 5; i++) {
            System.out.println(userService.getUser(i));
        }
    }
}

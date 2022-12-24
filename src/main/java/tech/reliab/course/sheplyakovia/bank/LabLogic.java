package tech.reliab.course.sheplyakovia.bank;

import tech.reliab.course.sheplyakovia.bank.entity.*;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.Address;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.FCs;
import tech.reliab.course.sheplyakovia.bank.enums.WorkStatus;
import tech.reliab.course.sheplyakovia.bank.exceptions.NotFoundException;
import tech.reliab.course.sheplyakovia.bank.service.*;
import tech.reliab.course.sheplyakovia.bank.service.impl.*;

import java.time.LocalDate;
import java.util.Scanner;

public class LabLogic {

    private final Scanner scanner = new Scanner(System.in);

    private final static int BANK_COUNT = 5;
    private final static int ATM_COUNT = 3;
    private final static int EMPLOYEES_COUNT = 5;
    private final Address address;

    public LabLogic() {

        this.address = new Address(
                "Russia",
                "Belgorod",
                "Michurina",
                "41d"
        );
    }

    public void run() {
        System.out.println("Choose a lab job(1 - 4)");

        var choose = -1;

        while (choose != 0) {
            choose = scanner.nextInt();

            switch (choose) {
                case 1 -> lab1();
                case 2 -> lab2();
                case 3 -> lab3();
                case 4 -> lab4();
            }
        }

    }


    private void lab1() {

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

        try {
            objectsCreator.bankService.createBank("Tinkoff");
            Bank bank = objectsCreator.bankService.getBank(0);


            objectsCreator.bankOfficeService.create("Tinkoff bank office", this.address, bank);
            BankOffice bankOffice = objectsCreator.bankOfficeService.getBankOffice(0);

            objectsCreator.employeeService.create(
                    new FCs("Dmitry", "Ampilogov", "Vadimovich"),
                    "Tester",
                    bank,
                    bankOffice
            );
            Employee employee = objectsCreator.employeeService.getEmployee(0);

            objectsCreator.atmService.create("Tinkoff atm", bank, bankOffice, employee);
            BankAtm bankAtm = objectsCreator.atmService.getBankAtm(0, bank);

            objectsCreator.userService.create(
                    new FCs("Igor", "Sheplyakov", "Alexandrovich"),
                    "Programmer",
                    bank
            );
            User user = objectsCreator.userService.getUser(0);

            objectsCreator.paymentAccountService.create(user, bank);
            PaymentAccount paymentAccount = objectsCreator.paymentAccountService.getPaymentAccount(0);

            objectsCreator.creditAccountService.create(
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
            CreditAccount creditAccount = objectsCreator.creditAccountService.getCreditAccount(0);


            System.out.println(bank);
            System.out.println(bankOffice);
            System.out.println(employee);
            System.out.println(bankAtm);
            System.out.println(user);
            System.out.println(paymentAccount);
            System.out.println(creditAccount);

        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void lab2() {
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

    private void lab3() {
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

        Bank userBank = objectsCreator.bankService.getBank(0);

        for (var bank : objectsCreator.bankService.getBanks()) {
            int bankUseFullAverage = bank.getEmployees().size() + bank.getBankATMS().size() + bank.getBankOffices().size();
            int userBankUseFullAverage = userBank.getEmployees().size() + userBank.getBankATMS().size() + userBank.getBankOffices().size();

            if ((bankUseFullAverage > userBankUseFullAverage) && (bank.getInterestRate() > userBank.getInterestRate())) {
                userBank = bank;
            }
        }

        UserService userService = new UserServiceImpl();
        userService.create(
                new FCs("Igor", "Sheplyakov", "Alexandrovixh"),
                "Programmer",
                userBank
        );

        User user = userService.getUser(0);

        long userMoneyAmount = 100_000L;

        BankOffice userBankOffice = userBank.getBankOffices().get(0);

        for (var bankOffice : userBank.getBankOffices()) {
            if (bankOffice.getStatus() == WorkStatus.WORKING) {
                if (bankOffice.isCreditAvailable()) {
                    if (bankOffice.getMoneyAmount() > userMoneyAmount) {
                        userBankOffice = bankOffice;
                    }
                }
            }
        }

//        objectsCreator.employeeService.create(
//                new FCs("Dmitry", "Ampilogov", "Vladimirovich"),
//                "Loh",
//                userBank,
//                userBankOffice
//        );

        Employee userEmployee = userBank.getEmployees().get(0);
        for (var employee : userBank.getEmployees()) {
            System.out.println(employee);
            if (employee.getOffice() == userBankOffice) {
                if (employee.isCreditAvailable()) {
                    userEmployee = employee;
                }
            }
        }

        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
        paymentAccountService.create(user, userBank);
        PaymentAccount userPaymentAccount = paymentAccountService.getPaymentAccount(0);

        if ((user.getRate() < 5_000) && (user.getRate() > 50)) {
            System.out.println("Fuck you, bitch. I will not give a credit.");
        } else {
            CreditAccountService creditAccountService = new CreditAccountServiceImpl();
            creditAccountService.create(
                    user,
                    userBank.getName(),
                    LocalDate.now(),
                    LocalDate.of(2023, 5, 24),
                    userMoneyAmount,
                    10_000L,
                    userEmployee,
                    userPaymentAccount,
                    userBank
            );
            System.out.println(user);
            System.out.println(creditAccountService.getCreditAccount(0));
            System.out.println(userBank);
            System.out.println(userBankOffice);
            System.out.println(userEmployee);
        }
    }

    private void lab4() {
        System.out.println("Lab 4");
    }
}

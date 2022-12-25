package tech.reliab.course.sheplyakovia.bank.LabLogic;

import tech.reliab.course.sheplyakovia.bank.ObjectsCreator;
import tech.reliab.course.sheplyakovia.bank.entity.*;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.Address;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.FCs;
import tech.reliab.course.sheplyakovia.bank.enums.BankTransaction;
import tech.reliab.course.sheplyakovia.bank.enums.CrudOperations;
import tech.reliab.course.sheplyakovia.bank.enums.WorkStatus;
import tech.reliab.course.sheplyakovia.bank.exceptions.BankTransactionException;
import tech.reliab.course.sheplyakovia.bank.exceptions.CrudOperationException;
import tech.reliab.course.sheplyakovia.bank.exceptions.NotFoundException;
import tech.reliab.course.sheplyakovia.bank.exceptions.ObjectAccessException;
import tech.reliab.course.sheplyakovia.bank.service.CreditAccountService;
import tech.reliab.course.sheplyakovia.bank.service.PaymentAccountService;
import tech.reliab.course.sheplyakovia.bank.service.UserService;
import tech.reliab.course.sheplyakovia.bank.service.impl.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab3 {

    Scanner scanner = new Scanner(System.in);
    ObjectsCreator objectsCreator;

    public Lab3() {
        Address address = new Address(
                "Russia",
                "Saint Petersburg",
                "Dumskaya",
                "2"
        );

        objectsCreator = new ObjectsCreator(
                new BankServiceImpl(),
                new AtmServiceImpl(),
                new BankOfficeServiceImpl(),
                new UserServiceImpl(),
                new EmployeeServiceImpl(),
                new CreditAccountServiceImpl(),
                new PaymentAccountServiceImpl(),
                address
        );
    }

    public void run() {
        objectsCreator.create();

        int choose = -1;
        while (choose != 0) {

            System.out.println(
                    """
                            Choose one of the actions:
                            1 - Show list of banks
                            2 - Show list of all clients
                            3 - Show information about the bank by id
                            4 - Show information about the user by id
                            5 - Request a loan
                            0 - Exit
                            """
            );

            choose = scanner.nextInt();

            switch (choose) {
                case 1 -> this.showAllBanks(objectsCreator.bankService.getBanks());
                case 2 -> this.showAllUsers(objectsCreator.userService.getUsers());
                case 3 -> this.showBank();
                case 4 -> this.showUser();
                case 5 -> this.requestLoan();
                case 0 -> {
                    return;
                }
            }
        }
    }

    private void showAllBanks(ArrayList<Bank> banks) {
        for (var bank : banks) {
            System.out.println(bank);
        }
    }

    private void showAllUsers(ArrayList<User> users) {
        for (var user : users) {
            System.out.println(user);
        }
    }

    private void showBank() {
        System.out.print("Enter the bank ID: ");
        int id = scanner.nextInt();

        if (id >= objectsCreator.bankService.getBanks().size()) {
            throw new NotFoundException(id, Bank.class.getSimpleName());
        }


        var bank = objectsCreator.bankService.getBank(id);
        System.out.println(bank);
    }

    private void showUser() {
        System.out.print("Enter the client ID: ");
        int id = scanner.nextInt();

        if (id >= objectsCreator.userService.getUsers().size()) {
            throw new NotFoundException(id, User.class.getSimpleName());
        }

        var user = objectsCreator.userService.getUser(id);
        System.out.println(user);
    }

    private void requestLoan() {
        Bank userBank = objectsCreator.bankService.getBank(0);
        if (userBank == null) {
            throw new ObjectAccessException(Bank.class.getSimpleName(), "the object does not exist");
        }

        // Выбираем наилучший банк.
        for (var bank : objectsCreator.bankService.getBanks()) {
            int bankUseFullAverage = bank.getEmployees().size() + bank.getBankATMS().size() + bank.getBankOffices().size();
            int userBankUseFullAverage = userBank.getEmployees().size() + userBank.getBankATMS().size() + userBank.getBankOffices().size();

            if ((bankUseFullAverage > userBankUseFullAverage) || (bank.getInterestRate() >= userBank.getInterestRate())) {
                userBank = bank;
            }
        }

        UserService userService = new UserServiceImpl();
        User user = userService.create(
                new FCs("Igor", "Sheplyakov", "Alexandrovich"),
                "Programmer",
                userBank
        );

        if (user == null) {
            throw new ObjectAccessException(User.class.getSimpleName(), "the object does not exist");
        }

        long userMoneyAmount = 100_000L;

        BankOffice userBankOffice = userBank.getBankOffices().get(0);

        // Выбираем наилучший банковский офис.
        for (var bankOffice : userBank.getBankOffices()) {
            if (bankOffice.getStatus() == WorkStatus.WORKING) {
                if (bankOffice.isCreditAvailable()) {
                    if (bankOffice.getMoneyAmount() > userMoneyAmount) {
                        userBankOffice = bankOffice;
                    }
                }
            }
        }

        // Выбираем подходящего сотрудника.
        Employee userEmployee = userBank.getEmployees().get(0);
        for (var employee : userBank.getEmployees()) {
            if (employee.getOffice().equals(userBankOffice)) {
                if (employee.isCreditAvailable()) {
                    userEmployee = employee;
                    break;
                }
            }
        }

        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
        PaymentAccount userPaymentAccount = paymentAccountService.create(
                user,
                userBank
        );

        if (userPaymentAccount == null) {
            throw new CrudOperationException(PaymentAccount.class.getSimpleName(), CrudOperations.Create);
        }

        // Пробуем оформить кредит.
        if ((user.getRate() < 5_000) && (user.getRate() > 50)) {
            throw new BankTransactionException("The loan is not approved", BankTransaction.Crediting);
        } else {
            System.out.println("Loan approved");

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

            System.out.println("Loan info: ");
            System.out.println(user);
            System.out.println(creditAccountService.getCreditAccount(0));
            System.out.println(userBank);
            System.out.println(userBankOffice);
            System.out.println(userEmployee);
        }
    }
}

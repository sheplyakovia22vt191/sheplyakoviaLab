package tech.reliab.course.sheplyakovia.bank.LabLogic;

import tech.reliab.course.sheplyakovia.bank.ObjectsCreator;
import tech.reliab.course.sheplyakovia.bank.entity.Bank;
import tech.reliab.course.sheplyakovia.bank.entity.PaymentAccount;
import tech.reliab.course.sheplyakovia.bank.entity.User;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.Address;
import tech.reliab.course.sheplyakovia.bank.exceptions.NotFoundException;
import tech.reliab.course.sheplyakovia.bank.exceptions.ObjectAccessException;
import tech.reliab.course.sheplyakovia.bank.service.impl.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab4 {

    ObjectsCreator objectsCreator;
    Scanner scanner = new Scanner(System.in);
    Address address = new Address(
            "Russia",
            "Saint Petersburg",
            "Dumskaya",
            "2"
    );

    public void run() {
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
                            5 - Output a payment invoice by id to a file
                            6 - Transfer all payment accounts from a file to another bank by id
                            7 - Read info from file
                            0 - Exit
                            """
            );

            choose = scanner.nextInt();

            switch (choose) {
                case 1 -> this.showAllBanks(objectsCreator.bankService.getBanks());
                case 2 -> this.showAllUsers(objectsCreator.userService.getUsers());
                case 3 -> this.showBank();
                case 4 -> this.showUser();
                case 5 -> outputPaymentInvoiceByIdToFile();
                case 6 -> transferAllPaymentAccountsFromFileToAnotherBankById();
                case 7 -> readInfoFromFile();
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

    private void outputPaymentInvoiceByIdToFile() {
        System.out.println("Enter the user ID to record his billing accounts in the file");
        var userid = scanner.nextInt();

        System.out.println("Enter the file path to write to");
        String fileName = scanner.next();

        if (objectsCreator.userService.getUser(userid) == null) {
            throw new NotFoundException(userid, User.class.getSimpleName());
        }

        try {
            var paymentAccounts = objectsCreator.userService.getUser(userid).getPaymentAccounts();
            objectsCreator.paymentAccountService.writeToFile(paymentAccounts, fileName);
        } catch (IOException e) {
            System.out.println("Error input: " + e);
        }
    }

    private void transferAllPaymentAccountsFromFileToAnotherBankById() {
        ArrayList<PaymentAccount> paymentAccounts = null;

        System.out.println("Enter the new bank ID");
        var bankId = scanner.nextInt();

        System.out.println("Enter the path of the file from which to take payment invoices");
        var fileName = scanner.next();

        System.out.println("Enter the ID of the billing account that you want to transfer from one bank to another");
        var paymentAccountId = scanner.nextInt();

        try {
            paymentAccounts = objectsCreator.paymentAccountService.readFromFile(fileName);
        } catch (IOException e) {
            System.out.println("Input error: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("The entered file has incorrect content: " + e);
        }

        var paymentAccount = objectsCreator.paymentAccountService.getPaymentAccount(paymentAccountId);
        if (paymentAccount == null) {
            throw new NotFoundException(paymentAccountId, PaymentAccount.class.getSimpleName());
        }

        if (paymentAccounts != null) {
            objectsCreator.bankService.transferAccounts(paymentAccount, bankId);
        } else {
            throw new ObjectAccessException(PaymentAccount.class.getSimpleName(), "object is null");
        }
    }

    private void readInfoFromFile() {
        System.out.println("Enter the path of the file which you want to read");
        var fileName = scanner.next();

        try {
            var paymentAccounts = objectsCreator.paymentAccountService.readFromFile(fileName);
            for (var paymentAccount : paymentAccounts) {
                System.out.println(paymentAccount);
            }
        } catch (IOException e) {
            System.out.println("Input error: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("The entered file has incorrect content: " + e);
        }
    }
}

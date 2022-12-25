package tech.reliab.course.sheplyakovia.bank.LabLogic;

import tech.reliab.course.sheplyakovia.bank.ObjectsCreator;
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
                            1 - Output a payment invoice by id to a file
                            2 - Transfer all payment accounts from a file to another bank by id
                            3 - Read info from file
                            0 - Exit
                            """
            );

            choose = scanner.nextInt();

            switch (choose) {
                case 1 -> outputPaymentInvoiceByIdToFile();
                case 2 -> transferAllPaymentAccountsFromFileToAnotherBankById();
                case 3 -> readInfoFromFile();
                case 0 -> {
                    return;
                }
            }
        }
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

//    private void outputAllClientPaymentAccountsByIdToFile() {
//    2 - Output all the client's payment accounts by id to a file
//        System.out.println("Введите id клиента");
//        var userId = scanner.nextInt();
//
//        System.out.println("Введите путь файла для записи");
//        var fileName = scanner.nextLine();
//
//        var paymentAccounts = objectsCreator.userService.getUser(userId).getPaymentAccounts();
//
//        try {
//            objectsCreator.paymentAccountService.writeToFile(paymentAccounts, fileName);
//        } catch (IOException e) {
//            System.out.println("Ошибка ввода: " + e);
//        } catch (NotFoundException e) {
//            System.out.println("There is no billing account with the ID you entered: " + e);
//        }
//    }

    private void transferAllPaymentAccountsFromFileToAnotherBankById() {
        ArrayList<PaymentAccount> paymentAccounts = null;

        System.out.println("Enter the bank ID");
        var bankId = scanner.nextInt();

        System.out.println("Enter the path of the file from which to take payment invoices");
        var fileName = scanner.next();

        System.out.println("Enter the ID of the billing account that you want to transfer from one bank to another");
        var paymentAccountId = scanner.nextInt();

        try {
            paymentAccounts = objectsCreator.paymentAccountService.readFromFile(fileName);
            for (var pa : paymentAccounts) {
                System.out.println(pa);
            }
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

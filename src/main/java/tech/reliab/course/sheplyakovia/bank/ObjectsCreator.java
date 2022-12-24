package tech.reliab.course.sheplyakovia.bank;

import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.Address;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.FCs;
import tech.reliab.course.sheplyakovia.bank.service.*;

import java.time.LocalDate;
import java.util.Random;

public class ObjectsCreator {

    public final BankService bankService;
    public final AtmService atmService;
    public final BankOfficeService bankOfficeService;
    public final UserService userService;
    public final EmployeeService employeeService;
    public final CreditAccountService creditAccountService;
    public final PaymentAccountService paymentAccountService;

    private final Address address;

    ObjectsCreator(
            BankService bankService,
            AtmService atmService,
            BankOfficeService bankOfficeService,
            UserService userService,
            EmployeeService employeeService,
            CreditAccountService creditAccountService,
            PaymentAccountService paymentAccountService,
            Address address
    ) {
        this.bankService = bankService;
        this.atmService = atmService;
        this.bankOfficeService = bankOfficeService;
        this.userService = userService;
        this.employeeService = employeeService;
        this.paymentAccountService = paymentAccountService;
        this.creditAccountService = creditAccountService;
        this.address = address;

    }

    public void create() {
        var random = new Random();

        int bankCount = random.nextInt(20, 50);

        for (int i = 0; i < bankCount; i++) {
            this.bankService.createBank("Bank " + i);

            int bankOfficeCount = random.nextInt(10, 15);

            for (int j = 0; j < bankOfficeCount; j++) {
                this.bankOfficeService.create(
                        "BankOffice" + i + j,
                        this.address,
                        this.bankService.getBank(i)
                );

                int employeesCount = random.nextInt(100, 200);

                for (int k = 0; k < employeesCount; k++) {
                    this.employeeService.create(
                            new FCs("Ivan", "Ivanov", "Ivanovich"),
                            "Manager",
                            this.bankService.getBank(i),
                            this.bankOfficeService.getBankOffice(j)
                    );
                }
            }
        }
    }
}

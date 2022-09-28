package tech.reliab.course.sheplyakovia.bank.entity;

import tech.reliab.course.sheplyakovia.bank.service.CreditAccountService;

public class CreditAccount implements CreditAccountService {
    private int id;
    private User user;
    private Bank bank;
    private String startDate;
}

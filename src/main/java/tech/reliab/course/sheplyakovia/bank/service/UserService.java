package tech.reliab.course.sheplyakovia.bank.service;

import tech.reliab.course.sheplyakovia.bank.entity.Bank;
import tech.reliab.course.sheplyakovia.bank.entity.User;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.FCs;

public interface UserService {
    User create(FCs fcs, String workPlace, Bank bank);
    User getUser();
    void update(User user);
    void delete(User user);
}

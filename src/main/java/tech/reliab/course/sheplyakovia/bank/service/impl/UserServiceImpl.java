package tech.reliab.course.sheplyakovia.bank.service.impl;

import tech.reliab.course.sheplyakovia.bank.entity.Bank;
import tech.reliab.course.sheplyakovia.bank.entity.User;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.FCs;
import tech.reliab.course.sheplyakovia.bank.service.UserService;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

public class UserServiceImpl implements UserService {

    private User user;
    private Long id = 0L;
    @Override
    public User create(FCs fcs, String workPlace, Bank bank) {
        Random random = new Random();
        var userIncome = random.nextInt(10_000);
        this.user = User
                .builder()
                .id(id++)
                .fcs(fcs)
                .birthday(Date.from(Instant.now()))
                .workPlace(workPlace)
                .income(userIncome)
                .banks(bank)
                .rate(userIncome / 10)
                .build();

        return this.user;
    }

    @Override
    public User getUser() {
        return this.user;
    }

    @Override
    public void update(User user) {
        this.user = user;
    }

    @Override
    public void delete(User user) {
        if (Objects.equals(this.user, user)) {
            this.user = null;
        }
    }
}

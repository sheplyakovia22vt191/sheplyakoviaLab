package tech.reliab.course.sheplyakovia.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.FCs;

import java.util.Date;

@Getter
@Setter
@Builder
public class Employee implements Entity {
    /**
     * Id сотрудника
     */
    private int id;

    /**
     * ФИО
     */
    private FCs fcs;

    /**
     * Дата рождения
     */
    private Date birthday;

    /**
     * Должность
     */
    private String post;

    /**
     * В каком банке работает
     */
    private Bank bank;

    /**
     * Работает ли в банковском офисе или удаленно?
     */
    private boolean isRemotely;

    /**
     * Банковский офис, в котором работает
     */
    private BankOffice office;

    /**
     * Может ли выдавать кредиты?
     */
    private boolean creditAvailable;

    /**
     * Размер зарплаты
     */
    private int salary;

    @Override
    public String toString() {
        return "Employee {" +
                "id=" + id +
                ", fcs=" + fcs +
                ", birthday=" + birthday +
                ", post='" + post + '\'' +
                ", bank=" + bank.getName() +
                ", isRemotely=" + isRemotely +
                ", office=" + office.getName() +
                ", creditAvailable=" + creditAvailable +
                ", salary=" + salary +
                '}';
    }

    @Override
    public String getSimpleName() {
        return "Employee";
    }
}

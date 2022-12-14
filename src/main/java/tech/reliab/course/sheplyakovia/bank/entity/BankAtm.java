package tech.reliab.course.sheplyakovia.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tech.reliab.course.sheplyakovia.bank.entity.auxiliary.Address;
import tech.reliab.course.sheplyakovia.bank.enums.WorkStatus;

@Getter
@Setter
@ToString
@Builder
public class BankAtm {
    /** Id банкомата */
    private long id;

    /** Имя банкомата */
    private String name;

    /** Адрес */
    private Address address;

    /** Статус */
    private WorkStatus status;
    /** Банк, которому принадлежит банкомат */
    private Bank bank;

    /** Расположение банкомата */
    private Address location;

    /** Обслуживающий сотрудник */
    private Employee servingEmployee;

    /** Работает ли на выдачу денег? */
    private boolean extradition;

    /** Можно ли внести деньги? */
    private boolean introduction;

    /** Кол-во денег в банкомате */
    private long moneyAmount;

    /** Стоимость обслуживания банкомата */
    private int maintenanceCost;
}

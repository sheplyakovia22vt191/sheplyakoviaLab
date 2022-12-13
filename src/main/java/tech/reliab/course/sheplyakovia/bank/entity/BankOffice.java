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
public class BankOffice {
    /** Id банковского офиса */
    private long id;

    /** Название офиса */
    private String name;

    /** Адрес банковского офиса */
    private Address address;

    /** Статус */
    private WorkStatus status;

    /** Можно ли разместить банкомат? */
    private boolean placeAtmAvailable;

    /** Кол-во банкоматов в данном офисе */
    private int atmCount;

    /** Можно ли оформить кредит в данном офисе? */
    private boolean creditAvailable;

    /** Работает ли на выдачу денег? */
    private boolean extradition;

    /** Можно ли внести деньги? */
    private boolean introduction;

    /** Кол-во денег в банковском офисе */
    private long moneyAmount;

    /** Стоимость аренды банковского офиса */
    private int rentCost;

    /** Банк */
    private Bank bank;
}

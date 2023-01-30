package tech.reliab.course.sheplyakovia.bank.entity.auxiliary;

import java.io.Serializable;

public class Address implements Serializable {

    private final String country;
    private final String city;
    private final String street;
    private final String house;

    public Address(String country, String city, String street, String house) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
    }


    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                '}';
    }
}

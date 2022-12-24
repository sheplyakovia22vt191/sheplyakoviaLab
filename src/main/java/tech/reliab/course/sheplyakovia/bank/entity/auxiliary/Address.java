package tech.reliab.course.sheplyakovia.bank.entity.auxiliary;

public record Address(
        String country,
        String city,
        String street,
        String house
) {

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

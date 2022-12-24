package tech.reliab.course.sheplyakovia.bank.entity.auxiliary;

public record FCs(
        String name,
        String lastName,
        String patronymic
) {

    @Override
    public String toString() {
        return "FCs{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }
}
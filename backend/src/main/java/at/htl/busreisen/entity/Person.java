package at.htl.busreisen.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.Objects;

@Entity
public class Person extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @JsonbProperty("first_name")
    public String firstName;

    @JsonbProperty("last_name")
    public String lastName;

    @JsonbProperty("tel_nr")
    public String telNr;

    @ManyToOne(cascade = CascadeType.MERGE)
    Bus bus;

    public Person() {
    }

    public Person(String firstName, String lastName, String telNr, Bus bus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telNr = telNr;
        this.bus = bus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(telNr, person.telNr) && Objects.equals(bus, person.bus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, telNr, bus);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telNr='" + telNr + '\'' +
                ", bus=" + bus +
                '}';
    }
}

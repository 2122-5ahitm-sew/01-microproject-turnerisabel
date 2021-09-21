package at.htl.busreisen.entity;

import java.util.Objects;

public class Booking {

    public Long id;

    public Person person;

    //public Trip trip;


    public Booking() {
    }

    public Booking(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id) && Objects.equals(person, booking.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, person);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", person=" + person +
                '}';
    }
}



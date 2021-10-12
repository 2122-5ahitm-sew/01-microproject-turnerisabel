package at.htl.busreisen.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Destination extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String street;

    public int streetNo;

    public String place;

    public int zip;

    public Destination() {
    }

    public Destination(String street, int streetNo, String place, int zip) {
        this.street = street;
        this.streetNo = streetNo;
        this.place = place;
        this.zip = zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return zip == that.zip && Objects.equals(id, that.id) && Objects.equals(street, that.street) && Objects.equals(streetNo, that.streetNo) && Objects.equals(place, that.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, streetNo, place, zip);
    }

    @Override
    public String toString() {
        return "Destination{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", streetNo='" + streetNo + '\'' +
                ", place='" + place + '\'' +
                ", zip=" + zip +
                '}';
    }
}

package at.htl.busreisen.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Trip extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    public Destination destination;

    @ManyToOne
    public Bus bus;

    public Trip() {
    }

    public Trip(Destination destination, Bus bus) {
        this.destination = destination;
        this.bus = bus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return Objects.equals(id, trip.id) && Objects.equals(destination, trip.destination) && Objects.equals(bus, trip.bus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, destination, bus);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", destination=" + destination +
                ", bus=" + bus +
                '}';
    }
}

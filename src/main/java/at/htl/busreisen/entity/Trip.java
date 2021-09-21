package at.htl.busreisen.entity;

import java.util.Objects;

public class Trip {

    public Long id;
    public Destination destination;
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

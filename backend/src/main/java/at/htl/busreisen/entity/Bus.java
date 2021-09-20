package at.htl.busreisen.entity;

import java.util.Objects;

public class Bus {

    public Long id;
    public int seats;

    public Bus() {
    }

    public Bus(int seats) {
        this.seats = seats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return seats == bus.seats && Objects.equals(id, bus.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, seats);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", seats=" + seats +
                '}';
    }
}

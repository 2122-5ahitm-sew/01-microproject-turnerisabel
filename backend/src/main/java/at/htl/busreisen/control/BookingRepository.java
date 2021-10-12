package at.htl.busreisen.control;

import at.htl.busreisen.entity.Booking;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;

@ApplicationScoped
public class BookingRepository implements PanacheRepository<Booking> {
}

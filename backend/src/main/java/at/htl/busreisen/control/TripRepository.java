package at.htl.busreisen.control;

import at.htl.busreisen.entity.Trip;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TripRepository implements PanacheRepository<Trip> {
}

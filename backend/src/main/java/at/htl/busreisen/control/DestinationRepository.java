package at.htl.busreisen.control;

import at.htl.busreisen.entity.Destination;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DestinationRepository implements PanacheRepository<Destination> {
}

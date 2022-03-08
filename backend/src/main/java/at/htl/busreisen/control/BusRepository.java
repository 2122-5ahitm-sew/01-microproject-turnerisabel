package at.htl.busreisen.control;

import at.htl.busreisen.entity.Bus;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
//@GrpcService
public class BusRepository implements PanacheRepository<Bus> {
}



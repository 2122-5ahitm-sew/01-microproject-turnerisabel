package at.htl.busreisen.boundary;

import at.htl.busreisen.control.BusRepository;
import at.htl.busreisen.entity.Bus;
import io.quarkus.grpc.GrpcService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@GrpcService
public class BusService {

    @Inject
    BusRepository repository;

    @GET
    public List<Bus> getAllBusses() {
        return repository.listAll();
    }

    @GET
    @Path("getById/{id}")
    public Response getBusById(@PathParam("id") Long id){
        Bus bus = repository.findById(id);
        if (bus != null){
            return Response
                    .ok()
                    .entity(bus)
                    .build();
        }else {
            return Response.noContent().build();
        }
    }

    @POST
    @Transactional
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Bus createBus(Bus bus) {

        repository.persist(bus);
        return bus;
    }

    @PUT
    @Transactional
    @Path("updateById")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBus(Bus bus) {
        if (bus.id != null && repository.findById(bus.id) != null) {
            return Response
                    .ok()
                    .entity(repository.getEntityManager().merge(bus))
                    .build();
        } else {
            return Response
                    .noContent()
                    .build();
        }
    }

    @DELETE
    @Transactional
    @Path("deleteById")
    @Consumes(MediaType.APPLICATION_JSON)
    public Bus deleteBus(Bus bus) {
        Bus bus1 = repository.findById(bus.id);
        repository.delete("id = " + bus.id);
        return bus1;
    }
}

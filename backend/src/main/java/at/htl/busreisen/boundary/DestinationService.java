package at.htl.busreisen.boundary;

import at.htl.busreisen.control.DestinationRepository;
import at.htl.busreisen.entity.Bus;
import at.htl.busreisen.entity.Destination;
import org.apache.maven.lifecycle.internal.LifecycleStarter;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("destination")
@Produces(MediaType.APPLICATION_JSON)
public class DestinationService {

    @Inject
    DestinationRepository repository;

    @GET
    public List<Destination> getAllDestinations(){
        return repository.listAll();
    }

    @GET
    @Path("getById/{id}")
    public Response getDestinationById(@PathParam("id") Long id){
        Destination destination = repository.findById(id);
        if (destination != null){
            return Response
                    .ok()
                    .entity(destination)
                    .build();
        }else {
            return Response.noContent().build();
        }
    }

    @POST
    @Transactional
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Destination createDestination(Destination destination) {
        repository.persist(destination);
        return destination;
    }

    @PUT
    @Transactional
    @Path("updateById")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDestination(Destination destination) {
        System.out.println(destination.id);
        if (destination.id != null && repository.findById(destination.id) != null) {
            return Response
                    .ok()
                    .entity(repository.getEntityManager().merge(destination))
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
    public Destination deleteDestination(Destination destination) {
        Destination destination1 = repository.findById(destination.id);
        repository.delete("id = " + destination1.id);
        return destination1;
    }
}

package at.htl.busreisen.boundary;

import at.htl.busreisen.control.TripRepository;
import at.htl.busreisen.entity.Trip;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("trip")
@Produces(MediaType.APPLICATION_JSON)
public class TripService {

    @Inject
    TripRepository repository;

    @GET
    public List<Trip> getAllTrips() {
        return repository.listAll();
    }

    @GET
    @Path("getById/{id}")
    public Response getTripById(@PathParam("id") Long id) {
        Trip trip = repository.findById(id);
        if (trip != null) {
            return Response
                    .ok()
                    .entity(trip)
                    .build();
        } else {
            return Response.noContent().build();
        }
    }

    @POST
    @Transactional
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Trip createTrip(Trip trip) {
        repository.persist(trip);
        return trip;
    }

    @PUT
    @Transactional
    @Path("updateById")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTrip(Trip trip) {
        if (trip.id != null && repository.findById(trip.id) != null) {
            return Response
                    .ok()
                    .entity(repository.getEntityManager().merge(trip))
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
    public Trip deleteTrip(Trip trip){
        Trip trip1 = repository.findById(trip.id);
        repository.delete("id = " + trip.id);
        return trip1;
    }
}

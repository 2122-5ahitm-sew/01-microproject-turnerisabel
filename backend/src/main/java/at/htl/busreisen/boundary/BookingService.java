package at.htl.busreisen.boundary;

import at.htl.busreisen.control.BookingRepository;
import at.htl.busreisen.control.PersonRepository;
import at.htl.busreisen.control.TripRepository;
import at.htl.busreisen.entity.Booking;
import at.htl.busreisen.entity.Person;
import at.htl.busreisen.entity.Trip;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("booking")
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class BookingService {

    @Inject
    BookingRepository repository;

    @Inject
    TripRepository tripRepository;

    @Inject
    PersonRepository personRepository;

    @GET
    public List<Booking> getAllBookings() {
        return repository.listAll();
    }

    @GET
    @Path("getById/{id}")
    public Response getBookingById(@PathParam("id") Long id) {
        Booking booking = repository.findById(id);
        if (booking != null) {
            return Response
                    .ok()
                    .entity(booking)
                    .build();
        } else {
            return Response.noContent().build();
        }
    }

    @POST
    @Transactional
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Booking createBooking(Booking booking) {
        Trip trip = tripRepository.findById(booking.trip.id);
        if (trip != null) {
            booking.trip = trip;
        }

        Person person = personRepository.findById(booking.person.id);
        if (person != null) {
            booking.person = person;
        }

        repository.persist(booking);
        return booking;
    }

    @PUT
    @Transactional
    @Path("updateById")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBooking(Booking booking) {
        if (booking.id != null && repository.findById(booking.id) != null) {
            return Response
                    .ok()
                    .entity(repository.getEntityManager().merge(booking))
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
    public Booking deleteBooking(Booking booking){
        Booking booking1 = repository.findById(booking.id);
        repository.delete("id = " +booking.id);
        return booking1;
    }
}

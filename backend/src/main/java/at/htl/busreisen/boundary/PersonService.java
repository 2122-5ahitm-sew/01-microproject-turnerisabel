package at.htl.busreisen.boundary;

import at.htl.busreisen.control.PersonRepository;
import at.htl.busreisen.entity.Person;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("passenger")
@Produces(MediaType.APPLICATION_JSON)
public class PersonService {

    @Inject
    PersonRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPassengers() {
        return repository.listAll();
    }

    @POST
    @Transactional
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Person createPassenger(Person person) {
        repository.persist(person);
        return person;
    }

    @PUT
    @Transactional
    @Path("updateById")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePassenger(Person person) {
        if (person.id != null && repository.findById(person.id) != null) {
            return Response
                    .ok()
                    .entity(repository.getEntityManager().merge(person))
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
    public Person deletePassenger(Person person) {
        Person person1 = repository.findById(person.id);
        repository.delete("id = " + person.id);
        return person1;
    }
}


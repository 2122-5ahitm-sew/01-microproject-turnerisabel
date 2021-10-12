package at.htl.busreisen.control;

import at.htl.busreisen.entity.Bus;
import at.htl.busreisen.entity.Destination;
import at.htl.busreisen.entity.Person;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

public class InitBean {

    @Inject
    EntityManager entityManager;

    @Transactional
    public void init(@Observes StartupEvent ev){
        // String street, int streetNo, String place, int zip
        Destination destination = new Destination("ExampleStreet", 10, "ExamplePlace", 1234);

        entityManager.merge(destination);

        Bus bus1 = new Bus(50);
        // Person
        Person person = new Person("Susi", "Muster", "0667/12345678", bus1);

        entityManager.merge(person);
    }
}

package de.netempire.movie_library.jpa;

import de.netempire.movie_library.actor.Actor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ActorRepositoryTest {

    @Autowired
    private ActorRepository actorRepository;

    private Actor actor;

    @BeforeEach
    public void setUp() {
        actorRepository.deleteAll();
        actor = new Actor();
        actor.setFirstname("Hans");
        actor.setLastname("Imglück");
        actor.setDateOfBirth("01.01.1970");
        actorRepository.save(actor);
    }

    @AfterEach
    public void tearDown() {
        actorRepository.deleteAll();
    }

    @Test
    void findByFirstname() {

        Actor myActor = actorRepository.findByFirstname("Hans");

        assertNotNull(myActor);
        assertEquals(actor.getLastname(), myActor.getLastname());

    }

    @Test
    void findAll() {

        List<Actor> actorList = actorRepository.findAll();

        assertNotNull(actorList);
        assertEquals(1, actorList.size());

    }
}
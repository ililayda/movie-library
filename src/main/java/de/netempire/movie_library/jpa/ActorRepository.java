package de.netempire.movie_library.jpa;

import de.netempire.movie_library.actor.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {

    Actor findByFirstname(String firstname);

}
package de.netempire.movie_library.jpa;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import de.netempire.movie_library.actor.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ActorRepository extends JpaRepository<Actor, Long> {

    //@Query("select a from actor a where a.id = ?1");
    //Actor findActorWithId(Long id);

    //Actor findById(Long id);

    Actor findByFirstname(String firstname);

}
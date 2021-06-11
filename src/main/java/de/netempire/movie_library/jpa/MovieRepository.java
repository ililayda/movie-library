package de.netempire.movie_library.jpa;

import de.netempire.movie_library.actor.Actor;
import de.netempire.movie_library.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findByTitle(String title);
}

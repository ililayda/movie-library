package de.netempire.movie_library.jpa;

import de.netempire.movie_library.actor.Actor;
import de.netempire.movie_library.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findByTitle(String title);
}

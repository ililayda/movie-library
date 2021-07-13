package de.netempire.movie_library.jpa;

import de.netempire.movie_library.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("Select movie from Movie movie where movie.title LIKE  %?1%")
    Movie findByTitle(String title);

    Movie findAllById(long i);

    Movie findByTitleLike(String title);

    Movie findByTitleContaining(String title);

}

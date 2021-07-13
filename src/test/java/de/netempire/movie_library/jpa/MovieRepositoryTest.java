package de.netempire.movie_library.jpa;

import de.netempire.movie_library.movie.Movie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    private Movie movie;

    @BeforeEach
    public void setUp() {

        movieRepository.deleteAll();
        movie = new Movie();
        movie.setRating("10/10");
        movie.setPlot("Hans im Glück remastered");
        movie.setCategory("2");
        movie.setTitle("Hans Im_Glück");
        movie.setReleaseDate("Glücksdatum");
        movieRepository.save(movie);
    }

    @AfterEach
    public void tearDown() {
        movieRepository.deleteAll();

    }

    @Test
    void findByTitle() {

        Movie myMovie = movieRepository.findByTitle("Hans Im_Gl");

        assertNotNull(myMovie);
        assertEquals(movie.getId(), myMovie.getId());

    }

    @Test
    void findByTitleLike() {

        Movie myMovie = movieRepository.findByTitleLike("Hans Im_Gl%");

        assertNotNull(myMovie);
        assertEquals(movie.getId(), myMovie.getId());

    }

    @Test
    void findByTitleContaining() {

        Movie myMovie = movieRepository.findByTitleContaining("Hans Im_gl");

        assertNotNull(myMovie);
        assertEquals(movie.getId(), myMovie.getId());

    }

}
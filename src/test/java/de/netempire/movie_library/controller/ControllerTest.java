package de.netempire.movie_library.controller;

import de.netempire.movie_library.movie.Movie;
import de.netempire.movie_library.movie.MovieEntity;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void getUser() {
    }


    @Test
    @GetMapping(value = "/movie", produces = {"application/json"})
    public @ResponseBody
    Movie getAllMovies() {

        MovieEntity entity = new MovieEntity();
        Movie movie = new Movie();
        movie.setId(entity.getId());
        movie.setTitle(entity.getTitle());
        movie.setCategory(entity.getCategory());
        movie.setPlot(entity.getPlot());
        movie.setRating(entity.getRating());
        movie.setHasIn(entity.getHasIn());

        return movie;
    }

}

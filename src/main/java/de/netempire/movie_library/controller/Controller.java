package de.netempire.movie_library.controller;

import de.netempire.movie_library.actor.Actor;
import de.netempire.movie_library.jpa.CategoryRepository;
import de.netempire.movie_library.movie.Movie;
import de.netempire.movie_library.jpa.ActorRepository;
import de.netempire.movie_library.jpa.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    CategoryRepository categoryRepository;


    @GetMapping(value = "/movie", produces = {"application/json"})
    public @ResponseBody Movie getAllMovies() {

        Movie movie = new Movie();

        List<Movie> movieList = movieRepository.findAll();

        for (Movie value : movieList) {

            movie.setId(value.getId());
            movie.setTitle(value.getTitle());
            movie.setCategory(value.getCategory());
            movie.setPlot(value.getPlot());
            movie.setRating(value.getRating());

            System.out.println("Movie: " + movie + ", " + System.lineSeparator());

            return movie;
        }

        return movie;
    }

    @GetMapping(value = "/actor", produces = {"application/json"})
    public @ResponseBody Iterable<Actor> getAllActor() {

        return actorRepository.findAll();
    }

    /*@GetMapping(value = "/actor_in_movie", produces = {"application/json"})
    public @ResponseBody Movie getAllActorsInMovie(@RequestParam String title) throws SQLException {

        if (title.contains("_")) {
            title = title.replaceAll("_", " ");
        }

        // title -> id -> actor_in_movie.actor_id -> actor.id -> Ausgabe Actor/s

        Movie movie = movieRepository.findByTitle(title);
        long movieID = movie.getId();


        long actorID = 1;

        Actor actor = actorRepository.findByID(actorID);


        return movie;
    } */

    @PutMapping(value = "/insertMovie/{rating}/{plot}/{category}/{title}/{releaseDate}", produces = {"application/json"})
    public @ResponseBody Movie insertMovie(@PathVariable String rating, @PathVariable String plot, @PathVariable String category,
                                           @PathVariable String title, @PathVariable String releaseDate) {

        Movie movie = new Movie();
        movie.setRating(rating);
        movie.setPlot(plot);
        movie.setCategory(category);
        movie.setTitle(title);
        movie.setReleaseDate(releaseDate);
        movieRepository.save(movie);

        return movie;
    }

    @PostMapping(value = "/insertActor", produces = {"application/json"})
    public @ResponseBody Actor insertActor(@PathVariable String firstname, @PathVariable String lastname, @PathVariable String dateOfBirth) {

        Actor actor = new Actor();
        actor.setFirstname(firstname);
        actor.setLastname(lastname);
        actor.setDateOfBirth(dateOfBirth);
        actorRepository.save(actor);

        return actor;
    }

}
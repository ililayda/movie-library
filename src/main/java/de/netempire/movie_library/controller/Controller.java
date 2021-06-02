package de.netempire.movie_library.controller;

import de.netempire.movie_library.actor.Actor;
import de.netempire.movie_library.category.Category;
import de.netempire.movie_library.jpa.CategoryRepository;
import de.netempire.movie_library.movie.Movie;
import de.netempire.movie_library.jpa.ActorRepository;
import de.netempire.movie_library.jpa.MovieRepository;
import de.netempire.movie_library.movie.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/actor", produces = {"application/json"})
    public @ResponseBody Iterable<Actor> getAllActor() {

        return actorRepository.findAll();
    }

    @GetMapping(value = "/category", produces = {"application/json"})
    public @ResponseBody Iterable<Category> getAllCategory() {

        return categoryRepository.findAll();
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


    public String getUser() {
        return "root";
    }

    public String getPassword() {
        return "";
    }

    public String getDb() {
        return "film_library";
    }

    public String getUrl() {
        return "jdbc:mysql://localhost:3306/";
    }

}
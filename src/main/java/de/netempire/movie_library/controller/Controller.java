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

    @GetMapping(value = "/insertMovie", produces = {"application/json"})
    public @ResponseBody Movie insertMovie() {

        Movie movie = new Movie();
        movie.setRating("10/10");
        movie.setPlot("Hans im Glück remastered");
        movie.setCategory("2");
        movie.setTitle("Hans Im_Glück");
        movie.setReleaseDate("Glücksdatum");
        movieRepository.save(movie);

        return movie;
    }

    @GetMapping(value = "/insertActor", produces = {"application/json"})
    public @ResponseBody Actor insertActor() {

        Actor actor = new Actor();
        actor.setFirstname("Hans");
        actor.setLastname("Imglück");
        actor.setDateOfBirth("01.01.1970");
        actorRepository.save(actor);

        return actor;
    }


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
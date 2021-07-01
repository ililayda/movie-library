package de.netempire.movie_library.controller;

import de.netempire.movie_library.actor.Actor;
import de.netempire.movie_library.movie.Movie;
import de.netempire.movie_library.jpa.ActorRepository;
import de.netempire.movie_library.jpa.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class Controller {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ActorRepository actorRepository;


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


    @GetMapping(value = "/findMovieByTitle/{title}")
    public @ResponseBody List<Movie> findMovieByTitle(@PathVariable String title) {

        List<Movie> movieListOut = new ArrayList<>();
        List<Movie> movieList = movieRepository.findAll();
        int l = (int) movieRepository.count();

        for (int i = 0; i < l; i++) {

                if (movieList.get(i).getTitle().contains(title)) {

                    assert false;
                    movieListOut.add(movieList.get(i));
                }
        }
        return movieListOut;
    }


    @GetMapping(value = "/actor", produces = {"application/json"})
    public @ResponseBody Iterable<Actor> getAllActor() {

        return actorRepository.findAll();
    }


    // title -> id -> actor_in_movie.actor_id -> actor.id -> Ausgabe Actor/s
    @GetMapping(value = "/actor_in_movie", produces = {"application/json"})
    public @ResponseBody List<Actor> getAllActorsInMovie(@RequestParam String title) {

        List<Actor> actorList = null;

        if (title.contains("_")) {
            title = title.replaceAll("_", " ");
        }

        Movie movie = movieRepository.findByTitle(title);
        long movieID = movie.getId();

        long i = 1;
        Actor actor = new Actor();
        try {
            assert false;
            actorList.add(actor);

        } catch (NullPointerException e) {
            System.out.println("Error" + e);
        }

        return actorList;
    }


    @PutMapping(value = "/insertMovie/{rating}/{plot}/{category}/{title}/{releaseDate}", produces = {"application/json"})
    public @ResponseBody Movie insertMovie(@PathVariable String rating, @PathVariable String plot,
                                           @PathVariable String category, @PathVariable String title,
                                           @PathVariable String releaseDate) {

        Movie movie = new Movie();
        movie.setRating(rating);
        movie.setPlot(plot);
        movie.setCategory(category);
        movie.setTitle(title);
        movie.setReleaseDate(releaseDate);
        movieRepository.save(movie);

        return movie;
    }


    @PutMapping(value = "/insertMovie", produces = {"application/json"})
    public ResponseEntity<Movie> insertMovieObject(@PathVariable Movie movie) {

        movieRepository.save(movie);

        return null;

        //{
        //"rating": "5/10",
        //"plot": "cool",
        //"releaseDate": "16.10.1997",
        //"title": "Cööl",
        //"category": "2"
        //}
    }


    @PostMapping(value = "/insertActor", produces = {"application/json"})
    public @ResponseBody Actor insertActor(@PathVariable String firstname, @PathVariable String lastname,
                                           @PathVariable String dateOfBirth) {

        Actor actor = new Actor();
        actor.setFirstname(firstname);
        actor.setLastname(lastname);
        actor.setDateOfBirth(dateOfBirth);
        actorRepository.save(actor);

        return actor;

        //{
        //"firstname": "Gareth",
        //"lastname": "Wylie",
        //"dateOfBirth": "2000"
        //}
    }

}
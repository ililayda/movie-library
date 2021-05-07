package de.netempire.movie_library.actor;

import com.sun.istack.NotNull;
import de.netempire.movie_library.movie.Movie;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Actor {

    public Actor() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany
    @JoinTable(
            name = "actor_in_movie",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    Set<Movie> playsIn;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    private String dateOfBirth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Movie> getPlaysIn() {
        return playsIn;
    }

    public void setPlaysIn(Set<Movie> playsIn) {
        this.playsIn = playsIn;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}

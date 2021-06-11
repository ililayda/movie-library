package de.netempire.movie_library.actor;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;
import de.netempire.movie_library.movie.Movie;
import javax.persistence.*;
import java.util.Set;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
public class Actor {

    public Actor() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    // @JoinTable(
    //         name = "actor_in_movie",
    //         joinColumns = @JoinColumn(name = "actor_id"),
    //         inverseJoinColumns = @JoinColumn(name = "movie_id"))
    // Set<Movie> playsIn;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    private String dateOfBirth;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Actor actor = (Actor) o;

        if (id != null ? !id.equals(actor.id) : actor.id != null) return false;
        // if (playsIn != null ? !playsIn.equals(actor.playsIn) : actor.playsIn != null) return false;
        if (firstname != null ? !firstname.equals(actor.firstname) : actor.firstname != null) return false;
        if (lastname != null ? !lastname.equals(actor.lastname) : actor.lastname != null) return false;
        return dateOfBirth != null ? dateOfBirth.equals(actor.dateOfBirth) : actor.dateOfBirth == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        // result = 31 * result + (playsIn != null ? playsIn.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

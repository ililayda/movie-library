package de.netempire.movie_library.movie;

import com.sun.istack.NotNull;
import de.netempire.movie_library.actor.Actor;

import javax.persistence.*;
import java.util.Set;

@Entity
public class MovieEntity {

    public MovieEntity() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotNull
    private String title;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "actor_in_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    Set<Actor> hasIn;
    @NotNull
    private String category;
    @NotNull
    private String plot;
    @NotNull
    private String releaseDate;
    @NotNull
    private String rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Actor> getHasIn() {
        return hasIn;
    }

    public void setHasIn(Set<Actor> hasIn) {
        this.hasIn = hasIn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
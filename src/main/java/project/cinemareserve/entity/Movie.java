package project.cinemareserve.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Entity
@Getter
@Service
@Builder
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Column(name = "durationminutes")
    private int durationMinutes;

    public Movie(String title, String description, int durationMinutes) {
        this.title = title;
        this.description = description;
        this.durationMinutes = durationMinutes;
    }

    protected Movie() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

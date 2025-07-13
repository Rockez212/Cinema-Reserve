package project.cinemareserve.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movies_seq")
    @SequenceGenerator(name = "movies_seq", sequenceName = "movies_id_seq", allocationSize = 1)
    private Long id;
    @Column(name = "admin_id")
    private Long adminId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "duration_minutes")
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
        if(o == this) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

package project.cinemareserve.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "screening")
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie")
    private Movie movie;
    @Column(name = "startTime")
    private LocalDateTime startTime;
    @Column(name = "hallName")
    private String hallName;

    public Screening(Movie movie, LocalDateTime startTime, String hallName) {
        this.movie = movie;
        this.startTime = startTime;
        this.hallName = hallName;
    }

    protected Screening() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Screening screening = (Screening) o;
        return Objects.equals(id, screening.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

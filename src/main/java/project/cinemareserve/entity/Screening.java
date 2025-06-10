package project.cinemareserve.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Service
@Builder
@Table(name = "screening")
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;
    @Column(name = "starttime")
    private LocalDateTime startTime;
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

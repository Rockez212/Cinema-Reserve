package project.cinemareserve.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import project.cinemareserve.enums.HallPlace;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "screenings")
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "screenings_seq")
    @SequenceGenerator(name = "screenings_seq", sequenceName = "screenings_id_seq", allocationSize = 1)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie")
    private Movie movie;
    @Column(name = "start_time")
    private LocalDateTime startTime;
    @Column(name = "end_time")
    private LocalDateTime endTime;
    @JoinColumn(name = "hall_name")
    @Enumerated(EnumType.STRING)
    private HallPlace hallName;

    public Screening(Movie movie, LocalDateTime startTime, HallPlace hallName) {
        this.movie = movie;
        this.startTime = startTime;
        this.hallName = hallName;
    }

    protected Screening() {
    }


    public void updateEndTime(int durationMinutes) {
        Duration duration = Duration.ofMinutes(durationMinutes);
        this.endTime = this.startTime.plus(duration);
    }


    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Screening screening = (Screening) o;
        return Objects.equals(id, screening.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

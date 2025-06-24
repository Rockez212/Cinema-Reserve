package project.cinemareserve.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import project.cinemareserve.entity.Movie;
import project.cinemareserve.entity.Screening;
import project.cinemareserve.enums.HallPlace;

import java.time.LocalDateTime;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    Screening findByMovieId(Long movieId);

    boolean existsByMovieId(Long movieId);

    boolean existsByMovieAndStartTimeAndHallName(Movie movie, LocalDateTime startTime, HallPlace hallName);



}

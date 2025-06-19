package project.cinemareserve.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import project.cinemareserve.entity.Movie;
import project.cinemareserve.entity.Screening;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    Screening findByMovieId(Long movieId);

    boolean existsByMovieId(Long movieId);
}

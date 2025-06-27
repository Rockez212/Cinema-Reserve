package project.cinemareserve.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.cinemareserve.entity.Movie;
import project.cinemareserve.entity.Screening;
import project.cinemareserve.enums.HallPlace;

import java.time.LocalDateTime;
import java.util.List;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    Screening findFirstByMovieId(Long movieId);


    boolean existsByMovieId(Long movieId);

    @Query("""
            SELECT COUNT(s) > 0 FROM Screening s
            WHERE  s.hallName = :hallName
            AND (:newStartTime < s.endTime AND :newEndTime > s.startTime)
            """)
    boolean hallIsBusy(@Param("hallName") HallPlace hallName,
                       @Param("newStartTime") LocalDateTime newStartTime,
                       @Param("newEndTime") LocalDateTime newEndTime);



}

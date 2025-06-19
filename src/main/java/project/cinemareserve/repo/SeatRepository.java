package project.cinemareserve.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import project.cinemareserve.entity.Screening;
import project.cinemareserve.entity.Seat;

import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    Optional<Seat> findByScreeningAndRowAndNumber(Screening screening, int row, int number);
}

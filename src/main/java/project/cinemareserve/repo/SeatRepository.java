package project.cinemareserve.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import project.cinemareserve.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
}

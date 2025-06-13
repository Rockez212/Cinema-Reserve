package project.cinemareserve.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import project.cinemareserve.entity.Booking;
import project.cinemareserve.entity.User;

import java.util.Collection;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findAllByUser(User user);
}

package project.cinemareserve.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import project.cinemareserve.entity.Screening;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {
}

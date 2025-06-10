package project.cinemareserve.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import project.cinemareserve.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}

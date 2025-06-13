package project.cinemareserve.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import project.cinemareserve.entity.Movie;
import project.cinemareserve.entity.User;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAllByUser(User currentUser);

}

package project.cinemareserve.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.cinemareserve.command.MovieRegisterCommand;
import project.cinemareserve.dtos.MovieDto;
import project.cinemareserve.entity.Movie;
import project.cinemareserve.entity.User;
import project.cinemareserve.exception.MovieNotFoundException;
import project.cinemareserve.mapper.MovieMapper;
import project.cinemareserve.repo.MovieRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final AuthService authService;


    @Transactional
    public void createMovie(MovieRegisterCommand command) {
        String title = command.getTitle();
        String description = command.getDescription();
        int durationMinutes = command.getDurationMinutes();
        Movie newMovie = new Movie(title, description, durationMinutes);
        movieRepository.save(newMovie);
    }

    @Transactional
    public void deleteMovie(Long id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
        } else {
            throw new MovieNotFoundException("Movie not exists");
        }
    }


    @Transactional(readOnly = true)
    public List<MovieDto> getAllMovies() {
        User currentUser = authService.getCurrentUser();
        return movieRepository.findAllByUser(currentUser).stream()
                .map(MovieMapper::toMovieDto)
                .collect(Collectors.toList());
    }
}

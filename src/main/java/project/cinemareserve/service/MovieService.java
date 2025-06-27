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
    private final MovieMapper movieMapper;


    @Transactional
    public void create(MovieRegisterCommand command) {
        Movie newMovie = new Movie(command.getTitle(), command.getDescription(), command.getDurationMinutes());
        newMovie.setAdminId(authService.getCurrentUser().getId());
        movieRepository.save(newMovie);
    }

    @Transactional
    public void delete(Long id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
        } else {
            throw new MovieNotFoundException("Movie not exists");
        }
    }


    @Transactional(readOnly = true)
    public List<MovieDto> getAll() {
        User currentUser = authService.getCurrentUser();
        return movieRepository.findAllByUser(currentUser).stream()
                .map(movieMapper::toMovieDto)
                .collect(Collectors.toList());
    }
}

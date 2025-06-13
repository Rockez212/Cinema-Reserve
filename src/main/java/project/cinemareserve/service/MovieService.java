package project.cinemareserve.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.cinemareserve.dtos.MovieDto;
import project.cinemareserve.entity.User;
import project.cinemareserve.mapper.MovieMapper;
import project.cinemareserve.repo.MovieRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final AuthService authService;

    @Transactional(readOnly = true)
    public List<MovieDto> getAllMovies() {
        User currentUser = authService.getCurrentUser();
        return movieRepository.findAllByUser(currentUser).stream()
                .map(MovieMapper::toMovieDto)
                .collect(Collectors.toList());
    }
}

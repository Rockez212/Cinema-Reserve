package project.cinemareserve.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.cinemareserve.dtos.MovieDto;
import project.cinemareserve.service.MovieService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/movie")
public class MovieController {
    private MovieService movieService;

    @GetMapping("/getMovies")
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        List<MovieDto> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }
}

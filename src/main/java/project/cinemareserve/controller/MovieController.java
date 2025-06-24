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
@RequestMapping("/movies")
public class MovieController {
    private MovieService movieService;

    @GetMapping()
    public ResponseEntity<List<MovieDto>> getAll() {
        List<MovieDto> movies = movieService.getAll();
        return ResponseEntity.ok(movies);
    }
}

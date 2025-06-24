package project.cinemareserve.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.cinemareserve.command.MovieRegisterCommand;
import project.cinemareserve.service.MovieService;

@RestController
@AllArgsConstructor
@RequestMapping("/admin/movies")
public class AdminMovieController {

    private final MovieService movieService;

    @PostMapping()
    public ResponseEntity<String> register(@RequestBody @Valid MovieRegisterCommand command) {
        movieService.create(command);
        return ResponseEntity.ok("Successfully added movie");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        movieService.delete(id);
        return ResponseEntity.ok("Successfully deleted movie with id: " + id);
    }

}

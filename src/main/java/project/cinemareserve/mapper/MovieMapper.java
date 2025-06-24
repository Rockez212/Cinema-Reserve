package project.cinemareserve.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import project.cinemareserve.dtos.MovieDto;
import project.cinemareserve.entity.Movie;


@Component
public class MovieMapper {


    public MovieDto toMovieDto(Movie movie) {
        if (movie == null) {
            return null;
        }
        return new MovieDto(
                movie.getTitle(),
                movie.getDescription(),
                movie.getDurationMinutes()
        );
    }

}


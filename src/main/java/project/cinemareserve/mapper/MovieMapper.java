package project.cinemareserve.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import project.cinemareserve.dtos.MovieDto;
import project.cinemareserve.entity.Movie;


@Data
@AllArgsConstructor
public class MovieMapper {


    public static MovieDto toMovieDto(Movie movie) {
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


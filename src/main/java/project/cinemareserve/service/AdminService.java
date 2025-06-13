package project.cinemareserve.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.cinemareserve.command.MovieRegisterCommand;
import project.cinemareserve.command.ScreeningRegisterCommand;
import project.cinemareserve.command.SeatRegisterCommand;
import project.cinemareserve.entity.Movie;
import project.cinemareserve.entity.Screening;
import project.cinemareserve.entity.Seat;
import project.cinemareserve.exception.MovieNotFoundException;
import project.cinemareserve.exception.ScreeningNotFoundException;
import project.cinemareserve.repo.MovieRepository;
import project.cinemareserve.repo.ScreeningRepository;
import project.cinemareserve.repo.SeatRepository;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AdminService {

    private final MovieRepository movieRepository;
    private final ScreeningRepository screeningRepository;
    private final SeatRepository seatRepository;

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
        movieRepository.deleteById(id);
    }

    @Transactional
    public void createScreening(ScreeningRegisterCommand command) {
        Movie movie = movieRepository.findById(command.getMovieId())
                .orElseThrow(() -> new MovieNotFoundException("Movie not found"));
        LocalDateTime startTime = command.getStartTime();
        String hallName = command.getHallName();

        Screening newScreening = new Screening(movie, startTime, hallName);

        screeningRepository.save(newScreening);
    }

    @Transactional
    public void createSeat(SeatRegisterCommand command) {
        Screening screening = screeningRepository.findById(command.getScreeningId()).orElseThrow(()
                -> new ScreeningNotFoundException("Screening not found"));

        int row = command.getRow();
        int number = command.getNumber();
        boolean isReserved = command.isReserved();
        Seat newSeat = new Seat(screening, row, number, isReserved);

        seatRepository.save(newSeat);

    }


}

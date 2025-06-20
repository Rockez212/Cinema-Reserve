package project.cinemareserve.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.cinemareserve.command.ScreeningRegisterCommand;
import project.cinemareserve.entity.Movie;
import project.cinemareserve.entity.Screening;
import project.cinemareserve.entity.Seat;
import project.cinemareserve.enums.HallPlace;
import project.cinemareserve.exception.MovieNotFoundException;
import project.cinemareserve.exception.ScreeningNotFoundException;
import project.cinemareserve.repo.MovieRepository;
import project.cinemareserve.repo.ScreeningRepository;
import project.cinemareserve.repo.SeatRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ScreeningService {

    private final ScreeningRepository screeningRepository;
    private final MovieRepository movieRepository;
    private final SeatRepository seatRepository;

    @Transactional
    public void createScreening(ScreeningRegisterCommand command) {
        Movie movie = movieRepository.findById(command.getMovieId())
                .orElseThrow(() -> new MovieNotFoundException("Movie not found"));
        LocalDateTime startTime = command.getStartTime();
        int hallId = command.getHallId();

        HallPlace hallPlace = HallPlace.getHallPlace(hallId);
        Screening newScreening = new Screening(movie, startTime, hallPlace);

        screeningRepository.save(newScreening);

        generateSeatsForScreening(newScreening);
    }

    @Transactional
    protected void generateSeatsForScreening(Screening screening) {
        final int TOTAL_SEATS = 100;
        final int TOTAL_ROWS = 4;

        int seatsPerRow = TOTAL_SEATS / TOTAL_ROWS;

        List<Seat> seats = new ArrayList<>();
        for (int row = 1; row <= TOTAL_ROWS; row++) {
            for (int number = 1; number <= seatsPerRow; number++) {
                seats.add(new Seat(screening, row, number, false));
            }
        }
        seatRepository.saveAll(seats);
    }

    @Transactional
    public void deleteScreening(Long screeningId) {
        if (screeningRepository.existsById(screeningId)) {
            screeningRepository.deleteById(screeningId);
        } else {
            throw new ScreeningNotFoundException("Screening not found");
        }
    }


}

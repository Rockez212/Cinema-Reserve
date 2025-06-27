package project.cinemareserve.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.cinemareserve.command.BookingCommand;
import project.cinemareserve.dtos.BookingDto;
import project.cinemareserve.entity.*;
import project.cinemareserve.exception.MovieNotFoundException;
import project.cinemareserve.exception.ScreeningNotHasBeenAnnouncedException;
import project.cinemareserve.exception.SeatNotFoundException;
import project.cinemareserve.exception.SeatReservedException;
import project.cinemareserve.mapper.BookingMapper;
import project.cinemareserve.repo.BookingRepository;
import project.cinemareserve.repo.MovieRepository;
import project.cinemareserve.repo.ScreeningRepository;
import project.cinemareserve.repo.SeatRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookingService {
    private final SeatRepository seatRepository;
    private final AuthService authService;
    private final BookingRepository bookingRepository;
    private final MovieRepository movieRepository;
    private final ScreeningRepository screeningRepository;
    private final BookingMapper bookingMapper;

    @Transactional
    public void create(BookingCommand command) {
        checkIfScreeningExists(command.getMovieId());

        User user = authService.getCurrentUser();
        Movie bookedMovie = movieRepository.findById(command.getMovieId()).orElseThrow(() -> new MovieNotFoundException("Movie Not Found"));

        Screening screening = screeningRepository.findFirstByMovieId(bookedMovie.getId());

        checkIfSeatsReserved(screening, command.getRow(), command.getNumberSeats());

        Seat seat = seatRepository.findByScreeningAndRowAndNumber(screening, command.getRow(), command.getNumberSeats()).orElseThrow(() -> new SeatNotFoundException("Seat Not Found222"));


        seat.setReserved(true);
        Booking newBooking = new Booking(user, seat);
        bookingRepository.save(newBooking);
    }

    @Transactional(readOnly = true)
    public List<BookingDto> getAll() {
        User currentUser = authService.getCurrentUser();

        return bookingRepository.findAllByUser(currentUser).stream().map(bookingMapper::toBookingDto).collect(Collectors.toList());
    }


    private void checkIfScreeningExists(Long movieId) {
        if (!screeningRepository.existsByMovieId(movieId)) {
            throw new ScreeningNotHasBeenAnnouncedException("Screening Not Has Been Announced");
        }
    }


    private void checkIfSeatsReserved(Screening screening, int row, int numberSeats) {
        Seat seatToCheck = seatRepository.findByScreeningAndRowAndNumber(screening, row, numberSeats).orElseThrow(() -> new SeatNotFoundException("Seat Not Found"));

        if (seatToCheck.isReserved()) {
            throw new SeatReservedException("Seat already reserved");
        }
    }

}

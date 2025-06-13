package project.cinemareserve.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.cinemareserve.command.BookingCommand;
import project.cinemareserve.dtos.BookingDto;
import project.cinemareserve.entity.Booking;
import project.cinemareserve.entity.Seat;
import project.cinemareserve.entity.User;
import project.cinemareserve.exception.SeatNotFoundException;
import project.cinemareserve.mapper.BookingMapper;
import project.cinemareserve.repo.BookingRepository;
import project.cinemareserve.repo.SeatRepository;
import project.cinemareserve.repo.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookingService {
    private final SeatRepository seatRepository;
    private final AuthService authService;
    private final BookingRepository bookingRepository;

    @Transactional
    public void registerBooking(BookingCommand command) {
        User user = authService.getCurrentUser();
        Seat seat = seatRepository.findById(command.getSeatId()).orElseThrow(() -> new SeatNotFoundException("Seat Not Found"));

        if (seat.isReserved()) {
            throw new RuntimeException("seat already reserved");
        }

        seat.setReserved(true);
        seatRepository.save(seat);

        Booking newBooking = new Booking(user, seat);
        bookingRepository.save(newBooking);
    }

    @Transactional
    public List<BookingDto> getBookings() {
        User currentUser = authService.getCurrentUser();
        return bookingRepository.findAllByUser(currentUser).stream()
                .map(BookingMapper::toBookingDto)
                .collect(Collectors.toList());
    }

}

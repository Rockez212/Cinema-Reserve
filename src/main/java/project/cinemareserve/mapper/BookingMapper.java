package project.cinemareserve.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import project.cinemareserve.dtos.BookingDto;
import project.cinemareserve.entity.Booking;
import project.cinemareserve.entity.Movie;
import project.cinemareserve.entity.Screening;
import project.cinemareserve.entity.Seat;
import project.cinemareserve.enums.HallPlace;

import java.time.format.DateTimeFormatter;

@Component
public class BookingMapper {

    public  BookingDto toBookingDto(Booking booking) {
        if (booking == null) {
            return null;
        }

        Seat seat = booking.getSeat();
        Screening screening = seat.getScreening();
        Movie movie = screening.getMovie();


        return new BookingDto(
                movie.getTitle(),
                screening.getStartTime(),
                screening.getEndTime(),
                screening.getHallName().getHallName(),
                seat.getRow(),
                seat.getNumber()
        );
    }
}

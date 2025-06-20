package project.cinemareserve.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import project.cinemareserve.dtos.BookingDto;
import project.cinemareserve.entity.Booking;
import project.cinemareserve.entity.Movie;
import project.cinemareserve.entity.Screening;
import project.cinemareserve.entity.Seat;
import project.cinemareserve.enums.HallPlace;

import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
public class BookingMapper {

    public static BookingDto toBookingDto(Booking booking) {
        if (booking == null) {
            return null;
        }

        Seat seat = booking.getSeat();
        Screening screening = seat.getScreening();
        Movie movie = screening.getMovie();

        String formattedTime = screening.getStartTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        return new BookingDto(
                movie.getTitle(),
                formattedTime,
                screening.getHallName().getHallName(),
                seat.getRow(),
                seat.getNumber()
        );
    }
}

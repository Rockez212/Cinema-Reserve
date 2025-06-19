package project.cinemareserve.command;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookingCommand {
    @Min(value = 1, message = "movieId must be at least 1")
    private Long movieId;
    @Size(min = 1, max = 25, message = "The row must contain from 1 to 4 characters.")
    private int row;
    @Size(min = 1, max = 25, message = "The seat must contain from 1 to 25 characters.")
    private int numberSeats;
}

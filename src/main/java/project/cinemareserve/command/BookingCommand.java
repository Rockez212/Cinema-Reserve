package project.cinemareserve.command;

import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookingCommand {
    @Min(value = 1, message = "movieId must be at least 1")
    private Long movieId;
    @Min(value = 1, message = "row must be at least 1")
    private int row;
    @Min(value = 1, message = "number seat must be at least 1")
    private int numberSeats;
}

package project.cinemareserve.command;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SeatRegisterCommand {
    @NotNull(message = "screeningId is mandatory")
    private Long screeningId;
    @Min(value = 1, message = "row must be at least 1")
    private int row;
    @Min(value = 1, message = "number must be at least 1")
    private int number;
    private boolean isReserved;

}

package project.cinemareserve.command;

import lombok.Data;
import lombok.NoArgsConstructor;
import project.cinemareserve.entity.Screening;

@Data
@NoArgsConstructor
public class SeatRegisterCommand {
    private Long screeningId;
    private int row;
    private int number;
    private boolean isReserved;
}

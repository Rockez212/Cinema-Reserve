package project.cinemareserve.command;

import lombok.Data;
import lombok.NoArgsConstructor;
import project.cinemareserve.entity.Movie;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ScreeningRegisterCommand {
    private Long movieId;
    private LocalDateTime startTime;
    private String hallName;
}

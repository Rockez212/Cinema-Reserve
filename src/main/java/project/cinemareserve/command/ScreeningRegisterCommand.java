package project.cinemareserve.command;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.cinemareserve.entity.Movie;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ScreeningRegisterCommand {
    @NotNull(message = "movieID is mandatory")
    @Min(value = 1, message = "movieID must be at least 1")
    private Long movieId;
    @NotNull(message = "startTime is mandatory")
    @Future(message = "startTime must be in the future")
    private LocalDateTime startTime;
    @NotBlank(message = "hall name is mandatory")
    private String hallName;
}

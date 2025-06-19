package project.cinemareserve.command;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieRegisterCommand {
    @NotBlank(message = "title is mandatory")
    private String title;
    @NotBlank(message = "description is mandatory")
    private String description;
    @NotNull(message = "durationMinutes is mandatory")
    @Min(value = 1, message = "durationMinutes must be at least 1")
    private int durationMinutes;
}

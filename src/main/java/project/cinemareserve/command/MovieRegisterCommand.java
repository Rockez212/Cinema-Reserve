package project.cinemareserve.command;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieRegisterCommand {
    private String title;
    private String description;
    private int durationMinutes;
}

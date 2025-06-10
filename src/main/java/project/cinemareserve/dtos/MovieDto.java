package project.cinemareserve.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieDto {
    private String title;
    private String description;
    private int durationMinutes;

    public MovieDto(String title, String description, int durationMinutes) {
        this.title = title;
        this.description = description;
        this.durationMinutes = durationMinutes;
    }
}

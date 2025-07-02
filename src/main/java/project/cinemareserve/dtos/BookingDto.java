package project.cinemareserve.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class BookingDto {
    private String movieTitle;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String hallName;
    private int row;
    private int number;
}

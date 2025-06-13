package project.cinemareserve.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingDto {
    private String movieTitle;
    private String startTime;
    private String hallName;
    private int row;
    private int number;
}

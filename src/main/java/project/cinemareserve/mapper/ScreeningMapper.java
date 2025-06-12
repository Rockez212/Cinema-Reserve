package project.cinemareserve.mapper;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import project.cinemareserve.dtos.ScreeningDto;
import project.cinemareserve.entity.Screening;

import java.time.format.DateTimeFormatter;

@Data
@RequiredArgsConstructor
public class ScreeningMapper {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public static ScreeningDto toScreeningDt(Screening screening) {
        if (screening == null) {
            return null;
        }
        return new ScreeningDto(MovieMapper.toMovieDto(screening.getMovie()),
                screening.getStartTime().format(FORMATTER),
                screening.getHallName());
    }
}

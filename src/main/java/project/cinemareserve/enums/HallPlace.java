package project.cinemareserve.enums;

import lombok.Getter;
import project.cinemareserve.exception.HallNotFoundException;

import java.lang.reflect.Array;
import java.util.Arrays;

@Getter
public enum HallPlace {
    IMAX("IMAX"),
    FOUR_DX("4DX"),
    VIP_LOUNGE("Vip Lounge"),
    COMFORT_PLUS("Comfort+"),
    DOLBY_ATMOSPHERE("Dolby Atmos");

    private final String hallName;

    HallPlace(String hallName) {
        this.hallName = hallName;
    }


    public static HallPlace getHallPlace(String hallName) {
        return Arrays.stream(HallPlace.values())
                .filter(hall -> hall.getHallName().equalsIgnoreCase(hallName))
                .findFirst()
                .orElseThrow(() -> new HallNotFoundException("Hall " + hallName + " not found"));
    }






}

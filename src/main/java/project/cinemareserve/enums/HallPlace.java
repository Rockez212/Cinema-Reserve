package project.cinemareserve.enums;

import lombok.Getter;
import project.cinemareserve.exception.HallNotFoundException;

@Getter
public enum HallPlace {
    IMAX(1, "IMAX"),
    FOUR_DX(2, "4DX"),
    VIP_LOUNGE(3, "Vip Lounge"),
    COMFORT_PLUS(4, "Comfort+"),
    DOLBY_ATMOSPHERE(5, "Dolby Atmos");

    private final int id;
    private final String hallName;

    HallPlace(int id, String hallName) {
        this.id = id;
        this.hallName = hallName;
    }


    public static HallPlace getHallPlace(int id) {
        for (HallPlace hallPlace : HallPlace.values()) {
            if (hallPlace.getId() == id) {
                return hallPlace;
            }
        }
        throw new HallNotFoundException("Hall place id %d is not found +: " + id);
    }


}

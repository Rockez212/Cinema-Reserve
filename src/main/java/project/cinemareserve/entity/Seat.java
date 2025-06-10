package project.cinemareserve.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Screening screening;
    private int row;
    private int number;
    private boolean isReserved;

    public Seat(Screening screening, int row, int number, boolean isReserved) {
        this.screening = screening;
        this.row = row;
        this.number = number;
        this.isReserved = isReserved;
    }

    protected Seat() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return Objects.equals(id, seat.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

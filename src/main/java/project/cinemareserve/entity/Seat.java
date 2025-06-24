package project.cinemareserve.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seats_seq")
    @SequenceGenerator(name = "seats_seq", sequenceName = "seats_id_seq", allocationSize = 1)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Screening screening;
    @Column(name = "row")
    private int row;
    @Column(name = "number")
    private int number;
    @Column(name = "is_reserved")
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

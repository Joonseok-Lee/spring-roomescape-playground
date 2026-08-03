package roomescape.entity;

import java.time.LocalDate;
import java.time.LocalTime;
<<<<<<< HEAD
import java.util.Objects;
=======
>>>>>>> ee19c22 (feat: MissionStepTest.이단계 테스트를 만족시키는 최소 구현 작성)

public class Reservation {

    private Long id;
<<<<<<< HEAD
    private String name;
    private LocalDate date;
    private LocalTime time;

=======

    private String name;

    private LocalDate date;

    private LocalTime time;

    public Reservation() {
    }

>>>>>>> ee19c22 (feat: MissionStepTest.이단계 테스트를 만족시키는 최소 구현 작성)
    public Reservation(String name, LocalDate date, LocalTime time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    private Reservation(Long id, String name, LocalDate date, LocalTime time) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

<<<<<<< HEAD
=======
    public static Reservation toEntity(Long id, Reservation reservation) {
        return new Reservation(id, reservation.name, reservation.date, reservation.time);
    }

>>>>>>> ee19c22 (feat: MissionStepTest.이단계 테스트를 만족시키는 최소 구현 작성)
    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }
<<<<<<< HEAD

    public static Reservation toEntityWithId(Long id, Reservation reservation) {
        return new Reservation(id, reservation.name, reservation.date, reservation.time);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Reservation other)) {
            return false;
        }
        return id != null && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

=======
>>>>>>> ee19c22 (feat: MissionStepTest.이단계 테스트를 만족시키는 최소 구현 작성)
}

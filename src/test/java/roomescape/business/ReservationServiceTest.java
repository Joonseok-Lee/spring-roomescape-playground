package roomescape.business;

<<<<<<< HEAD
import org.junit.jupiter.api.*;
import roomescape.dto.request.ReservationRequest;
import roomescape.entity.Reservation;
import roomescape.exception.ReservationNotFoundException;
import roomescape.repository.ReservationRepository;
import roomescape.service.ReservationService;
import roomescape.service.ReservationServiceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ReservationServiceTest {

    private ReservationService reservationService;

    @BeforeEach
    public void setup() {
        this.reservationService = new ReservationServiceImpl(new ReservationRepository());
    }

    @AfterEach
    public void teardown() {
        this.reservationService = null;
    }

    @Test
    @DisplayName("createReservation을 호출하면, 예약 엔터티를 반환한다")
    void createReservationTest() {
        // given
        ReservationRequest request = new ReservationRequest("Alice", LocalDate.now(), LocalTime.now());

        // when
        Reservation createdReservation = reservationService.createReservation(request);

        // then
        assertThat(createdReservation.getId()).isNotNull();
        assertThat(createdReservation.getName()).isEqualTo(request.name());
        assertThat(createdReservation.getDate()).isEqualTo(request.date());
        assertThat(createdReservation.getTime()).isEqualTo(request.time());
    }

    @Test
    @DisplayName("findAllReservations를 호출하면, 저장되어 있는 모든 예약을 반환한다.")
    void findAllReservationsTest() {
        // given
        ReservationRequest request = new ReservationRequest("Alice", LocalDate.now(), LocalTime.now());
        Reservation isNotSaved = new Reservation("Bob", LocalDate.now(), LocalTime.now());
        Reservation createdReservation = reservationService.createReservation(request);

        // when
        List<Reservation> reservations = reservationService.findAllReservations();

        // then
        assertThat(reservations.contains(createdReservation)).isTrue();
        assertThat(reservations.contains(isNotSaved)).isFalse();
    }

    @Test
    @DisplayName("deleteReservation()을 호출하면 저장되어 있는 레코드를 삭제한다.")
    void deleteReservationTest() {
        // given
        ReservationRequest request = new ReservationRequest("Alice", LocalDate.now(), LocalTime.now());
        Reservation createdReservation = reservationService.createReservation(request);

        // when
        reservationService.deleteReservation(createdReservation.getId());

        // then
        assertThat(reservationService.findAllReservations().size()).isEqualTo(0);
    }

    @Test
    @DisplayName("잘못된 ID로 deleteReservation()을 호출하면 예외가 발생한다.")
    void deleteReservationByIllegalIdTest() {
        // given
        ReservationRequest request = new ReservationRequest("Alice", LocalDate.now(), LocalTime.now());
        Reservation createdReservation = reservationService.createReservation(request);

        // then
        Assertions.assertThrows(
                ReservationNotFoundException.class,

                // when
                () -> reservationService
                        .deleteReservation(
                                createdReservation.getId() + 1L
                        )
        );
        assertThat(reservationService.findAllReservations().size()).isEqualTo(1);
=======
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;
import roomescape.dto.request.ReservationRequest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ReservationServiceTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup() {
        RestAssured.port = this.port;
    }

    @Test
    @DisplayName("예약 생성에 성공")
    void createReservation() {

        // given
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
        ReservationRequest request = new ReservationRequest("Alice", date, time);

        RestAssured
                .given()
                .body(request)
                .contentType(ContentType.JSON)
                .when().post("/reservations")
                .then()
                .statusCode(HttpStatus.FOUND.value())
                .header("Location", containsString("/reservations"));
    }

    @Test
    @DisplayName("예약 조회에 성공")
    void readReservation() {

        // given
        createReservation();

        RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .when().get("/reservations")
                .then().log().all()
                .statusCode(HttpStatus.OK.value())
                .body("size()", is(1));
>>>>>>> e323247 (고생하셨습니다.)
    }
}

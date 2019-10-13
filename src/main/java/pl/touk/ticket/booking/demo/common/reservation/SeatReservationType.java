package pl.touk.ticket.booking.demo.common.reservation;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

@Getter
@AllArgsConstructor
public enum SeatReservationType {

	ADULT(25.0, 29.0),
	STUDENT(18.0, 23.0),
	CHILD(12.5, 16.5);

	private final Double workDaysPrice;

	private final Double weekendPrice;

	public static Double from(SeatReservationType seatReservationType) {
		LocalDate currentDate = LocalDate.now(ZoneId.systemDefault());
		LocalTime currentTime = LocalTime.now(ZoneId.systemDefault());
		if ((currentDate.getDayOfWeek().equals(DayOfWeek.FRIDAY) && currentTime.isAfter(LocalTime.of(14, 00, 00)))
				|| currentDate.getDayOfWeek().equals(DayOfWeek.SATURDAY)
				|| (currentDate.getDayOfWeek().equals(DayOfWeek.SUNDAY) && currentTime.isBefore(LocalTime.of(23, 00, 00)))) {
			return seatReservationType.weekendPrice;
		}
		return seatReservationType.workDaysPrice;
	}

}

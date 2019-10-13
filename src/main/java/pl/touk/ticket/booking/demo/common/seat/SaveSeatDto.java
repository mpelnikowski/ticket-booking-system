package pl.touk.ticket.booking.demo.common.seat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.touk.ticket.booking.demo.common.reservation.SeatReservationType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SaveSeatDto {

	private Integer seatId;

	private Integer seatNumber;

	private Integer rowNumber;

	private Integer colNumber;

	private SeatReservationType seatReservationType;

	public Double getSeatReservationPrice(Integer discount) {
		if (discount != null) {
			return SeatReservationType.from(this.seatReservationType) * (discount / 100.0);
		}
		return SeatReservationType.from(this.seatReservationType);
	}
}

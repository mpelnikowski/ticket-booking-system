package pl.touk.ticket.booking.demo.common.screening;

import pl.touk.ticket.booking.demo.data.screening.Screening;
import pl.touk.ticket.booking.demo.data.screening.ScreeningSeat;
import pl.touk.ticket.booking.demo.data.seat.Seat;

import org.springframework.stereotype.Component;

@Component
public class ScreeningSeatMapper {

	public ScreeningSeat mapToEntity(Screening screening, Seat seat) {
		return ScreeningSeat.builder()
							.screening(screening)
							.seat(seat)
							.reserved(Boolean.FALSE)
							.build();
	}
}

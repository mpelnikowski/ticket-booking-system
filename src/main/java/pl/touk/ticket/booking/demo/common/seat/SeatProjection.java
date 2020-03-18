package pl.touk.ticket.booking.demo.common.seat;

import pl.touk.ticket.booking.demo.data.seat.Seat;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "SeatProjection", types = { Seat.class })
public interface SeatProjection {

	Integer getSeatId();

	Integer getSeatNumber();

	Integer getRowNumber();

	Integer getColNumber();

	Boolean getReserved();

}

package pl.touk.ticket.booking.demo.config.exception;

public class ReservationException extends RuntimeException {
	public ReservationException(String errorMessage) {
		super(errorMessage);
	}
}

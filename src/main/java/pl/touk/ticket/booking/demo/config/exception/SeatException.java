package pl.touk.ticket.booking.demo.config.exception;

public class SeatException extends RuntimeException {
	public SeatException(String errorMessage) {
		super(errorMessage);
	}
}

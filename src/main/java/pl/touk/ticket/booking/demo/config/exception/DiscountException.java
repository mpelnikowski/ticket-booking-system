package pl.touk.ticket.booking.demo.config.exception;

public class DiscountException extends RuntimeException {
	public DiscountException(String errorMessage) {
		super(errorMessage);
	}
}

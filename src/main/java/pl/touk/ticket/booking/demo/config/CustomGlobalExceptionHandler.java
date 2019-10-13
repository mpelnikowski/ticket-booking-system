package pl.touk.ticket.booking.demo.config;

import pl.touk.ticket.booking.demo.config.exception.ApiError;
import pl.touk.ticket.booking.demo.config.exception.DiscountException;
import pl.touk.ticket.booking.demo.config.exception.ReservationException;
import pl.touk.ticket.booking.demo.config.exception.SeatException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	public void constraintViolationException(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.OK.value());
	}

	@ExceptionHandler(DiscountException.class)
	public void handleDiscountException(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.OK.value());
	}

	@ExceptionHandler(ReservationException.class)
	public void handleReservationException(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.OK.value());
	}

	@ExceptionHandler(SeatException.class)
	public void handleSeatException(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.OK.value());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
																  HttpStatus status, WebRequest request) {

		List<String> errors = new ArrayList<>();
		for (FieldError error : ex.getBindingResult()
								  .getFieldErrors()) {
			errors.add(error.getField() + ": " + error.getDefaultMessage());
		}
		for (ObjectError error : ex.getBindingResult()
								   .getGlobalErrors()) {
			errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
		}

		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
		return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);

	}
}

package pl.touk.ticket.booking.demo.web.reservation;

import pl.touk.ticket.booking.demo.common.reservation.AtLeastOneNotEmptyConstraint;
import pl.touk.ticket.booking.demo.common.seat.SaveSeatDto;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.collections4.CollectionUtils;

public class AtLeastOneNotEmptyValidator implements ConstraintValidator<AtLeastOneNotEmptyConstraint, List<SaveSeatDto>> {

	@Override
	public boolean isValid(List<SaveSeatDto> seats, ConstraintValidatorContext constraintValidatorContext) {
		return CollectionUtils.isNotEmpty(seats);
	}
}

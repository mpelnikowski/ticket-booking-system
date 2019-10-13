package pl.touk.ticket.booking.demo.common.reservation;

import pl.touk.ticket.booking.demo.web.reservation.AtLeastOneNotEmptyValidator;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = AtLeastOneNotEmptyValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface AtLeastOneNotEmptyConstraint {

	String message() default "{Trzeba wybrac przynajmniej jedno miejsce}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}

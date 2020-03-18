package pl.touk.ticket.booking.demo.common.reservation;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.touk.ticket.booking.demo.common.seat.SaveSeatDto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
@EqualsAndHashCode
public class SaveReservationDto {

	private String discountCode;

	@Pattern(regexp = "[\\p{javaUpperCase}&&\\p{IsLatin}]+\\p{IsLatin}{2,}", message = "Błąd w imieniu")
	private String firstName;

	@Pattern(regexp = "[\\p{javaUpperCase}&&\\p{IsLatin}]+[[ '-]?\\p{IsLatin}+]{2,}", message = "Bład w nazwisku")
	private String lastName;

	@Pattern(regexp = "(?:[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", message = "Podany email jest niepoprawny")
	private String reservationEmail;

	@NotNull(message = "To pole nie może być puste")
	private Integer screeningId;

	@AtLeastOneNotEmptyConstraint
	private List<SaveSeatDto> seats;

}


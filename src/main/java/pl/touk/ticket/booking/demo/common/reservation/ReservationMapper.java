package pl.touk.ticket.booking.demo.common.reservation;

import pl.touk.ticket.booking.demo.data.discount.DiscountRepository;
import pl.touk.ticket.booking.demo.data.reservation.Reservation;
import pl.touk.ticket.booking.demo.data.screening.Screening;
import pl.touk.ticket.booking.demo.data.screening.ScreeningRepository;
import pl.touk.ticket.booking.demo.data.seat.SeatRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

	@Autowired
	private ScreeningRepository screeningRepository;

	@Autowired
	private SeatRepository seatRepository;

	@Autowired
	private DiscountRepository discountRepository;

	public Reservation mapDtoToEntity(SaveReservationDto saveReservationDto) {
		Screening screening = screeningRepository.getOne(saveReservationDto.getScreeningId());

		Optional<Integer> discountId = discountRepository.getDiscountValueByDiscountCode(saveReservationDto.getDiscountCode());

		BigDecimal reservationTotalCost = saveReservationDto.getSeats()
															.stream()
															.map(seatDto -> BigDecimal.valueOf(
																	seatDto.getSeatReservationPrice(discountId.orElse(null))))
															.reduce(BigDecimal.ZERO, BigDecimal::add);

		StringBuilder sb = new StringBuilder();
		sb.append(saveReservationDto.getFirstName())
		  .append(" ")
		  .append(saveReservationDto.getLastName());
		return Reservation.builder()
						  .reservationOwner(sb.toString())
						  .reservationContactEmail(saveReservationDto.getReservationEmail())
						  .reservationCost(reservationTotalCost)
						  .screening(screening)
						  .expirationTime(LocalDateTime.now()
													   .plusSeconds(15))
						  .discount(discountRepository.findByDiscountCode(saveReservationDto.getDiscountCode())
													  .orElse(null))
						  .build();
	}
}

package pl.touk.ticket.booking.demo.common.reservation;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@EqualsAndHashCode
public class ReservationDto {

	private BigDecimal reservationCost;

	private LocalDateTime expirationTime;

}

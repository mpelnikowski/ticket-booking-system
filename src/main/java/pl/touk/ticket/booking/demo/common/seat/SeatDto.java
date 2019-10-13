package pl.touk.ticket.booking.demo.common.seat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class SeatDto {

	private Integer seatRow;

	private Integer colNumber;

	private Integer seatNumber;

	private boolean reserved;
}

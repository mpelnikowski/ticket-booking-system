package pl.touk.ticket.booking.demo.common.screening;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.touk.ticket.booking.demo.common.auditorium.AuditoriumDto;
import pl.touk.ticket.booking.demo.common.seat.SeatDto;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class ScreeningDto {

	private LocalDateTime screeningStartTime;

	private AuditoriumDto auditorium;

	private List<SeatDto> seats;

}

package pl.touk.ticket.booking.demo.common.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MovieSearchDto {

	@NotNull
	private LocalDateTime startDate;

	@NotNull
	private LocalDateTime endDate;

}

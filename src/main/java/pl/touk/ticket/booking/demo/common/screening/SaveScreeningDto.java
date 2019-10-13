package pl.touk.ticket.booking.demo.common.screening;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class SaveScreeningDto {

	@NotNull
	private Integer movieId;

	@NotNull
	private Integer auditoriumId;

	@NotNull
	private LocalDateTime screeningStart;

}

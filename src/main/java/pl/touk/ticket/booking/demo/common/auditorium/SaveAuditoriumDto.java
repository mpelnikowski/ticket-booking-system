package pl.touk.ticket.booking.demo.common.auditorium;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class SaveAuditoriumDto {

	@NotBlank
	private String name;

	@NotNull
	private Integer rowCount;

	@NotNull
	private Integer colCount;
}

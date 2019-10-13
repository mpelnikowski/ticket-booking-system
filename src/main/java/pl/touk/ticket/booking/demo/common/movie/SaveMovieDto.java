package pl.touk.ticket.booking.demo.common.movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SaveMovieDto {

	@NotBlank
	private String title;

	@NotBlank
	private String description;

	@NotBlank
	private String director;

	@NotNull
	private Integer duration;
}

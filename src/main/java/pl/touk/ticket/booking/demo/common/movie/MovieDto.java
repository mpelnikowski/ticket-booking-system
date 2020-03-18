package pl.touk.ticket.booking.demo.common.movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class MovieDto {

	private String title;

	private String description;

	private List<LocalDateTime> screeningsStartTime;
}

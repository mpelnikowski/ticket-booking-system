package pl.touk.ticket.booking.demo.common.movie;

import pl.touk.ticket.booking.demo.data.movie.Movie;
import pl.touk.ticket.booking.demo.data.screening.Screening;

import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

	public Movie mapSaveDtoToEntity(SaveMovieDto saveMovieDto) {
		return Movie.builder()
					.title(saveMovieDto.getTitle())
					.description(saveMovieDto.getDescription())
					.director(saveMovieDto.getDirector())
					.duration(saveMovieDto.getDuration())
					.build();
	}

	public static Function<Movie, MovieDto> mapEntityToDto() {
		return movie -> MovieDto.builder()
								.title(movie.getTitle())
								.description(movie.getDescription())
								.screeningsStartTime(movie.getScreening()
														  .stream()
														  .map(Screening::getScreeningStart)
														  .sorted()
														  .collect(Collectors.toList()))
								.build();
	}

}

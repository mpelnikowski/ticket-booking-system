package pl.touk.ticket.booking.demo.data.screening;

import pl.touk.ticket.booking.demo.common.screening.SaveScreeningDto;
import pl.touk.ticket.booking.demo.data.auditorium.AuditoriumRepository;
import pl.touk.ticket.booking.demo.data.movie.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScreeningMapper {

	@Autowired
	private AuditoriumRepository auditoriumRepository;

	@Autowired
	private MovieRepository movieRepository;

	public Screening mapEntityFromDto(SaveScreeningDto saveScreeningDto) {
		return Screening.builder()
						.auditorium(auditoriumRepository.getOne(saveScreeningDto.getAuditoriumId()))
						.movie(movieRepository.getOne(saveScreeningDto.getMovieId()))
						.screeningStart(saveScreeningDto.getScreeningStart())
						.build();
	}
}

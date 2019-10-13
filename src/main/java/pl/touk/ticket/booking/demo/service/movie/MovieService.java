package pl.touk.ticket.booking.demo.service.movie;

import pl.touk.ticket.booking.demo.common.movie.MovieDto;
import pl.touk.ticket.booking.demo.common.movie.MovieMapper;
import pl.touk.ticket.booking.demo.common.movie.MovieSearchDto;
import pl.touk.ticket.booking.demo.common.movie.SaveMovieDto;
import pl.touk.ticket.booking.demo.data.movie.MovieRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private MovieMapper movieMapper;

	@Transactional(readOnly = true)
	public List<MovieDto> findMoviesInPeriodTime(MovieSearchDto movieSearchDto) {
		return movieRepository.findAllMoviesInPeriod(movieSearchDto.getStartDate(), movieSearchDto.getEndDate())
							  .stream()
							  .map(MovieMapper.mapEntityToDto())
							  .collect(Collectors.toList());
	}

	public void addMovie(SaveMovieDto saveMovieDto) {
		movieRepository.save(movieMapper.mapSaveDtoToEntity(saveMovieDto));
	}

}

package pl.touk.ticket.booking.demo.web.movie;

import pl.touk.ticket.booking.demo.common.movie.MovieDto;
import pl.touk.ticket.booking.demo.common.movie.MovieSearchDto;
import pl.touk.ticket.booking.demo.common.movie.SaveMovieDto;
import pl.touk.ticket.booking.demo.service.movie.MovieService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping("/findAllMovies")
	public ResponseEntity<List<MovieDto>> findMoviesInPeriodTime(@RequestBody MovieSearchDto movieSearchDto) {
		List<MovieDto> moviesInPeriodTime = movieService.findMoviesInPeriodTime(movieSearchDto);
		return new ResponseEntity<>(moviesInPeriodTime, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity addMovie(@Valid @RequestBody SaveMovieDto saveMovieDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.OK);
		}
		movieService.addMovie(saveMovieDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}

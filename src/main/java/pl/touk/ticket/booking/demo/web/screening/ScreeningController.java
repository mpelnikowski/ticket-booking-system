package pl.touk.ticket.booking.demo.web.screening;

import pl.touk.ticket.booking.demo.common.screening.SaveScreeningDto;
import pl.touk.ticket.booking.demo.common.screening.ScreeningDto;
import pl.touk.ticket.booking.demo.service.screening.ScreeningService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/screening")
public class ScreeningController {

	@Autowired
	private ScreeningService screeningService;

	@GetMapping("/getScreening")
	public ResponseEntity<ScreeningDto> getScreening(@RequestParam Integer screeningId) {
		ScreeningDto screening = screeningService.getScreeningById(screeningId);
		return new ResponseEntity<>(screening, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity addScreening(@Valid @RequestBody SaveScreeningDto saveScreeningDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.OK);
		}
		screeningService.addScreening(saveScreeningDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

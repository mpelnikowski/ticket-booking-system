package pl.touk.ticket.booking.demo.web.auditorium;

import pl.touk.ticket.booking.demo.common.auditorium.SaveAuditoriumDto;
import pl.touk.ticket.booking.demo.service.auditorium.AuditoriumService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auditorium")
public class AuditoriumController {

	@Autowired
	private AuditoriumService auditoriumService;

	@PostMapping("/add")
	public ResponseEntity addAuditorium(@Valid @RequestBody SaveAuditoriumDto saveAuditoriumDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.OK);
		}
		auditoriumService.addAuditorium(saveAuditoriumDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

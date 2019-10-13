package pl.touk.ticket.booking.demo.web.reservation;

import pl.touk.ticket.booking.demo.common.reservation.ReservationDto;
import pl.touk.ticket.booking.demo.common.reservation.SaveReservationDto;
import pl.touk.ticket.booking.demo.service.reservation.ReservationService;

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
@RequestMapping(value = "/reservation")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	@PostMapping("/create")
	public ResponseEntity createReservation(@Valid @RequestBody SaveReservationDto saveReservationDto, BindingResult bindingResult)
			throws Exception {

		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.OK);
		}
		ReservationDto reservationDto = reservationService.createReservation(saveReservationDto);
		return new ResponseEntity<>(reservationDto, HttpStatus.OK);
	}
}

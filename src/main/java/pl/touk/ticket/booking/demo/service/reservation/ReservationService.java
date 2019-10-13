package pl.touk.ticket.booking.demo.service.reservation;

import liquibase.util.StringUtils;
import pl.touk.ticket.booking.demo.common.reservation.ReservationDto;
import pl.touk.ticket.booking.demo.common.reservation.ReservationMapper;
import pl.touk.ticket.booking.demo.common.reservation.SaveReservationDto;
import pl.touk.ticket.booking.demo.config.exception.ReservationException;
import pl.touk.ticket.booking.demo.data.reservation.Reservation;
import pl.touk.ticket.booking.demo.data.reservation.ReservationRepository;
import pl.touk.ticket.booking.demo.data.screening.ScreeningRepository;
import pl.touk.ticket.booking.demo.data.screening.ScreeningSeatRepository;
import pl.touk.ticket.booking.demo.service.discount.DiscountService;
import pl.touk.ticket.booking.demo.service.seat.SeatService;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private ScreeningRepository screeningRepository;

	@Autowired
	private SeatService seatService;

	@Autowired
	private ReservationMapper reservationMapper;

	@Autowired
	private ScreeningSeatRepository screeningSeatRepository;

	@Autowired
	private DiscountService discountService;

	@Modifying
	public ReservationDto createReservation(SaveReservationDto saveReservationDto) throws Exception {
		LocalDateTime screeningStart = screeningRepository.getOne(saveReservationDto.getScreeningId())
														  .getScreeningStart();
		allowToMakeReservation(screeningStart);

		if (StringUtils.isNotEmpty(saveReservationDto.getDiscountCode())) {
			discountService.validDiscount(saveReservationDto.getDiscountCode()
															.trim()
															.toUpperCase(), saveReservationDto.getReservationEmail());
		}

		saveReservationDto.getSeats()
						  .forEach(seatDto -> seatService.validSeat(saveReservationDto.getScreeningId(), seatDto.getRowNumber(),
																	seatDto.getColNumber()));

		Reservation reservation = reservationRepository.save(reservationMapper.mapDtoToEntity(saveReservationDto));

		saveReservationDto.getSeats()
						  .forEach(seatDto -> screeningSeatRepository.updateByScreeningIdAndSeatId(Boolean.TRUE,
																								   saveReservationDto.getScreeningId(),
																								   seatDto.getSeatId()));

		return ReservationDto.builder()
							 .reservationCost(reservation.getReservationCost())
							 .expirationTime(reservation.getExpirationTime())
							 .build();
	}

	private void allowToMakeReservation(LocalDateTime screeningStart) throws ReservationException {
		if (LocalDateTime.now(ZoneId.systemDefault())
						 .plusMinutes(15)
						 .isAfter(screeningStart)) {
			throw new ReservationException("Jest już za późno żeby dokonać rezerwacji");
		}
	}

}

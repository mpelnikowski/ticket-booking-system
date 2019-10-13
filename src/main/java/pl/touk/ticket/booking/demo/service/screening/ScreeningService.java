package pl.touk.ticket.booking.demo.service.screening;

import pl.touk.ticket.booking.demo.common.auditorium.AuditoriumMapper;
import pl.touk.ticket.booking.demo.common.screening.SaveScreeningDto;
import pl.touk.ticket.booking.demo.common.screening.ScreeningDto;
import pl.touk.ticket.booking.demo.data.auditorium.AuditoriumRepository;
import pl.touk.ticket.booking.demo.data.screening.Screening;
import pl.touk.ticket.booking.demo.data.screening.ScreeningMapper;
import pl.touk.ticket.booking.demo.data.screening.ScreeningRepository;
import pl.touk.ticket.booking.demo.data.seat.Seat;
import pl.touk.ticket.booking.demo.data.seat.SeatRepository;
import pl.touk.ticket.booking.demo.service.seat.SeatService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ScreeningService {

	@Autowired
	private AuditoriumRepository auditoriumRepository;

	@Autowired
	private ScreeningRepository screeningRepository;

	@Autowired
	private SeatService seatService;

	@Autowired
	private SeatRepository seatRepository;

	@Autowired
	private AuditoriumMapper auditoriumMapper;

	@Autowired
	private ScreeningMapper screeningMapper;

	@Transactional(readOnly = true)
	public ScreeningDto getScreeningById(Integer screeningId) {
		return ScreeningDto.builder()
						   .screeningStartTime(screeningRepository.getOne(screeningId)
																  .getScreeningStart())
						   .auditorium(auditoriumMapper.mapEntityToDto(auditoriumRepository.findByScreeningId(screeningId)))
						   .seats(seatService.findAllSeatsByScreeningId(screeningId))
						   .build();
	}

	public void addScreening(SaveScreeningDto saveScreeningDto) {
		Screening screening = screeningRepository.save(screeningMapper.mapEntityFromDto(saveScreeningDto));

		List<Seat> seats = seatRepository.findByAuditoriumId(saveScreeningDto.getAuditoriumId());
		seatService.saveScreeningSeats(screening, seats);
	}

}

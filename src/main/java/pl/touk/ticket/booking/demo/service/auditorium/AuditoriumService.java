package pl.touk.ticket.booking.demo.service.auditorium;

import pl.touk.ticket.booking.demo.common.auditorium.SaveAuditoriumDto;
import pl.touk.ticket.booking.demo.data.auditorium.Auditorium;
import pl.touk.ticket.booking.demo.data.auditorium.AuditoriumRepository;
import pl.touk.ticket.booking.demo.data.seat.Seat;
import pl.touk.ticket.booking.demo.data.seat.SeatRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuditoriumService {

	@Autowired
	private AuditoriumRepository auditoriumRepository;

	@Autowired
	private SeatRepository seatRepository;

	public Auditorium addAuditorium(SaveAuditoriumDto auditoriumDto) {
		Auditorium auditorium = auditoriumRepository.save(Auditorium.builder()
																	.name(auditoriumDto.getName())
																	.build());
		List<Seat> seats = new ArrayList<>();
		int seatNumber = 1;
		for (int r = 1; r <= auditoriumDto.getRowCount(); r++) {
			for (int c = 1; c <= auditoriumDto.getColCount(); c++) {
				seats.add(Seat.builder()
							  .rowNumber(r)
							  .colNumber(c)
							  .seatNumber(seatNumber)
							  .auditorium(auditorium)
							  .build());
				seatNumber++;
			}
		}
		seatRepository.saveAll(seats);
		return auditorium;
	}
}

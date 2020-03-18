package pl.touk.ticket.booking.demo.service.seat;

import pl.touk.ticket.booking.demo.common.screening.ScreeningSeatMapper;
import pl.touk.ticket.booking.demo.common.seat.SeatDto;
import pl.touk.ticket.booking.demo.common.seat.SeatProjection;
import pl.touk.ticket.booking.demo.config.exception.SeatException;
import pl.touk.ticket.booking.demo.data.screening.Screening;
import pl.touk.ticket.booking.demo.data.screening.ScreeningSeat;
import pl.touk.ticket.booking.demo.data.screening.ScreeningSeatRepository;
import pl.touk.ticket.booking.demo.data.seat.Seat;
import pl.touk.ticket.booking.demo.data.seat.SeatRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SeatService {

	@Autowired
	private SeatRepository seatRepository;

	@Autowired
	private ScreeningSeatRepository screeningSeatRepository;

	@Autowired
	private ScreeningSeatMapper screeningSeatMapper;

	@Transactional(readOnly = true)
	public List<SeatDto> findAllSeatsByScreeningId(Integer screeningId) {

		List<SeatProjection> allSeatsByScreeningId1 = seatRepository.findAllSeatsByScreeningId(screeningId);

		return allSeatsByScreeningId1.stream()
									 .map(this::mapEntityToDto)
									 .collect(Collectors.toList());
	}

	public void validSeat(Integer screeningId, Integer rowNumber, Integer colNumber) {
		List<SeatProjection> seatsInRowByScreeningId = seatRepository.findSeatsInRowByScreeningId(screeningId, rowNumber);

		if (colNumber > 2) {
			if (seatsInRowByScreeningId.get(colNumber - 1)
									   .getReserved() || (seatsInRowByScreeningId.get(colNumber - 3)
																				 .getReserved() && !seatsInRowByScreeningId.get(
					colNumber - 2)
																														   .getReserved())) {
				throw new SeatException("Nie można dokonać rezerwacji tego miejsca!");
			}
		}

		if (colNumber == seatsInRowByScreeningId.size() - 2) {
			if (seatsInRowByScreeningId.get(colNumber - 1)
									   .getReserved() || (!seatsInRowByScreeningId.get(seatsInRowByScreeningId.size() - 1)
																				  .getReserved())) {
				throw new SeatException("Nie można dokonać rezerwacji tego miejsca!");
			}
		} else if (colNumber < seatsInRowByScreeningId.size() - 2) {
			if (seatsInRowByScreeningId.get(colNumber - 1)
									   .getReserved() || (seatsInRowByScreeningId.get(colNumber + 1)
																				 .getReserved() && !seatsInRowByScreeningId.get(colNumber)
																														   .getReserved())) {
				throw new SeatException("Nie można dokonać rezerwacji tego miejsca!");
			}
		}

	}

	public void saveScreeningSeats(Screening screening, List<Seat> seats) {
		List<ScreeningSeat> screeningSeats = new ArrayList<>();
		seats.forEach(seat -> screeningSeats.add(screeningSeatMapper.mapToEntity(screening, seat)));

		screeningSeatRepository.saveAll(screeningSeats);
	}

	private SeatDto mapEntityToDto(SeatProjection seat) {
		return SeatDto.builder()
					  .seatRow(seat.getRowNumber())
					  .colNumber(seat.getColNumber())
					  .seatNumber(seat.getSeatNumber())
					  .reserved(seat.getReserved())
					  .build();
	}
}

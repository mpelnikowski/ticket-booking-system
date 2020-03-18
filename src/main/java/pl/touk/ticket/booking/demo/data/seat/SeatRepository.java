package pl.touk.ticket.booking.demo.data.seat;

import pl.touk.ticket.booking.demo.common.seat.SeatProjection;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SeatRepository extends JpaRepository<Seat, Integer> {

	List<Seat> findByAuditoriumId(Integer auditoriumId);

	// @formatter:off
	@Query(value = "select s.SeatNumber, s.RowNumber, s.ColNumber, ss.Reserved from Seat s "
			+ "left join ScreeningSeat ss on ss.SeatID = s.SeatId "
			+ "where ss.ScreeningID = :screeningId", nativeQuery = true)
	// @formatter:on
	List<SeatProjection> findAllSeatsByScreeningId(@Param("screeningId") Integer screeningId);

	// @formatter:off
	@Query(value = "select s.SeatID,s.SeatNumber, s.RowNumber, s.ColNumber, ss.Reserved from Seat s "
			+ "left join ScreeningSeat ss on ss.SeatID = s.SeatId "
			+ "where ss.ScreeningID = :screeningId and s.RowNumber = :rowNumber", nativeQuery = true)
	// @formatter:on
	List<SeatProjection> findSeatsInRowByScreeningId(@Param("screeningId") Integer screeningId, @Param("rowNumber") Integer rowNumber);
}

package pl.touk.ticket.booking.demo.data.screening;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningSeatRepository extends JpaRepository<ScreeningSeat, Integer> {

	@Modifying
	@Query("update ScreeningSeat set reserved = :reserved where ScreeningID = :screeningId and SeatID = :seatId")
	void updateByScreeningIdAndSeatId(@Param("reserved") Boolean reserved, @Param("screeningId") Integer screeningId,
										@Param("seatId") Integer seatId);

}

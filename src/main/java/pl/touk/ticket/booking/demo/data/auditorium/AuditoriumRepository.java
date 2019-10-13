package pl.touk.ticket.booking.demo.data.auditorium;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuditoriumRepository extends JpaRepository<Auditorium, Integer> {

	// @formatter:off
	@Query("select a from Auditorium a "
			+ "left join fetch a.screening s "
			+ "where s.id = :screeningId")
	// @formatter:on
	Auditorium findByScreeningId(@Param("screeningId") Integer screeningId);

}

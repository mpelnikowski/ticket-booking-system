package pl.touk.ticket.booking.demo.data.movie;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

	// @formatter:off
	@Query("select m from Movie m " +
			"left join fetch m.screening s " +
			"where s.screeningStart between :startDate and :endDate ")
	// @formatter:on
	Set<Movie> findAllMoviesInPeriod(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

}

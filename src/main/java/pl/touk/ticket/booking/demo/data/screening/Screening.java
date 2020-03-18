package pl.touk.ticket.booking.demo.data.screening;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.touk.ticket.booking.demo.data.auditorium.Auditorium;
import pl.touk.ticket.booking.demo.data.movie.Movie;
import pl.touk.ticket.booking.demo.data.reservation.Reservation;
import pl.touk.ticket.booking.demo.data.seat.Seat;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Getter
@Builder
@Entity
@Table(name = "Screening")
@NoArgsConstructor
@AllArgsConstructor
public class Screening {

	@Id
	@Column(name = "ScreeningID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MovieID", nullable = false)
	private Movie movie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AuditoriumID", nullable = false)
	private Auditorium auditorium;

	@Column(name = "ScreeningStart", nullable = false)
	private LocalDateTime screeningStart;

	@OneToMany(mappedBy = "screening")
	private Set<Reservation> reservations;

	@ManyToMany()
	@JoinTable(name = "ScreeningSeat", joinColumns = { @JoinColumn(name = "ScreeningID") }, inverseJoinColumns = {
			@JoinColumn(name = "SeatID") })
	private Set<Seat> seats;

}

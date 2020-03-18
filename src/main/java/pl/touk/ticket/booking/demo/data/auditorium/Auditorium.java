package pl.touk.ticket.booking.demo.data.auditorium;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.touk.ticket.booking.demo.data.screening.Screening;
import pl.touk.ticket.booking.demo.data.seat.Seat;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "Auditorium")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Auditorium {

	@Id
	@Column(name = "AuditoriumID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Name", nullable = false)
	private String name;

	@OneToMany(mappedBy = "auditorium")
	private Set<Screening> screening;

	@OneToMany(mappedBy = "auditorium")
	private Set<Seat> seats;
}

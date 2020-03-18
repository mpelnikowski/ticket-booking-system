package pl.touk.ticket.booking.demo.data.seat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.touk.ticket.booking.demo.data.auditorium.Auditorium;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Seat")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seat {

	@Id
	@Column(name = "SeatID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "RowNumber")
	private Integer rowNumber;

	@Column(name = "ColNumber")
	private Integer colNumber;

	@Column(name = "SeatNumber")
	private Integer seatNumber;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AuditoriumID", nullable = false)
	private Auditorium auditorium;
}

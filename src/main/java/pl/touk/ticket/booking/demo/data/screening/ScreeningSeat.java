package pl.touk.ticket.booking.demo.data.screening;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.touk.ticket.booking.demo.data.seat.Seat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Entity
@Builder
@Table(name = "ScreeningSeat")
@NoArgsConstructor
@AllArgsConstructor
public class ScreeningSeat {

	@Id
	@Column(name = "ScreeningSeatID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SeatID")
	private Seat seat;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ScreeningID")
	private Screening screening;

	@Column(name = "Reserved")
	private Boolean reserved;
}

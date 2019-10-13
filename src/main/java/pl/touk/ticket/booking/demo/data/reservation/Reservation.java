package pl.touk.ticket.booking.demo.data.reservation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.touk.ticket.booking.demo.data.discount.Discount;
import pl.touk.ticket.booking.demo.data.screening.Screening;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "Reservation")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {

	@Id
	@Column(name = "ReservationID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Active", nullable = false)
	private boolean active;

	@Column(name = "Reserved", nullable = false)
	private boolean reserved;

	@Column(name = "ReservationCost", nullable = false)
	private BigDecimal reservationCost;

	@Column(name = "ReservationOwner", nullable = false)
	private String reservationOwner;

	@Column(name = "ReservationOwnerEmail", nullable = false)
	private String reservationContactEmail;

	@Column(name = "ExpirationTime", nullable = false)
	private LocalDateTime expirationTime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ScreeningID", nullable = false)
	private Screening screening;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DiscountID")
	private Discount discount;

}

package pl.touk.ticket.booking.demo.data.discount;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "Discount")
@NoArgsConstructor
@AllArgsConstructor
public class Discount {

	@Id
	@Column(name = "DiscountID")
	@GeneratedValue
	private Integer id;

	@Column(name = "DiscountCode")
	private String discountCode;

	@Column(name = "DiscountValue")
	private Integer discountValue;
}

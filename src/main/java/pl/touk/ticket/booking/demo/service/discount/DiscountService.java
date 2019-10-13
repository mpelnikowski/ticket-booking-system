package pl.touk.ticket.booking.demo.service.discount;

import pl.touk.ticket.booking.demo.config.exception.DiscountException;
import pl.touk.ticket.booking.demo.config.exception.SeatException;
import pl.touk.ticket.booking.demo.data.discount.Discount;
import pl.touk.ticket.booking.demo.data.discount.DiscountRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DiscountService {

	@Autowired
	private DiscountRepository discountRepository;

	@Transactional(readOnly = true)
	public void validDiscount(String discountCode, String reservationEmail) throws SeatException {
		Optional<Discount> discount = discountRepository.findByDiscountCode(discountCode);

		if (discount.isEmpty()) {
			throw new DiscountException("Podany kod promocyjny jest niepoprawny");
		} else if (discountRepository.validDiscountCode(discount.get()
																.getId(), reservationEmail) != 0) {
			throw new DiscountException("Podany kod promocyjny został już wykorzystany");
		}
	}

}

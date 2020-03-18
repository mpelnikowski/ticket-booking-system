package pl.touk.ticket.booking.demo.data.discount;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer> {

	@Query("select d.discountValue from Discount d where d.discountCode = :discountCode ")
	Optional<Integer> getDiscountValueByDiscountCode(@Param("discountCode") String discountCode);

	Optional<Discount> findByDiscountCode(String discountCode);

	@Query("select count(r.id) from Reservation r where (r.active = FALSE OR r.reserved = FALSE) and r.reservationContactEmail = :clientEmail and r.discount.id = :discountId")
	Integer validDiscountCode(@Param("discountId") Integer discountId, @Param("clientEmail") String clientEmail);
}

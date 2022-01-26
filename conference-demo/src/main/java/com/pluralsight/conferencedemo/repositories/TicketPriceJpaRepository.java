package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.Speaker;
import com.pluralsight.conferencedemo.models.TicketPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.math.BigDecimal;
import java.util.List;

@RepositoryRestResource(exported = false)
public interface TicketPriceJpaRepository extends JpaRepository<TicketPrice, Long> {
	@Query(
			"select tp from TicketPrice tp where tp.basePrice < ?1 " +
					"and tp.ticketType.includesWorkshop = true"
	)
	List<TicketPrice> getTicketsUnderPriceWithWorkShops(BigDecimal maxPrice);
	List<TicketPrice> nativeFindTicketsByCategoryWithWorkshop(@Param("name") String name);
}

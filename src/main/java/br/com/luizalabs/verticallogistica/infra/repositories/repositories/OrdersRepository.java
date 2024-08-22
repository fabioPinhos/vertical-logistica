package br.com.luizalabs.verticallogistica.infra.repositories.repositories;

import br.com.luizalabs.verticallogistica.core.domain.entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

    @Query("SELECT e FROM orders e " +
            "WHERE (e.date >= :startDate AND e.date <= :endDate)")
    Page<Orders> findFilteredOrders(@Param("startDate") Date startDate,
                                   @Param("endDate") Date endDate,
                                   Pageable pageable);


}

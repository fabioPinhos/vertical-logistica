package br.com.luizalabs.verticallogistica.infra.repositories.repositories;

import br.com.luizalabs.verticallogistica.core.domain.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}

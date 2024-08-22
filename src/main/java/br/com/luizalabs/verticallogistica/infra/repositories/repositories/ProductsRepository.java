package br.com.luizalabs.verticallogistica.infra.repositories.repositories;

import br.com.luizalabs.verticallogistica.core.domain.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Long> {
}

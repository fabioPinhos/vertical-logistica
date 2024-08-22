package br.com.luizalabs.verticallogistica.infra.repositories.repositories;

import br.com.luizalabs.verticallogistica.core.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

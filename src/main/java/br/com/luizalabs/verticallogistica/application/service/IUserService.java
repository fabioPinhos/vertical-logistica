package br.com.luizalabs.verticallogistica.application.service;

import br.com.luizalabs.verticallogistica.core.domain.dto.UserDto;
import br.com.luizalabs.verticallogistica.core.domain.entity.User;

public interface IUserService {

    User create(UserDto dto);

    User getUserById(Long id);
}

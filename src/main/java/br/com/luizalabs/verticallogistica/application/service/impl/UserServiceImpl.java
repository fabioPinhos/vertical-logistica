package br.com.luizalabs.verticallogistica.application.service.impl;

import br.com.luizalabs.verticallogistica.application.service.IUserService;
import br.com.luizalabs.verticallogistica.core.domain.dto.UserDto;
import br.com.luizalabs.verticallogistica.core.domain.entity.User;
import br.com.luizalabs.verticallogistica.core.exception.UserNotFoundException;
import br.com.luizalabs.verticallogistica.infra.repositories.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(UserDto dto) {

        User user = User.builder()
                .name(dto.name())
                .user_id(dto.user_id())
                .build();

        repository.save(user);

        return user;
    }

    @Override
    public User getUserById(Long id){
        return repository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}

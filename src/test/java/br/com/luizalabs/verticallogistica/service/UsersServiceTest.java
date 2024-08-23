package br.com.luizalabs.verticallogistica.service;

import br.com.luizalabs.verticallogistica.application.service.impl.UserServiceImpl;
import br.com.luizalabs.verticallogistica.core.domain.dto.UserDto;
import br.com.luizalabs.verticallogistica.core.domain.entity.Orders;
import br.com.luizalabs.verticallogistica.core.domain.entity.Products;
import br.com.luizalabs.verticallogistica.core.domain.entity.User;
import br.com.luizalabs.verticallogistica.infra.repositories.repositories.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class UsersServiceTest {

    @Autowired
    private UserServiceImpl service;

    @MockBean
    private UserRepository repository;

    @Autowired
    protected MockMvc mvc;

    @Test
    void testBuscarUserById() {
        when(repository.findById(criarParametro().getUser_id())).thenReturn(Optional.of(criarParametro()));

        User userById = service.getUserById(criarParametro().getUser_id());

        assertEquals(userById.getUser_id(), criarParametro().getUser_id());
        assertEquals(userById.getName(), criarParametro().getName());
    }

    @Test
    void deveCriarOk() throws IOException {

        User users = criarParametro();

        when(repository.save(users)).thenReturn(users);

        User dtos = service.create(criarParametroDto());

        assertEquals(dtos.getUser_id(), 123L);
        assertEquals(users.getName(), "Fabio");
    }

    private User criarParametro(){
        return User.builder()
                .user_id(123L)
                .name("Fabio").build();
    }

    private UserDto criarParametroDto(){
        return new UserDto(123L, "Fabio", Lists.list());
    }


    public static byte[] convertObjectToJsonBytes(Object object) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsBytes(object);
    }


}

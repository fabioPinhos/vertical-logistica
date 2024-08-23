package br.com.luizalabs.verticallogistica.controller;

import br.com.luizalabs.verticallogistica.application.service.impl.UserServiceImpl;
import br.com.luizalabs.verticallogistica.core.domain.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class UsersControllerTest {

    @Autowired
    protected MockMvc mvc;

    @MockBean
    private UserServiceImpl service;

    @Test
    void testBuscarUserById() throws Exception {
        when(service.getUserById(any())).thenReturn(any());

        mvc.perform(MockMvcRequestBuilders
                .get("/v1/api/users/55")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonBytes(criarParametro()))
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    private User criarParametro(){
        return User.builder()
                .user_id(123L)
                .name("Fabio").build();
    }


    public static byte[] convertObjectToJsonBytes(Object object) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsBytes(object);
    }
}

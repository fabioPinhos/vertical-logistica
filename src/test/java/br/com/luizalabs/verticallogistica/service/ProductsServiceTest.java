package br.com.luizalabs.verticallogistica.service;

import br.com.luizalabs.verticallogistica.application.service.impl.ProductsServiceImpl;
import br.com.luizalabs.verticallogistica.application.service.impl.UserServiceImpl;
import br.com.luizalabs.verticallogistica.core.domain.dto.ProductsDto;
import br.com.luizalabs.verticallogistica.core.domain.dto.UserDto;
import br.com.luizalabs.verticallogistica.core.domain.entity.Products;
import br.com.luizalabs.verticallogistica.core.domain.entity.User;
import br.com.luizalabs.verticallogistica.infra.repositories.repositories.ProductsRepository;
import br.com.luizalabs.verticallogistica.infra.repositories.repositories.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductsServiceTest {

    @Autowired
    private ProductsServiceImpl service;

    @MockBean
    private ProductsRepository repository;

    @Autowired
    protected MockMvc mvc;

    @Test
    void deveCriarOk() throws IOException {

        Products entity = criarParametro();

        when(repository.save(entity)).thenReturn(entity);

        Products dtos = service.create(criarParametroDto());

        assertEquals(dtos.getProduct_id(), 123L);
    }

    private Products criarParametro(){
        return Products.builder()
                .product_id(123L)
                .value(BigDecimal.TEN).build();
    }

    private ProductsDto criarParametroDto(){
        return new ProductsDto(123L, BigDecimal.TEN);
    }


    public static byte[] convertObjectToJsonBytes(Object object) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsBytes(object);
    }


}

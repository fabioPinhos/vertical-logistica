package br.com.luizalabs.verticallogistica.service;

import br.com.luizalabs.verticallogistica.application.service.impl.OrdersServiceImpl;
import br.com.luizalabs.verticallogistica.application.service.impl.UserServiceImpl;
import br.com.luizalabs.verticallogistica.core.domain.dto.OrderDto;
import br.com.luizalabs.verticallogistica.core.domain.dto.UserDto;
import br.com.luizalabs.verticallogistica.core.domain.entity.Orders;
import br.com.luizalabs.verticallogistica.core.domain.entity.Products;
import br.com.luizalabs.verticallogistica.core.domain.entity.User;
import br.com.luizalabs.verticallogistica.infra.repositories.repositories.OrdersRepository;
import br.com.luizalabs.verticallogistica.infra.repositories.repositories.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.postgresql.core.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class OrdersServiceTest {

    @Autowired
    private OrdersServiceImpl service;

    @MockBean
    private OrdersRepository repository;

    @Autowired
    protected MockMvc mvc;

    @Mock
    private Pageable pageableMock;

    @Test
    void testBuscarUserById() {
        when(repository.findById(criarParametro().getOrder_id())).thenReturn(Optional.of(criarParametro()));

        Orders userById = service.findById(criarParametro().getOrder_id());

        assertEquals(userById.getOrder_id(), criarParametro().getOrder_id());
    }

    @Test
    void deveCriarOk() throws IOException {

        Orders orders = criarParametro();

        when(repository.save(orders)).thenReturn(orders);

        Orders dtos = service.create(criarParametroDto(), null, null);

        assertEquals(dtos.getOrder_id(), 123L);
    }

    private Orders criarParametro(){
        return Orders.builder()
                .order_id(123L)
                .products(new Products())
                .build();
    }

    private OrderDto criarParametroDto(){
        return new OrderDto(123L, BigDecimal.ZERO, new Date(), Lists.list());
    }


    public static byte[] convertObjectToJsonBytes(Object object) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsBytes(object);
    }


}

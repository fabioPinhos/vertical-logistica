package br.com.luizalabs.verticallogistica.controller;

import br.com.luizalabs.verticallogistica.application.service.impl.OrdersServiceImpl;
import br.com.luizalabs.verticallogistica.core.domain.entity.Orders;
import br.com.luizalabs.verticallogistica.core.domain.entity.Products;
import br.com.luizalabs.verticallogistica.core.domain.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {
    @Autowired
    protected MockMvc mvc;

    @MockBean
    private OrdersServiceImpl service;

    @Test
    void testBuscarOrder() throws Exception {
        when(service.findById(any())).thenReturn(any());

        mvc.perform(get("/v1/api/orders/55")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonBytes(criarParametro()))
        ).andExpect(status().isOk());
    }

    @Test
    void testFindAll() throws Exception {
        when(service.findAll()).thenReturn(Lists.list(criarParametro()));

        mvc.perform(get("/v1/api/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonBytes(Lists.list(criarParametro())))
        ).andExpect(status().isOk());
    }

    @Test
    void testBuscarOrder_Filter() throws Exception {

        when(service.getFilteredEvents(anyInt(), anyInt(), any(Date.class), any(Date.class))).thenReturn(Lists.list(criarParametro()));

        mvc.perform(get("/v1/api/orders/filter")
                        .param("page", "0")
                        .param("size", "1")
                        .param("startDate", "2023-01-01")
                        .param("endDate", "2023-01-31"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].order_id").value(1L));
    }

    private Orders criarParametro(){
        return Orders.builder()
                .order_id(1L)
                .build();
    }


    public static byte[] convertObjectToJsonBytes(Object object) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsBytes(object);
    }
}

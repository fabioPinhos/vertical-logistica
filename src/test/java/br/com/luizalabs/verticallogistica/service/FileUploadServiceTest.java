package br.com.luizalabs.verticallogistica.service;

import br.com.luizalabs.verticallogistica.application.service.impl.FileUploadServiceImpl;
import br.com.luizalabs.verticallogistica.application.service.impl.OrdersServiceImpl;
import br.com.luizalabs.verticallogistica.application.service.impl.ProductsServiceImpl;
import br.com.luizalabs.verticallogistica.application.service.impl.UserServiceImpl;
import br.com.luizalabs.verticallogistica.core.domain.dto.UserDto;
import br.com.luizalabs.verticallogistica.core.domain.entity.Orders;
import br.com.luizalabs.verticallogistica.core.domain.entity.Products;
import br.com.luizalabs.verticallogistica.core.domain.entity.User;
import br.com.luizalabs.verticallogistica.infra.repositories.repositories.OrdersRepository;
import br.com.luizalabs.verticallogistica.infra.repositories.repositories.ProductsRepository;
import br.com.luizalabs.verticallogistica.infra.repositories.repositories.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class FileUploadServiceTest {

    @Autowired
    private FileUploadServiceImpl fileUploadService;

    @MockBean
    private ProductsServiceImpl productsService;

    @MockBean
    private UserServiceImpl userService;

    @MockBean
    private OrdersServiceImpl ordersService;

    @MockBean
    private ProductsRepository productsRepository;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private OrdersRepository ordersRepository;

    @Test
    void deveCriarOk() throws IOException {

        StringBuilder content = getStringBuilder();

        MultipartFile file = new MockMultipartFile("file", "test.txt", "text/plain", content.toString().getBytes());

        User users = criarUser();
        Orders orders = criarOrders();
        Products products = criarProducts();

        when(userRepository.save(users)).thenReturn(users);
        when(ordersRepository.save(orders)).thenReturn(orders);
        when(productsRepository.save(products)).thenReturn(products);

        List<UserDto> dtos = fileUploadService.readFile(file);

        assertEquals(users.getUser_id(), 123L);
        assertEquals(users.getName(), "Fabio");
    }

    private static StringBuilder getStringBuilder() {
        StringBuilder content = new StringBuilder();

        content.append("0000000088                             Terra Daniel DDS00000008360000000003     1899.0220210909\n");
        content.append("0000000103                                 Gail Bradtke00000009660000000005     1564.2120210507\n");
        content.append("0000000083                          Frances Satterfield00000007910000000006      224.7520211122\n");
        content.append("0000000141                                  Lloyd Mante00000013040000000001     1760.0120211012\n");
        content.append("0000000177                            Dr. Patrina Frami00000016320000000002     1045.1320210310");
        return content;
    }

    private User criarUser(){
        return User.builder()
                .user_id(123L)
                .name("Fabio").build();
    }

    private Orders criarOrders(){
        return Orders.builder()
                .order_id(1L)
                .build();
    }

    private Products criarProducts(){
        return Products.builder()
                .product_id(123L)
                .value(BigDecimal.ONE)
                .build();
    }


    public static byte[] convertObjectToJsonBytes(Object object) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsBytes(object);
    }


}

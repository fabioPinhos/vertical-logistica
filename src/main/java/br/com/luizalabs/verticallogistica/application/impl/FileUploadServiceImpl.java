package br.com.luizalabs.verticallogistica.application.impl;

import br.com.luizalabs.verticallogistica.application.IFileUploadService;
import br.com.luizalabs.verticallogistica.core.domain.dto.OrderDto;
import br.com.luizalabs.verticallogistica.core.domain.dto.ProductsDto;
import br.com.luizalabs.verticallogistica.core.domain.dto.UserDto;
import br.com.luizalabs.verticallogistica.core.exception.ArquivoInvalidoException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;

@Service
public class FileUploadServiceImpl implements IFileUploadService {


    @Override
    public void readFile(MultipartFile file) throws IOException {

        BufferedReader reader = null;
        String line;
        Map<Integer, UserDto> userMap = new HashMap<>();
        Map<Integer, OrderDto> orderMap = new HashMap<>();
        Map<Integer, ProductsDto> productsMap = new HashMap<>();
        OrderDto orderDto = null;

        try {
            reader = new BufferedReader(new InputStreamReader(file.getInputStream()));

            while ((line = reader.readLine()) != null) {
                String userId = Objects.requireNonNull(formatarNumero(line.substring(0,10).trim()));
                String userName = line.substring(10,55).trim();
                String orderId = Objects.requireNonNull(formatarNumero(line.substring(55,65).trim()));
                String prodId = Objects.requireNonNull(formatarNumero(line.substring(65,75).trim()));
                BigDecimal value = new BigDecimal(line.substring(75,87).trim());
                String data = line.substring(87,95).trim();

                System.out.println(userId);

                UserDto userDto = userMap.computeIfAbsent(Integer.parseInt(userId), id -> {
                    return new UserDto(id, userName, new ArrayList<OrderDto>());
                });

                OrderDto orderDto1 = orderMap.computeIfAbsent(Integer.parseInt(orderId), id -> {
                    OrderDto dto = new OrderDto(id, value, new Date(), new ArrayList<ProductsDto>());
                    userDto.orders().add(dto);
                    return dto;
                });

                ProductsDto productsDto1 = productsMap.computeIfAbsent(Integer.parseInt(prodId), id -> {
                    return new ProductsDto(id, value);
                });

                orderDto1.products().add(productsDto1);
            }
            System.out.println(userMap);

        }catch(IOException e){
            throw new ArquivoInvalidoException();
        }catch(Exception e){
            throw new ArquivoInvalidoException();
        }finally {
            try {
                if(reader != null){
                    reader.close();
                }
            }catch(IOException e){
                throw new ArquivoInvalidoException();
            }
        }

    }

    private static String formatarNumero(String userId) {
        return ("0000000000" + userId).substring(userId.length());
    }
}

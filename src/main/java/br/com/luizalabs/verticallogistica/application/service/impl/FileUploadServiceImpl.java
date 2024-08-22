package br.com.luizalabs.verticallogistica.application.service.impl;

import br.com.luizalabs.verticallogistica.application.service.IFileUploadService;
import br.com.luizalabs.verticallogistica.application.service.IOrdersService;
import br.com.luizalabs.verticallogistica.application.service.IProductsService;
import br.com.luizalabs.verticallogistica.application.service.IUserService;
import br.com.luizalabs.verticallogistica.core.domain.dto.UserDto;
import br.com.luizalabs.verticallogistica.core.exception.ArquivoVazioException;
import br.com.luizalabs.verticallogistica.infra.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileUploadServiceImpl implements IFileUploadService {

    private final IProductsService IProductsService;
    private final IUserService userService;
    private final IOrdersService ordersService;

    public FileUploadServiceImpl(IProductsService IProductsService, IUserService userService, IOrdersService ordersService) {
        this.IProductsService = IProductsService;
        this.userService = userService;
        this.ordersService = ordersService;
    }

    @Override
    public List<UserDto> readFile(MultipartFile file) throws IOException {

        if (file.isEmpty()) {
            throw new ArquivoVazioException();
        }

        List<UserDto> userDtos = FileUtil.readFile(file);

        userDtos.forEach(userDto -> {
            userDto.orders().forEach(orderDto -> {
                orderDto.products().forEach(productsDto -> {
                    ordersService.create(orderDto, userService.create(userDto), IProductsService.create(productsDto));

                });
            });
        });

        return userDtos;

    }
}

package br.com.luizalabs.verticallogistica.application.service.impl;

import br.com.luizalabs.verticallogistica.application.service.IProductsService;
import br.com.luizalabs.verticallogistica.core.domain.dto.ProductsDto;
import br.com.luizalabs.verticallogistica.core.domain.entity.Products;
import br.com.luizalabs.verticallogistica.infra.repositories.repositories.ProductsRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductsServiceImpl implements IProductsService {

    private final ProductsRepository repository;

    public ProductsServiceImpl(ProductsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Products create(ProductsDto dto) {

        Products products = Products.builder()
                .product_id(dto.product_id())
                .value(dto.value())
                .build();

        repository.save(products);

        return products;
    }
}

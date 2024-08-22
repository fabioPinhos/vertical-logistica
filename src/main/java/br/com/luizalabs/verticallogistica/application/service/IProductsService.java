package br.com.luizalabs.verticallogistica.application.service;

import br.com.luizalabs.verticallogistica.core.domain.dto.ProductsDto;
import br.com.luizalabs.verticallogistica.core.domain.entity.Products;

public interface IProductsService {

    Products create(ProductsDto dto);
}

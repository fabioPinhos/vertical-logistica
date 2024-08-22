package br.com.luizalabs.verticallogistica.application.service;

import br.com.luizalabs.verticallogistica.core.domain.dto.OrderDto;
import br.com.luizalabs.verticallogistica.core.domain.entity.Orders;
import br.com.luizalabs.verticallogistica.core.domain.entity.Products;
import br.com.luizalabs.verticallogistica.core.domain.entity.User;

public interface IOrdersService {

    Orders create(OrderDto dto, User user, Products products);

}

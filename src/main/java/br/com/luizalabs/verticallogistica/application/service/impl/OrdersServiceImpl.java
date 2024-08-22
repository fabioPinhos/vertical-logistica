package br.com.luizalabs.verticallogistica.application.service.impl;

import br.com.luizalabs.verticallogistica.application.service.IOrdersService;
import br.com.luizalabs.verticallogistica.core.domain.dto.OrderDto;
import br.com.luizalabs.verticallogistica.core.domain.entity.Orders;
import br.com.luizalabs.verticallogistica.core.domain.entity.Products;
import br.com.luizalabs.verticallogistica.core.domain.entity.User;
import br.com.luizalabs.verticallogistica.infra.repositories.repositories.OrdersRepository;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements IOrdersService {

    private final OrdersRepository repository;

    public OrdersServiceImpl(OrdersRepository repository) {
        this.repository = repository;
    }

    @Override
    public Orders create(OrderDto dto, User user, Products products) {

        Orders order = Orders.builder()
                .date(dto.date())
                .order_id(dto.order_id())
                .total(dto.total())
                .users(user)
                .products(products)
                .build();

        repository.save(order);

        return order;
    }
}

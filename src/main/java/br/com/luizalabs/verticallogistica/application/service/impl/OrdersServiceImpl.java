package br.com.luizalabs.verticallogistica.application.service.impl;

import br.com.luizalabs.verticallogistica.application.service.IOrdersService;
import br.com.luizalabs.verticallogistica.core.domain.dto.OrderDto;
import br.com.luizalabs.verticallogistica.core.domain.entity.Orders;
import br.com.luizalabs.verticallogistica.core.domain.entity.Products;
import br.com.luizalabs.verticallogistica.core.domain.entity.User;
import br.com.luizalabs.verticallogistica.core.exception.OrderNotFoundException;
import br.com.luizalabs.verticallogistica.infra.repositories.repositories.OrdersRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    @Override
    public Orders findById(Long id) {
        return repository.findById(id).orElseThrow(OrderNotFoundException::new);
    }

    @Override
    public List<Orders> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Orders> getFilteredEvents(int page, int size, Date startDate, Date endDate) {

        startDate = (startDate != null) ? startDate : new Date();
        endDate = endDate != null ? endDate : new Date();

        Pageable pageable = PageRequest.of(page, size);

        Page<Orders> ordersPage = repository.findFilteredOrders(startDate, endDate, pageable);

        return ordersPage.map(orders -> Orders.builder()
                .users(orders.getUsers())
                .date(orders.getDate())
                .total(orders.getTotal())
                .products(orders.getProducts())
                .build()).stream().toList();
    }
}

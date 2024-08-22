package br.com.luizalabs.verticallogistica.application.service;

import br.com.luizalabs.verticallogistica.core.domain.dto.OrderDto;
import br.com.luizalabs.verticallogistica.core.domain.entity.Orders;
import br.com.luizalabs.verticallogistica.core.domain.entity.Products;
import br.com.luizalabs.verticallogistica.core.domain.entity.User;

import java.util.Date;
import java.util.List;

public interface IOrdersService {

    Orders create(OrderDto dto, User user, Products products);
    Orders findById(Long id);
    List<Orders> findAll();
    List<Orders> getFilteredEvents(int page, int size, Date startDate, Date endDate);

}

package br.com.luizalabs.verticallogistica.controller;

import br.com.luizalabs.verticallogistica.application.service.IOrdersService;
import br.com.luizalabs.verticallogistica.core.domain.entity.Orders;
import br.com.luizalabs.verticallogistica.core.domain.entity.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/api/orders")
public class OrderController {

    private final IOrdersService service;

    public OrderController(IOrdersService service) {
        this.service = service;
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Long orderId){
        return ResponseEntity.ok(service.findById(orderId));
    }

    @GetMapping
    public ResponseEntity<List<Orders>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Orders>> filterOrder(@RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "10") int size,
                                                    @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                                    @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date endDate){
        return ResponseEntity.ok(service.getFilteredEvents(page, size, startDate, endDate));
    }
}

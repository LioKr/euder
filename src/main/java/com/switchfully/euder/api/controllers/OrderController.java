package com.switchfully.euder.api.controllers;

import com.switchfully.euder.api.dtos.OrderDto;
import com.switchfully.euder.api.dtos.OrderDtoCreate;
import com.switchfully.euder.api.mappers.OrderMapper;
import com.switchfully.euder.domain.entities.order.Order;
import com.switchfully.euder.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderController(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    //TODO add User access restrictions, validate that user exists
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto createOrder(@RequestBody OrderDtoCreate orderDtoCreate) {
        LOGGER.info("Creating an Order");
        Order orderToInsert = orderMapper.toEntity(orderDtoCreate);
        LOGGER.info("Inserting a new Order with UUID " + orderToInsert.getId());
        return orderMapper.toDto(orderService.createOrder(orderToInsert));
    }
}

package com.switchfully.euder.service;

import com.switchfully.euder.domain.entities.order.Order;
import com.switchfully.euder.domain.repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);
    private final OrderRepository orderRepository;


    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {
        LOGGER.info("Inserting one Order");
        return orderRepository.createOrder(order);
    }
}

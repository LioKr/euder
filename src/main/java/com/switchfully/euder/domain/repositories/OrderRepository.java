package com.switchfully.euder.domain.repositories;

import com.switchfully.euder.domain.database.OrderDb;
import com.switchfully.euder.domain.entities.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderRepository {
    private final OrderDb orderDb;

    @Autowired
    public OrderRepository(OrderDb orderDb) {
        this.orderDb = orderDb;
    }

    public Order createOrder(Order order) {
        return orderDb.createOrder(order);
    }
}

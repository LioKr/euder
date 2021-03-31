package com.switchfully.euder.domain.database;

import com.switchfully.euder.domain.entities.order.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class OrderDb {

    private final Map<UUID, Order> orders = new HashMap<>();

    public Order createOrder(Order newOrder) {
        orders.put(newOrder.getId(), newOrder);
        return orders.get(newOrder.getId());
    }
}

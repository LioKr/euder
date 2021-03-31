package com.switchfully.euder.api.mappers;

import com.switchfully.euder.api.dtos.OrderDto;
import com.switchfully.euder.api.dtos.OrderDtoCreate;
import com.switchfully.euder.domain.entities.order.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderMapper.class);
    private final ItemGroupMapper itemGroupMapper;

    @Autowired
    public OrderMapper(ItemGroupMapper itemGroupMapper) {
        this.itemGroupMapper = itemGroupMapper;
    }

    public Order toEntity(OrderDtoCreate orderDtoCreate) {
        LOGGER.info("Returning Order entity based on OrderDtoCreate");
        if (orderDtoCreate == null)
            throw new IllegalArgumentException("Cannot create Order entity, null argument provided.");
        return new Order(
                itemGroupMapper.toEntity(orderDtoCreate.getItemGroupList()),
                orderDtoCreate.getOrderingCustomerId());
    }

    public OrderDto toDto(Order order) {
        LOGGER.info("Returning OrderDto based on Order entity");
        if (order == null) throw new IllegalArgumentException("Cannot create OrderDto , null argument provided.");
        return new OrderDto()
                .setId(order.getId())
                .setItemGroupList(order.getItemGroupList())
                .setOrderingCustomer(order.getOrderingCustomerId())
                .setPrice(order.getPrice())
                .setShippingDate(order.getShippingDate());
    }
}

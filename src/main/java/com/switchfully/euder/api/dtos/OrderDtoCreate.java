package com.switchfully.euder.api.dtos;

import java.util.List;
import java.util.UUID;

public class OrderDtoCreate {
    private List<ItemGroupDtoIdBased> itemGroupList;
    private UUID orderingCustomerId;

    public OrderDtoCreate setItemGroupList(List<ItemGroupDtoIdBased> itemGroupList) {
        this.itemGroupList = itemGroupList;
        return this;
    }

    public OrderDtoCreate setOrderingCustomer(UUID orderingCustomer) {
        this.orderingCustomerId = orderingCustomer;
        return this;
    }

    public List<ItemGroupDtoIdBased> getItemGroupList() {
        return itemGroupList;
    }

    public UUID getOrderingCustomer() {
        return orderingCustomerId;
    }
}

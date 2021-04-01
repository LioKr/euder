package com.switchfully.euder.api.dtos;

import com.switchfully.euder.api.dtos.itemGroup.ItemGroupDtoIdBased;

import java.util.List;
import java.util.UUID;

public class OrderDtoCreate {
    private List<ItemGroupDtoIdBased> itemGroupList;
    private UUID orderingCustomerId;

    public OrderDtoCreate setItemGroupList(List<ItemGroupDtoIdBased> itemGroupList) {
        this.itemGroupList = itemGroupList;
        return this;
    }

    public OrderDtoCreate setOrderingCustomerId(UUID orderingCustomerId) {
        this.orderingCustomerId = orderingCustomerId;
        return this;
    }

    public List<ItemGroupDtoIdBased> getItemGroupList() {
        return itemGroupList;
    }

    public UUID getOrderingCustomerId() {
        return orderingCustomerId;
    }
}

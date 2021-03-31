package com.switchfully.euder.api.dtos;

import com.switchfully.euder.domain.entities.order.ItemGroup;
import com.switchfully.euder.domain.entities.user.User;

import java.util.List;

public class OrderDtoCreate {
    private List<ItemGroup> itemGroupList;
    private User orderingCustomer;

    public OrderDtoCreate setItemGroupList(List<ItemGroup> itemGroupList) {
        this.itemGroupList = itemGroupList;
        return this;
    }

    public OrderDtoCreate setOrderingCustomer(User orderingCustomer) {
        this.orderingCustomer = orderingCustomer;
        return this;
    }

    public List<ItemGroup> getItemGroupList() {
        return itemGroupList;
    }

    public User getOrderingCustomer() {
        return orderingCustomer;
    }
}

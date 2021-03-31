package com.switchfully.euder.api.dtos;

import com.switchfully.euder.domain.entities.item.PriceInEuros;
import com.switchfully.euder.domain.entities.order.ItemGroup;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class OrderDto {
    private java.util.UUID id;
    private List<ItemGroup> itemGroupList;
    private UUID orderingCustomer;
    private PriceInEuros price;
    private LocalDate shippingDate;

    public OrderDto setId(java.util.UUID id) {
        this.id = id;
        return this;
    }

    public OrderDto setItemGroupList(List<ItemGroup> itemGroupList) {
        this.itemGroupList = itemGroupList;
        return this;
    }

    public OrderDto setOrderingCustomer(UUID orderingCustomer) {
        this.orderingCustomer = orderingCustomer;
        return this;
    }

    public OrderDto setPrice(PriceInEuros price) {
        this.price = price;
        return this;
    }

    public OrderDto setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }

    public java.util.UUID getId() {
        return id;
    }

    public List<ItemGroup> getItemGroupList() {
        return itemGroupList;
    }

    public UUID getOrderingCustomer() {
        return orderingCustomer;
    }

    public PriceInEuros getPrice() {
        return price;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}

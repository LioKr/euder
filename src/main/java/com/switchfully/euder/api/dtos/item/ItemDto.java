package com.switchfully.euder.api.dtos.item;

import com.switchfully.euder.domain.entities.item.PriceInEuros;

import java.util.UUID;

public class ItemDto {
    private UUID id;
    private String name;
    private String description;
    private PriceInEuros priceInEuros;
    private int amountInStock;

    public ItemDto setId(UUID id) {
        this.id = id;
        return this;
    }

    public ItemDto setName(String name) {
        this.name = name;
        return this;
    }

    public ItemDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public ItemDto setPriceInEuros(PriceInEuros priceInEuros) {
        this.priceInEuros = priceInEuros;
        return this;
    }

    public ItemDto setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public PriceInEuros getPriceInEuros() {
        return priceInEuros;
    }

    public int getAmountInStock() {
        return amountInStock;
    }
}

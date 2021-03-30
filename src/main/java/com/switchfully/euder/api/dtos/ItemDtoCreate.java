package com.switchfully.euder.api.dtos;

import com.switchfully.euder.domain.entities.item.PriceInEuros;

public class ItemDtoCreate {

    private String name;
    private String description;
    private PriceInEuros priceInEuros;
    private int amountInStock;

    public ItemDtoCreate setName(String name) {
        this.name = name;
        return this;
    }

    public ItemDtoCreate setDescription(String description) {
        this.description = description;
        return this;
    }

    public ItemDtoCreate setPriceInEuros(PriceInEuros priceInEuros) {
        this.priceInEuros = priceInEuros;
        return this;
    }

    public ItemDtoCreate setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
        return this;
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

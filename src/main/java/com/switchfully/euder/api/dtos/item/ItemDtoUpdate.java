package com.switchfully.euder.api.dtos.item;

import com.switchfully.euder.domain.entities.item.PriceInEuros;

public class ItemDtoUpdate {
    private String name;
    private String description;
    private PriceInEuros priceInEuros;
    private int amountInStock;

    public ItemDtoUpdate setName(String name) {
        this.name = name;
        return this;
    }

    public ItemDtoUpdate setDescription(String description) {
        this.description = description;
        return this;
    }

    public ItemDtoUpdate setPriceInEuros(PriceInEuros priceInEuros) {
        this.priceInEuros = priceInEuros;
        return this;
    }

    public ItemDtoUpdate setAmountInStock(int amountInStock) {
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

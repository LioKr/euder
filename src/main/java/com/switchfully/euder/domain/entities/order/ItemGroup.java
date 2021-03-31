package com.switchfully.euder.domain.entities.order;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.euder.domain.entities.item.Item;
import com.switchfully.euder.domain.entities.item.PriceInEuros;
import com.switchfully.euder.infrastructure.utils.InputValidator;

import java.util.UUID;

public class ItemGroup {
    private final UUID id;
    private final Item item;
    private final int amountOrdered;

    @JsonCreator
    public ItemGroup(@JsonProperty("item") Item item, @JsonProperty("amountOrdered") int amountOrdered) {
        if (InputValidator.isNull(item) || amountOrdered <= 0) {
            throw new IllegalArgumentException("Cannot perform operation: create ItemGroup, illegal argument provided: " + item + " or " + amountOrdered);
        }
        this.id = UUID.randomUUID();
        this.item = item;
        this.amountOrdered = amountOrdered;
    }

    public boolean hasSufficientStock() {
        return item.getAmountInStock() >= amountOrdered;
    }

    public PriceInEuros calculatePrice() {
        return new PriceInEuros(item.getPriceInEuros().getPriceValue() * amountOrdered);
    }

    public UUID getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    public int getAmountOrdered() {
        return amountOrdered;
    }
}

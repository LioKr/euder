package com.switchfully.euder.domain.entities.item;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.euder.infrastructure.exceptions.InvalidItemPriceException;

public class PriceInEuros {
    private static final String CURRENCY = "Euros";
    private final double price;

    @JsonCreator
    public PriceInEuros(@JsonProperty("price") double price) {
        this.price = validPrice(price);
    }


    private double validPrice(double price) {
        if (price <= 0.0) {
            throw new InvalidItemPriceException("Cannot create Price for Item, illegal argument provided: " + price);
        }
        return price;
    }

    public static String getCURRENCY() {
        return CURRENCY;
    }

    public double getPrice() {
        return price;
    }
}

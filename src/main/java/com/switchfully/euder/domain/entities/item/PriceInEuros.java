package com.switchfully.euder.domain.entities.item;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PriceInEuros {
    private static final String CURRENCY = "Euros";
    private final double price;

    @JsonCreator
    public PriceInEuros(@JsonProperty("price") double price) {
        this.price = price;
    }

    public static String getCURRENCY() {
        return CURRENCY;
    }

    public double getPrice() {
        return price;
    }
}

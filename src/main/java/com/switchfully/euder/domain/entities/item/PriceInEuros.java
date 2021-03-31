package com.switchfully.euder.domain.entities.item;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public final class PriceInEuros {
    private static final String CURRENCY = "Euros";
    private final double priceValue;

    @JsonCreator
    public PriceInEuros(@JsonProperty("priceValue") double priceValue) {
        this.priceValue = priceValue;
    }//Question when i put my validation here it's not going to the ExceptionHandlerController

    public static String getCURRENCY() {
        return CURRENCY;
    }

    public double getPriceValue() {
        return priceValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceInEuros that = (PriceInEuros) o;
        return Double.compare(that.priceValue, priceValue) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceValue);
    }
}

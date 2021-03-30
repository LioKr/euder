package com.switchfully.euder.domain.entities.item;

import com.switchfully.euder.infrastructure.exceptions.InvalidItemAmountInStockException;
import com.switchfully.euder.infrastructure.exceptions.InvalidItemDescriptionException;
import com.switchfully.euder.infrastructure.exceptions.InvalidItemNameException;

import java.util.UUID;

public class Item {
    private final UUID id;
    private final String name;
    private final String description;
    private PriceInEuros priceInEuros;
    private int amountInStock;

    public Item(String name, String description, PriceInEuros priceInEuros, int amountInStock) {
        if (!isNullInput(name, description, priceInEuros))
            throw new IllegalArgumentException("Cannot create Item, illegal argument provided.");
        this.id = UUID.randomUUID();
        this.name = validName(name);
        this.description = validDescription(description);
        this.priceInEuros = priceInEuros;
        this.amountInStock = validAmountInStock(amountInStock);
    }

    private boolean isNullInput(String name, String description, PriceInEuros priceInEuros) {
        return name != null
                && description != null
                && priceInEuros != null;
    }

    private String validName(String name) {
        if (name.isBlank() || name.isEmpty()) {
            throw new InvalidItemNameException("Cannot create Name for Item, illegal argument provided: " + name);
        }
        return name;
    }

    private String validDescription(String description) {
        if (description.isBlank() || description.isEmpty()) {
            throw new InvalidItemDescriptionException("Cannot create Description for Item, illegal argument provided: " + description);
        }
        return description;
    }

    private int validAmountInStock(int amountInStock) {
        if (amountInStock < 0) {
            throw new InvalidItemAmountInStockException("Cannot create AmountInStock for Item, illegal argument provided: " + amountInStock);
        }
        return amountInStock;
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

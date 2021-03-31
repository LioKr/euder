package com.switchfully.euder.api.dtos;

import java.util.UUID;

public class ItemGroupDtoIdBased {
    private UUID itemId;
    private int amountOrdered;

    public ItemGroupDtoIdBased setItem(UUID itemId) {
        this.itemId = itemId;
        return this;
    }

    public ItemGroupDtoIdBased setAmountOrdered(int amountOrdered) {
        this.amountOrdered = amountOrdered;
        return this;
    }

    public UUID getItemId() {
        return itemId;
    }

    public int getAmountOrdered() {
        return amountOrdered;
    }
}

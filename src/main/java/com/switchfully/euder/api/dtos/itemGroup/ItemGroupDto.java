package com.switchfully.euder.api.dtos.itemGroup;

import com.switchfully.euder.domain.entities.item.Item;

public class ItemGroupDto {
    private Item item;
    private int amountOrdered;

    public ItemGroupDto setItem(Item item) {
        this.item = item;
        return this;
    }

    public ItemGroupDto setAmountOrdered(int amountOrdered) {
        this.amountOrdered = amountOrdered;
        return this;
    }

    public Item getItem() {
        return item;
    }

    public int getAmountOrdered() {
        return amountOrdered;
    }
}

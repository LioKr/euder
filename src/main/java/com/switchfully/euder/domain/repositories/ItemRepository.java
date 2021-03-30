package com.switchfully.euder.domain.repositories;

import com.switchfully.euder.domain.database.ItemDb;
import com.switchfully.euder.domain.entities.item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemRepository {
    private final ItemDb itemDb;

    @Autowired
    public ItemRepository(ItemDb itemDb) {
        this.itemDb = itemDb;
    }

    public Item createItem(Item item) {
        return itemDb.createItem(item);
    }
}

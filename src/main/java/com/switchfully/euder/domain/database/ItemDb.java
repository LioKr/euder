package com.switchfully.euder.domain.database;

import com.switchfully.euder.domain.entities.item.Item;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class ItemDb {
    private final Map<UUID, Item> items = new HashMap<>();

    public Item createItem(Item newItem) {
        items.put(newItem.getId(), newItem);
        return items.get(newItem.getId());
    }

    public Item getOneById(UUID itemId) {
        if (!items.containsKey(itemId))
            throw new IllegalArgumentException("Cannot perform operation: getOneById, cannot find Item with matching Id.");
        return items.get(itemId);
    }
}

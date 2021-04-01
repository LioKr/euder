package com.switchfully.euder.service;

import com.switchfully.euder.api.dtos.item.ItemDto;
import com.switchfully.euder.domain.entities.item.Item;
import com.switchfully.euder.domain.repositories.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ItemService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemService.class);
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item createItem(Item item) {
        LOGGER.info("Inserting one Item");
        return itemRepository.createItem(item);
    }

    public Item getOneById(UUID itemId) {
        LOGGER.info("Getting one Item based on Id: " + itemId);
        return itemRepository.getOneById(itemId);
    }

    public ItemDto updateMovie(Item itemToUpdate, String itemId) {
        LOGGER.info("Updating an Item with Id: " + itemId);
        throw new UnsupportedOperationException();
    }
}

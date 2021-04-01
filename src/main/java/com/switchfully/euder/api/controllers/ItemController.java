package com.switchfully.euder.api.controllers;

import com.switchfully.euder.api.dtos.item.ItemDto;
import com.switchfully.euder.api.dtos.item.ItemDtoCreate;
import com.switchfully.euder.api.dtos.item.ItemDtoUpdate;
import com.switchfully.euder.api.mappers.ItemMapper;
import com.switchfully.euder.domain.entities.item.Item;
import com.switchfully.euder.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);
    private final ItemService itemService;
    private final ItemMapper itemMapper;

    @Autowired
    public ItemController(ItemService itemService, ItemMapper itemMapper) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
    }

    //TODO add Admin access restriction
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDtoCreate createItem(@RequestBody ItemDtoCreate itemDtoCreate) {
        LOGGER.info("Creating an Item");
        Item itemToInsert = itemMapper.toEntity(itemDtoCreate);
        LOGGER.info("Inserting a new Item with UUID " + itemToInsert.getId());
        return itemMapper.toDto(itemService.createItem(itemToInsert));
    }

    @PutMapping(path = ("/{id}"), consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ItemDto updateItem(@RequestBody ItemDtoUpdate itemDtoUpdate, @PathVariable("id") String id) {
        Item itemToUpdate = itemMapper.toEntity(itemDtoUpdate);
        LOGGER.info("Updating an Item with id: " + id);
        return itemService.updateMovie(itemToUpdate, id);
    }
}

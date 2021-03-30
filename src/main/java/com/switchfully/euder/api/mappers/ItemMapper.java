package com.switchfully.euder.api.mappers;

import com.switchfully.euder.api.dtos.ItemDtoCreate;
import com.switchfully.euder.domain.entities.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemMapper.class);

    public Item toEntity(ItemDtoCreate itemDtoCreate) {
        LOGGER.info("Returning Item entity based on ItemDtoCreate");
        if (itemDtoCreate == null)
            throw new IllegalArgumentException("Cannot create Item entity, null argument provided.");
        return new Item(itemDtoCreate.getName(),
                itemDtoCreate.getDescription(),
                itemDtoCreate.getPriceInEuros(),
                itemDtoCreate.getAmountInStock());
    }

    public ItemDtoCreate toDto(Item item) {
        LOGGER.info("Returning ItemDtoCreate based on Item entity");
        if (item == null) throw new IllegalArgumentException("Cannot create Item entity, null argument provided.");
        return new ItemDtoCreate()
                .setName(item.getName())
                .setDescription(item.getDescription())
                .setPriceInEuros(item.getPriceInEuros())
                .setAmountInStock(item.getAmountInStock());
    }
}

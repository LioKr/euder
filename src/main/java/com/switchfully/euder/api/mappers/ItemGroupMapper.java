package com.switchfully.euder.api.mappers;

import com.switchfully.euder.api.dtos.itemGroup.ItemGroupDto;
import com.switchfully.euder.api.dtos.itemGroup.ItemGroupDtoIdBased;
import com.switchfully.euder.domain.entities.order.ItemGroup;
import com.switchfully.euder.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemGroupMapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemGroupMapper.class);
    private final ItemService itemService;

    @Autowired
    public ItemGroupMapper(ItemService itemService) {
        this.itemService = itemService;
    }

    public ItemGroup toEntity(ItemGroupDtoIdBased itemGroupDtoIdBased) {
        LOGGER.info("Returning ItemGroup entity based on ItemGroupDtoIdBased");
        if (itemGroupDtoIdBased == null)
            throw new IllegalArgumentException("Cannot create ItemGroup entity, null argument provided.");
        return new ItemGroup(
                itemService.getOneById(itemGroupDtoIdBased.getItemId()),
                itemGroupDtoIdBased.getAmountOrdered());
    }

    public List<ItemGroup> toEntity(List<ItemGroupDtoIdBased> itemGroupList) {
        return itemGroupList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public ItemGroupDto toDto(ItemGroup itemGroup) {
        LOGGER.info("Returning ItemGroupDto based on ItemGroup entity");
        if (itemGroup == null)
            throw new IllegalArgumentException("Cannot create ItemGroupDto , null argument provided.");
        return new ItemGroupDto()
                .setItem(itemGroup.getItem())
                .setAmountOrdered(itemGroup.getAmountOrdered());
    }

}

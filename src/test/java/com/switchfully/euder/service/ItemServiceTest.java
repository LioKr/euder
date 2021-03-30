package com.switchfully.euder.service;

import com.switchfully.euder.domain.database.ItemDb;
import com.switchfully.euder.domain.entities.item.Item;
import com.switchfully.euder.domain.entities.item.PriceInEuros;
import com.switchfully.euder.domain.repositories.ItemRepository;
import com.switchfully.euder.infrastructure.exceptions.InvalidItemAmountInStockException;
import com.switchfully.euder.infrastructure.exceptions.InvalidItemDescriptionException;
import com.switchfully.euder.infrastructure.exceptions.InvalidItemNameException;
import com.switchfully.euder.infrastructure.exceptions.InvalidItemPriceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ItemServiceTest {
    private ItemService itemService;
    private PriceInEuros price1;
    private Item item1;
    private UUID id1;

    @BeforeEach
    void init() {
        this.itemService = new ItemService(new ItemRepository(new ItemDb()));
        this.price1 = new PriceInEuros(10.5);
        this.item1 = new Item("name1", "description1", price1, 1);
        this.id1 = item1.getId();
    }


    @Test
    void createItem_givenCorrectParameter_thenReturnNewItem() {
        Item actualResult = itemService.createItem(item1);
        assertThat(actualResult.getId() == id1);
    }

    @Test
    void createItem_givenNullParameter_thenThrowIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> itemService.createItem(new Item(null, "d", price1, 1)));
        assertTrue(exception.getMessage().contains("Cannot create Item"));
    }

    @Test
    void createItem_givenIncorrectNameParameter_thenThrowInvalidItemNameException() {
        InvalidItemNameException exception = assertThrows(InvalidItemNameException.class, () -> itemService.createItem(new Item("", "d", price1, 1)));
        assertTrue(exception.getMessage().contains("Cannot create Name for Item"));
    }

    @Test
    void createItem_givenIncorrectDescriptionParameter_thenThrowInvalidItemDescriptionException() {
        InvalidItemDescriptionException exception = assertThrows(InvalidItemDescriptionException.class, () -> itemService.createItem(new Item("name", " ", price1, 1)));
        assertTrue(exception.getMessage().contains("Cannot create Description for Item"));
    }

    @Test
    void createItem_givenIncorrectPriceParameter_thenThrowInvalidItemPriceException() {
        InvalidItemPriceException exception = assertThrows(InvalidItemPriceException.class, () -> itemService.createItem(new Item("a", "d", new PriceInEuros(0), 1)));
        assertTrue(exception.getMessage().contains("Cannot create Price for Item"));
    }

    @Test
    void createItem_givenIncorrectAmountInStockParameter_thenThrowInvalidItemAmountInStockException() {
        InvalidItemAmountInStockException exception = assertThrows(InvalidItemAmountInStockException.class, () -> itemService.createItem(new Item("a", "d", price1, -1)));
        assertTrue(exception.getMessage().contains("Cannot create AmountInStock for Item"));
    }
}
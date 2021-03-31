package com.switchfully.euder.service;

import com.switchfully.euder.domain.database.OrderDb;
import com.switchfully.euder.domain.entities.item.Item;
import com.switchfully.euder.domain.entities.item.PriceInEuros;
import com.switchfully.euder.domain.entities.order.ItemGroup;
import com.switchfully.euder.domain.entities.order.Order;
import com.switchfully.euder.domain.entities.user.*;
import com.switchfully.euder.domain.repositories.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderServiceTest {
    private OrderService orderService;
    private Item item1;
    private Item item2;
    private Item item3;
    private ItemGroup itemGroup1;
    private ItemGroup itemGroup2;
    private ItemGroup itemGroup3;
    private List<ItemGroup> itemGroupList;
    private User customer;
    private Order order1;


    @BeforeEach
    void init() {
        this.orderService = new OrderService(new OrderRepository(new OrderDb()));
        this.item1 = new Item("name1", "description1", new PriceInEuros(1), 1);
        this.item2 = new Item("name2", "description1", new PriceInEuros(2), 2);
        this.item3 = new Item("name3", "description1", new PriceInEuros(2), 3);
        this.itemGroup1 = new ItemGroup(item1, 1);
        this.itemGroup2 = new ItemGroup(item2, 1);
        this.itemGroup3 = new ItemGroup(item3, 5);
        this.itemGroupList = new ArrayList<>(List.of(itemGroup1, itemGroup2, itemGroup3));
        this.customer = new User("firstname1", "lastname1", new Email("mail@gmail.com"), new Address("a", "a", "a", "a"), new PhoneNumber("0032456000000"), Role.CUSTOMER);
        this.order1 = new Order(itemGroupList, customer);
    }

    @Test
    void createOrder_givenCorrectParameter_thenReturnNewOrder() {
        Order actualResult = orderService.createOrder(order1);
        assertThat(actualResult.getId() == order1.getId());
    }

    @Test
    void createOrder_givenCorrectParameter_thenReturnNewOrderWithCorrectPrice() {
        PriceInEuros actualResult = order1.getPrice();
        assertThat(actualResult.equals(new PriceInEuros(11.0)));
    }

    @Test
    void createOrder_givenCorrectParameterWithInsufficientStock_thenReturnNewOrderWithCorrectShippingDate() {
        LocalDate actualResult = order1.getShippingDate();
        assertThat(actualResult.equals(LocalDate.now().plusDays(Order.DAYS_TO_SHIP_WITHOUT_STOCK)));
    }

    @Test
    void createOrder_givenCorrectParameterWithSufficientStock_thenReturnNewOrderWithCorrectShippingDate() {
        LocalDate actualResult = new Order(List.of(itemGroup1, itemGroup2), customer).getShippingDate();
        assertThat(actualResult.equals(LocalDate.now().plusDays(Order.DAYS_TO_SHIP_WITH_STOCK)));
    }

    @Test
    void createOrder_givenNullItemGroupListParameter_thenThrowIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> orderService.createOrder(new Order(null, customer)));
        assertTrue(exception.getMessage().contains("Cannot perform operation: create Order"));
    }

    @Test
    void createOrder_givenNullCustomerParameter_thenThrowIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> orderService.createOrder(new Order(itemGroupList, null)));
        assertTrue(exception.getMessage().contains("Cannot perform operation: create Order"));
    }


}
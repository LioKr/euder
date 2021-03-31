package com.switchfully.euder.domain.entities.order;

import com.switchfully.euder.domain.entities.item.PriceInEuros;
import com.switchfully.euder.domain.entities.user.User;
import com.switchfully.euder.infrastructure.utils.InputValidator;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Order {
    public static final int DAYS_TO_SHIP_WITHOUT_STOCK = 7;
    public static final int DAYS_TO_SHIP_WITH_STOCK = 1;
    private final UUID id;
    private final List<ItemGroup> itemGroupList;
    private final User orderingCustomer;
    private final PriceInEuros price;
    private final LocalDate shippingDate;

    public Order(List<ItemGroup> itemGroupList, User orderingCustomer) {
        if (InputValidator.isNull(itemGroupList) || InputValidator.isNull(orderingCustomer)) {
            throw new IllegalArgumentException("Cannot perform operation: create Order, illegal argument provided: " + itemGroupList + " or " + orderingCustomer);
        }
        this.id = UUID.randomUUID();
        this.itemGroupList = itemGroupList;
        this.orderingCustomer = orderingCustomer;
        this.price = calculatePrice();
        this.shippingDate = calculateShippingDate(itemGroupList);
    }

    private PriceInEuros calculatePrice() {
        return new PriceInEuros(
                itemGroupList.stream()
                        .map(ItemGroup::calculatePrice)
                        .map(PriceInEuros::getPriceValue)
                        .reduce(0.0, Double::sum)
        );
    }

    private LocalDate calculateShippingDate(List<ItemGroup> itemGroupList) {
        Optional<ItemGroup> ItemGroupNotInStock = itemGroupList.stream()
                .filter(itemGroup -> !itemGroup.hasSufficientStock())
                .findAny();
        if (ItemGroupNotInStock.isPresent())
            return LocalDate.now().plusDays(DAYS_TO_SHIP_WITHOUT_STOCK);

        return LocalDate.now().plusDays(DAYS_TO_SHIP_WITH_STOCK);
    }

    public UUID getId() {
        return id;
    }

    public List<ItemGroup> getItemGroupList() {
        return itemGroupList;
    }

    public User getOrderingCustomer() {
        return orderingCustomer;
    }

    public PriceInEuros getPrice() {
        return price;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}

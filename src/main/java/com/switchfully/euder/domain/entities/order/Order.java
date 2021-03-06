package com.switchfully.euder.domain.entities.order;

import com.switchfully.euder.domain.entities.item.PriceInEuros;
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
    private final UUID orderingCustomerId;
    private final PriceInEuros price;
    private final LocalDate shippingDate;

    public Order(List<ItemGroup> itemGroupList, UUID orderingCustomerId) {
        if (InputValidator.isNull(itemGroupList) || InputValidator.isNull(orderingCustomerId)) {
            throw new IllegalArgumentException("Cannot perform operation: create Order, illegal argument provided: " + itemGroupList + " or " + orderingCustomerId);
        }
        this.id = UUID.randomUUID();
        this.itemGroupList = itemGroupList;
        this.orderingCustomerId = orderingCustomerId;
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

    public UUID getOrderingCustomerId() {
        return orderingCustomerId;
    }

    public PriceInEuros getPrice() {
        return price;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}

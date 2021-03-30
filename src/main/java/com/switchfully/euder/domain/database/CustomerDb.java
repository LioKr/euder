package com.switchfully.euder.domain.database;

import com.switchfully.euder.domain.entities.customer.Customer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class CustomerDb {
    private final Map<UUID, Customer> customers = new HashMap<>();

    public Customer createCustomer(Customer newCustomer) {
        customers.put(newCustomer.getId(), newCustomer);
        return customers.get(newCustomer.getId());
    }
}

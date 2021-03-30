package com.switchfully.euder.domain.repositories;

import com.switchfully.euder.domain.database.CustomerDb;
import com.switchfully.euder.domain.entities.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerRepository {
    private final CustomerDb customerDb;

    @Autowired
    public CustomerRepository(CustomerDb customerDb) {
        this.customerDb = customerDb;
    }

    public Customer createCustomer(Customer newCustomer) {
        return customerDb.createCustomer(newCustomer);
    }
}

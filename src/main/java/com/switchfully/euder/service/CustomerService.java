package com.switchfully.euder.service;

import com.switchfully.euder.domain.entities.customer.Customer;
import com.switchfully.euder.domain.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer newCustomer) {
        LOGGER.info("Inserting one customer");
        return customerRepository.createCustomer(newCustomer);
    }
}

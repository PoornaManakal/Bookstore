/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.service;

import com.bookstore.database.InMemoryDatabase;
import com.bookstore.exception.CustomerNotFoundException;
import com.bookstore.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomerService {
    private static AtomicInteger idCounter = new AtomicInteger(1);

    public Customer addCustomer(Customer customer) {
        int id = idCounter.getAndIncrement();
        customer.setId(id);
        InMemoryDatabase.customers.put(id, customer);
        return customer;
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(InMemoryDatabase.customers.values());
    }

    public Customer getCustomer(int id) {
        Customer customer = InMemoryDatabase.customers.get(id);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found.");
        }
        return customer;
    }

    public Customer updateCustomer(int id, Customer updatedCustomer) {
        Customer existing = getCustomer(id);
        updatedCustomer.setId(id);
        InMemoryDatabase.customers.put(id, updatedCustomer);
        return updatedCustomer;
    }

    public void deleteCustomer(int id) {
        if (InMemoryDatabase.customers.remove(id) == null) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found.");
        }
    }
}

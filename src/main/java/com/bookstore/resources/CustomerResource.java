/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.resources;

import com.bookstore.model.Customer;
import com.bookstore.service.CustomerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {
    private CustomerService customerService = new CustomerService();

    @POST
    public Customer addCustomer(Customer customer) {
        return customerService.addCustomer(customer);
    }

    @GET
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GET
    @Path("/{id}")
    public Customer getCustomer(@PathParam("id") int id) {
        return customerService.getCustomer(id);
    }

    @PUT
    @Path("/{id}")
    public Customer updateCustomer(@PathParam("id") int id, Customer customer) {
        return customerService.updateCustomer(id, customer);
    }

    @DELETE
    @Path("/{id}")
    public void deleteCustomer(@PathParam("id") int id) {
        customerService.deleteCustomer(id);
    }
}


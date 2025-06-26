/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.resources;

import com.bookstore.model.Order;
import com.bookstore.service.OrderService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/customers/{customerId}/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {
    private OrderService orderService = new OrderService();

    @POST
    public Order placeOrder(@PathParam("customerId") int customerId) {
        return orderService.placeOrder(customerId);
    }

    @GET
    public List<Order> getAllOrders(@PathParam("customerId") int customerId) {
        return orderService.getAllOrders(customerId);
    }

    @GET
    @Path("/{orderId}")
    public Order getOrder(@PathParam("customerId") int customerId, @PathParam("orderId") int orderId) {
        return orderService.getOrderById(customerId, orderId);
    }
}


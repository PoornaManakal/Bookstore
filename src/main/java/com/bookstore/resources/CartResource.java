/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.resources;

import com.bookstore.model.CartItem;
import com.bookstore.service.CartService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/customers/{customerId}/cart")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CartResource {
    private CartService cartService = new CartService();

    @POST
    @Path("/items")
    public void addToCart(@PathParam("customerId") int customerId, CartItem item) {
        cartService.addToCart(customerId, item);
    }

    @GET
    public List<CartItem> getCart(@PathParam("customerId") int customerId) {
        return cartService.getCart(customerId);
    }

    @PUT
    @Path("/items/{bookId}")
    public void updateCartItem(@PathParam("customerId") int customerId, @PathParam("bookId") int bookId, CartItem item) {
        cartService.updateCartItem(customerId, bookId, item);
    }

    @DELETE
    @Path("/items/{bookId}")
    public void removeCartItem(@PathParam("customerId") int customerId, @PathParam("bookId") int bookId) {
        cartService.removeCartItem(customerId, bookId);
    }
}


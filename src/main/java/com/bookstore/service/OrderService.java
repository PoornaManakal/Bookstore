/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.service;

import com.bookstore.database.InMemoryDatabase;
import com.bookstore.exception.CartNotFoundException;
import com.bookstore.model.Order;
import com.bookstore.model.OrderedItem;
import com.bookstore.model.CartItem;
import com.bookstore.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderService {
    private static AtomicInteger orderIdCounter = new AtomicInteger(1);

    public Order placeOrder(int customerId) {
        List<CartItem> cart = InMemoryDatabase.carts.get(customerId);
        if (cart == null || cart.isEmpty()) {
            throw new CartNotFoundException("Cart not found for customer ID: " + customerId);
        }

        List<OrderedItem> items = new ArrayList<>();
        double total = 0.0;

        for (CartItem cartItem : cart) {
            Book book = InMemoryDatabase.books.get(cartItem.getBookId());
            if (book != null) {
                OrderedItem orderedItem = new OrderedItem(book.getId(), cartItem.getQuantity());
                items.add(orderedItem);
                total += book.getPrice() * cartItem.getQuantity();
            }
        }

        Order order = new Order(orderIdCounter.getAndIncrement(), items, total);

        InMemoryDatabase.orders.computeIfAbsent(customerId, k -> new ArrayList<>()).add(order);
        InMemoryDatabase.carts.remove(customerId);

        return order;
    }

    public List<Order> getAllOrders(int customerId) {
        return InMemoryDatabase.orders.getOrDefault(customerId, new ArrayList<>());
    }

    public Order getOrderById(int customerId, int orderId) {
        List<Order> orders = InMemoryDatabase.orders.get(customerId);
        if (orders != null) {
            for (Order order : orders) {
                if (order.getId() == orderId) {
                    return order;
                }
            }
        }
        throw new CartNotFoundException("Order not found with ID: " + orderId);
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.service;

import com.bookstore.database.InMemoryDatabase;
import com.bookstore.exception.BookNotFoundException;
import com.bookstore.model.CartItem;
import com.bookstore.model.Book;

import java.util.ArrayList;
import java.util.List;

public class CartService {

    public List<CartItem> getCart(int customerId) {
        return InMemoryDatabase.carts.getOrDefault(customerId, new ArrayList<>());
    }

    public void addToCart(int customerId, CartItem item) {
        Book book = InMemoryDatabase.books.get(item.getBookId());
        if (book == null) {
            throw new BookNotFoundException("Book with ID " + item.getBookId() + " not found.");
        }
        List<CartItem> cart = getCart(customerId);
        cart.add(item);
        InMemoryDatabase.carts.put(customerId, cart);
    }

    public void updateCartItem(int customerId, int bookId, CartItem updatedItem) {
        List<CartItem> cart = getCart(customerId);
        for (CartItem item : cart) {
            if (item.getBookId() == bookId) {
                item.setQuantity(updatedItem.getQuantity());
                return;
            }
        }
    }

    public void removeCartItem(int customerId, int bookId) {
        List<CartItem> cart = getCart(customerId);
        cart.removeIf(item -> item.getBookId() == bookId);
    }
}


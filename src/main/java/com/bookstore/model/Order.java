/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.model;

import java.util.List;

public class Order {
    private int id;
    private List<OrderedItem> items;
    private double total;

    public Order() {}

    public Order(int id, List<OrderedItem> items, double total) {
        this.id = id;
        this.items = items;
        this.total = total;
    }

    // Getters and Setters
    public int getId() { 
        return id; 
    }
    public void setId(int id) { 
        this.id = id; 
    }
    public List<OrderedItem> getItems() { 
        return items; 
    }
    public void setItems(List<OrderedItem> items) { 
        this.items = items; 
    }
    public double getTotal() {
        return total; 
    }
    public void setTotal(double total) { 
        this.total = total; 
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.service;

import com.bookstore.database.InMemoryDatabase;
import com.bookstore.exception.AuthorNotFoundException;
import com.bookstore.model.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AuthorService {
    private static AtomicInteger idCounter = new AtomicInteger(1);

    public Author addAuthor(Author author) {
        int id = idCounter.getAndIncrement();
        author.setId(id);
        InMemoryDatabase.authors.put(id, author);
        return author;
    }

    public List<Author> getAllAuthors() {
        return new ArrayList<>(InMemoryDatabase.authors.values());
    }

    public Author getAuthor(int id) {
        Author author = InMemoryDatabase.authors.get(id);
        if (author == null) {
            throw new AuthorNotFoundException("Author with ID " + id + " not found.");
        }
        return author;
    }

    public Author updateAuthor(int id, Author updatedAuthor) {
        Author existing = getAuthor(id);
        updatedAuthor.setId(id);
        InMemoryDatabase.authors.put(id, updatedAuthor);
        return updatedAuthor;
    }

    public void deleteAuthor(int id) {
        if (InMemoryDatabase.authors.remove(id) == null) {
            throw new AuthorNotFoundException("Author with ID " + id + " not found.");
        }
    }
}


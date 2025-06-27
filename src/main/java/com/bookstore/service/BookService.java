/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.bookstore.service;

import com.bookstore.database.InMemoryDatabase;
import com.bookstore.exception.AuthorNotFoundException;
import com.bookstore.exception.BookNotFoundException;
import com.bookstore.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BookService {
    private static AtomicInteger idCounter = new AtomicInteger(1);

    public Book addBook(Book book) {
        if (!InMemoryDatabase.authors.containsKey(book.getAuthorId())) {
            throw new AuthorNotFoundException("Author with ID " + book.getAuthorId() + " not found.");
        }
        int id = idCounter.getAndIncrement();
        book.setId(id);
        InMemoryDatabase.books.put(id, book);
        return book;
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(InMemoryDatabase.books.values());
    }

    public Book getBook(int id) {
        Book book = InMemoryDatabase.books.get(id);
        if (book == null) {
            throw new BookNotFoundException("Book with ID " + id + " not found.");
        }
        return book;
    }

    public Book updateBook(int id, Book updatedBook) {
        Book existing = getBook(id);
        updatedBook.setId(id);
        InMemoryDatabase.books.put(id, updatedBook);
        return updatedBook;
    }

    public void deleteBook(int id) {
        if (InMemoryDatabase.books.remove(id) == null) {
            throw new BookNotFoundException("Book with ID " + id + " not found.");
        }
    }

    public List<Book> getBooksByAuthor(int authorId) {
        List<Book> books = new ArrayList<>();
        for (Book book : InMemoryDatabase.books.values()) {
            if (book.getAuthorId() == authorId) {
                books.add(book);
            }
        }
        return books;
    }
}

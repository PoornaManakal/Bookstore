/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.resources;

import com.bookstore.model.Author;
import com.bookstore.model.Book;
import com.bookstore.service.AuthorService;
import com.bookstore.service.BookService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {
    private AuthorService authorService = new AuthorService();
    private BookService bookService = new BookService();

    @POST
    public Author addAuthor(Author author) {
        return authorService.addAuthor(author);
    }

    @GET
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GET
    @Path("/{id}")
    public Author getAuthor(@PathParam("id") int id) {
        return authorService.getAuthor(id);
    }

    @PUT
    @Path("/{id}")
    public Author updateAuthor(@PathParam("id") int id, Author author) {
        return authorService.updateAuthor(id, author);
    }

    @DELETE
    @Path("/{id}")
    public void deleteAuthor(@PathParam("id") int id) {
        authorService.deleteAuthor(id);
    }

    @GET
    @Path("/{id}/books")
    public List<Book> getBooksByAuthor(@PathParam("id") int id) {
        return bookService.getBooksByAuthor(id);
    }
}


package com.api.keycloak.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.api.keycloak.model.Book;

@Repository
public class BookRepository {
    private static Map<String, Book> books = new ConcurrentHashMap<>();

    static {
        books.put("B01", new Book("B01", "Livro 1", "Nome 1"));
        books.put("B02", new Book("B02", "Livro 2", "Nome 2"));
        books.put("B03", new Book("B03", "Livro 3", "Nome 3"));
    }

    public List<Book> readAll() {
        List<Book> allBooks = new ArrayList<>(books.values());
        allBooks.sort(Comparator.comparing(Book::getId));
        return allBooks;
    }
}

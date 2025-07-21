/**
 * Iterator Design Pattern Example
 * This example demonstrates the Iterator Design Pattern
 * which provides a way to access elements of a collection
 * without exposing its underlying representation.
 * It defines an interface for iterating over a collection
 * and provides concrete implementations for a book collection.
 * 
 */

import java.util.*;
import java.lang.*;
import java.io.*;

interface Collection {
    Iterator createIterator();
}

interface Iterator {
    boolean hasNext();
    Object next();
}

class BookCollection implements Collection {
    private String[] books;

    public BookCollection(String[] books) {
        this.books = books;
    }

    @Override
    public Iterator createIterator() {
        return new BookIterator(books);
    }
}

class BookIterator implements Iterator {
    private String[] books;
    private int position;

    public BookIterator(String[] books) {
        this.books = books;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < books.length;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("No more elements to iterate.");
        }
        return books[position++];
    }
}

public class IteratorDP {
    public static void main(String[] args) {
        String[] books = {"Design Patterns", "Effective Java", "Clean Code"};
        BookCollection bookCollection = new BookCollection(books);
        Iterator bookIterator = bookCollection.createIterator();

        while (bookIterator.hasNext()) {
            System.out.println(bookIterator.next());
        }
    }
}

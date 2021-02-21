package designpattern.composite.pattern.challenge;

import java.util.List;
import java.util.Objects;

public class BookCollection implements Book {
    private final Status availability;
    private List<Book> bookList;

    BookCollection() {
        this.availability = Status.AVAILABLE;
    }

    BookCollection(List<Book> bookList) {
        this();
        this.bookList = bookList;
    }

    public void addBook(Book book) {
        this.bookList.add(book);
    }

    @Override
    public void checkout() { //Whole lot checkout
        Objects.requireNonNull(bookList);
        bookList.parallelStream().forEach(book -> book.checkout());
    }

    @Override
    public void returnBook() {
        Objects.requireNonNull(bookList);
        bookList.parallelStream().forEach(book -> book.returnBook());
    }

    @Override
    public String getName() {
        return "Book_Collection";
    }

    @Override
    public Status getAvailability() {
        return this.availability;
    }
}

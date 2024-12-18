package ee.ivkhkdev.jptv23libraryjpa.helpers;

import ee.ivkhkdev.jptv23libraryjpa.entity.Book;
import ee.ivkhkdev.jptv23libraryjpa.input.Input;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookHellperImpl implements BookHelper{

    private Input input;

    public BookHellperImpl(Input input) {
        this.input = input;
    }

    @Override
    public Optional<Book> create() {
        Book book = new Book();
        System.out.print("Название книги: ");
        book.setTitle(input.nextLine());
        System.out.print("Год издания книги: ");
        book.setPublishedYear(input.nextInt());
        return Optional.empty();
    }

    @Override
    public Optional<Book> update(Book book) {
        return Optional.empty();
    }

    @Override
    public boolean printList(List<Book> books, boolean enableAll) {
        return false;
    }
}

package ee.ivkhkdev.jptv23libraryjpa.service;

import ee.ivkhkdev.jptv23libraryjpa.entity.Author;
import ee.ivkhkdev.jptv23libraryjpa.entity.Book;
import ee.ivkhkdev.jptv23libraryjpa.helpers.AuthorHelper;
import ee.ivkhkdev.jptv23libraryjpa.helpers.BookHelper;
import ee.ivkhkdev.jptv23libraryjpa.repository.AuthorRepository;
import ee.ivkhkdev.jptv23libraryjpa.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;




@Service
public class BookServiceImpl implements BookService{
    private BookHelper bookHelper;
    private AuthorHelper authorHelper;
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public BookServiceImpl(BookHelper bookHelper,AuthorHelper authorHelper,AuthorRepository authorRepository,BookRepository bookRepository) {
        this.bookHelper = bookHelper;
        this.authorHelper = authorHelper;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean add() {
        try {
            Optional<Book> optionalBook = bookHelper.create();//без автора
            if(optionalBook.isEmpty()) return false;
            List<Long> listIdAuthorsBook = authorHelper.listIdAuhtorsBook(authorRepository.findAll(),true);
            Book book = optionalBook.get();
            for (int i = 0; i < listIdAuthorsBook.size(); i++) {
                Optional<Author> optionalAuthor = authorRepository.findById(listIdAuthorsBook.get(i));
                if(optionalAuthor.isPresent()){
                    Author author = optionalAuthor.get();
                    if(!author.isAvailable()) return false;
                    book.getAuthors().add(author);
                    author.getBooks().add(book);
                }
            }
            bookRepository.save(book);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean edit() {
        return false;
    }

    @Override
    public boolean print() {
        return false;
    }
}

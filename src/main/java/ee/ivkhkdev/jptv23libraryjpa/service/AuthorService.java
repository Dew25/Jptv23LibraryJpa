package ee.ivkhkdev.jptv23libraryjpa.service;

import ee.ivkhkdev.jptv23libraryjpa.enity.Author;
import ee.ivkhkdev.jptv23libraryjpa.helpers.AppHelper;
import ee.ivkhkdev.jptv23libraryjpa.helpers.AuthorHelper;
import ee.ivkhkdev.jptv23libraryjpa.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthorService implements AppService{
    private final AuthorHelper authorHelper;
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorHelper authorHelper, AuthorRepository authorRepository) {
        this.authorHelper = authorHelper;
        this.authorRepository = authorRepository;
    }

    @Override
    public boolean add() {
        Optional<Author> optionalAuthor = authorHelper.create();
        if(!optionalAuthor.isPresent()){
            return false;
        }
        authorRepository.save(optionalAuthor.get());
        return true;
    }

    @Override
    public boolean edit() {
        Optional<Author> optionalModifyAuthor = this.getAuthorForModify();
        if(optionalModifyAuthor.isEmpty()){
            return false;
        }
        Optional<Author> optionalModifiedAuthor = authorHelper.update(optionalModifyAuthor.get());
        authorRepository.save(optionalModifiedAuthor.get());
        return true;

    }
    private Optional<Author> getAuthorForModify(){
        Long authorId = authorHelper.getIdModifyAuthor(authorRepository.findAll());
        return authorRepository.findById(authorId);
    }

    @Override
    public boolean print() {
        return authorHelper.printList(authorRepository.findAll());
    }
}

package ee.ivkhkdev.jptv23libraryjpa.helpers;

import ee.ivkhkdev.jptv23libraryjpa.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorHelper extends AppHelper<Author>{
    Optional<Long> getIdModifyAuthor(List<Author> authors,boolean enabled);
    List<Long> listIdAuhtorsBook(List<Author> authors, boolean enabled);
}

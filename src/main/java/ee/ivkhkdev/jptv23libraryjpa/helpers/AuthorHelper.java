package ee.ivkhkdev.jptv23libraryjpa.helpers;

import ee.ivkhkdev.jptv23libraryjpa.entity.Author;

import java.util.List;

public interface AuthorHelper extends AppHelper<Author>{
    Long getIdModifyAuthor(List<Author> authors);
    List<Long> listIdAuhtorsBook(List<Author> authors);
}

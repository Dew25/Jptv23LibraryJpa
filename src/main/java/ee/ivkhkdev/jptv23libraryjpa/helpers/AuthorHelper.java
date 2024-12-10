package ee.ivkhkdev.jptv23libraryjpa.helpers;

import ee.ivkhkdev.jptv23libraryjpa.enity.Author;

import java.util.List;

public interface AuthorHelper extends AppHelper<Author>{
    Long getIdModifyAuthor(List<Author> authors);
}

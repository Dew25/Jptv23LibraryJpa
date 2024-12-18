package ee.ivkhkdev.jptv23libraryjpa.repository;

import ee.ivkhkdev.jptv23libraryjpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}

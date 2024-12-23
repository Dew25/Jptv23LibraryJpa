package ee.ivkhkdev.jptv23libraryjpa.repository;

import ee.ivkhkdev.jptv23libraryjpa.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}

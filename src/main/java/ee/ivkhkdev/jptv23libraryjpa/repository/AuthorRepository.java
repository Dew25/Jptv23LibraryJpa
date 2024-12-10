package ee.ivkhkdev.jptv23libraryjpa.repository;

import ee.ivkhkdev.jptv23libraryjpa.enity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}

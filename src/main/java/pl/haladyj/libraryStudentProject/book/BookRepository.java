package pl.haladyj.libraryStudentProject.book;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.haladyj.libraryStudentProject.author.Author;

import java.util.Optional;
import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbn);
    Optional<Book> findByAuthorAndTitle(Set<Author> author, String title);
}

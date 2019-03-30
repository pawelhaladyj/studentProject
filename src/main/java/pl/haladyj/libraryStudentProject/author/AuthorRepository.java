package pl.haladyj.libraryStudentProject.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByFirstNameAndMiddleNameAndLastName(String firstName, String middleName, String lastName);

}

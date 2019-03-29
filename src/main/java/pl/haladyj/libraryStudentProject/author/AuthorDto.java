package pl.haladyj.libraryStudentProject.author;

import lombok.Data;
import pl.haladyj.libraryStudentProject.book.Book;

import java.util.Set;

@Data
public class AuthorDto {

    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Set<Book> books;
}

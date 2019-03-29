package pl.haladyj.libraryStudentProject.book;

import pl.haladyj.libraryStudentProject.author.Author;

import java.util.Set;

public class BookDto {

    private Long id;
    private String title;
    private Set<Author> author;
    private String isbn;
}

package pl.haladyj.libraryStudentProject.book;

import lombok.Data;
import pl.haladyj.libraryStudentProject.author.Author;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    @NotEmpty
    private String title;

    @OneToMany(mappedBy = "book")
    private List<Author> author;

    @Column(name = "isbn")
    private String isbn;
}

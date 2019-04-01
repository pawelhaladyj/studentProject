package pl.haladyj.libraryStudentProject.book;

import lombok.Data;
import pl.haladyj.libraryStudentProject.author.Author;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> author;

    @Column(name = "isbn")
    private String isbn;

    @Embedded
    private BookAdons bookAdons;
}

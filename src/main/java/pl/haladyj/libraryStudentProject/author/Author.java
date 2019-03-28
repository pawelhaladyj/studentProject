package pl.haladyj.libraryStudentProject.author;

import lombok.Data;
import pl.haladyj.libraryStudentProject.book.Book;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Entity
@Table(name = "author")
public class Author {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    @NotEmpty
    private String firstName;

    @Column(name = "middleName")
    private String middleName;

    @Column(name = "lastName")
    @NotEmpty
    private String lastName;

    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> books;
}

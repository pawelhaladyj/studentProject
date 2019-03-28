package pl.haladyj.libraryStudentProject.author;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

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
}

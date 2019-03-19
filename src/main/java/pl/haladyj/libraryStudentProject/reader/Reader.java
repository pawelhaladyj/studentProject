package pl.haladyj.libraryStudentProject.reader;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
//@Data
@Table(name ="reader")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    @NotNull
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    private String lastName;

    @Column(name = "ssn")
    private Long ssn;

}


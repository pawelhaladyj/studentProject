package pl.haladyj.libraryStudentProject.reader;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

//@Entity
@Data
@Table(name ="reader")
public class Reader {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "id")
    private Long id;

    //@Column(name ="firstName")
    //@NotNull
    private String firstName;

    //@Column(name = "lastName")
    //@NotNull
    private String lastName;

    //@Column(name = "ssn")
    private Long ssn;

    private List<String> contact;
}

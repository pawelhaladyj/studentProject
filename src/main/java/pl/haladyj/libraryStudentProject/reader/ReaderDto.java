package pl.haladyj.libraryStudentProject.reader;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReaderDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Long ssn;

}

package pl.haladyj.libraryStudentProject.reader;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReaderDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Long ssn;

}

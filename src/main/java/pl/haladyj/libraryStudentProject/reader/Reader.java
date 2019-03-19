package pl.haladyj.libraryStudentProject.reader;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name ="reader")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

}

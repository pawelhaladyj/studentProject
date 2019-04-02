package pl.haladyj.libraryStudentProject.book;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Specimen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="book_id")
    private Book book;

    @Embedded
    private SpecimenAdons specimenAdons;

    private boolean isAvailable;
    private boolean isReserved;

}

package pl.haladyj.libraryStudentProject.book;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class BookAdons {
    private double weight;
    private double height;
    private double width;
    private double depth;
    private int publishYear;
    private String publishingHouse;
}

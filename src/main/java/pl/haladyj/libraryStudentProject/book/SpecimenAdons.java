package pl.haladyj.libraryStudentProject.book;

import lombok.Data;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Data
@Embeddable
public class SpecimenAdons {

    private BigDecimal value;

}

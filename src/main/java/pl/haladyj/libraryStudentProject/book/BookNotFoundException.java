package pl.haladyj.libraryStudentProject.book;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String format) {
        super(format);
    }
}

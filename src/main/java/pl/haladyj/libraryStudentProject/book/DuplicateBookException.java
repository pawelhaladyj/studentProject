package pl.haladyj.libraryStudentProject.book;

public class DuplicateBookException extends RuntimeException {
    DuplicateBookException (String message){
        super(message);
    }
}

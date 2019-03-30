package pl.haladyj.libraryStudentProject.author;

public class DuplicateAuthorException extends RuntimeException {
    public DuplicateAuthorException(String message) {
        super(message);
    }
}

package pl.haladyj.libraryStudentProject.book;

import org.springframework.stereotype.Component;
import pl.haladyj.libraryStudentProject.utils.Converter;

import static com.google.common.base.Preconditions.checkNotNull;

@Component
public class BookConverter implements Converter <Book, BookDto> {

    @Override
    public Book toEntity(BookDto bookDto) {
        checkNotNull(bookDto, "Expected not null DTO");
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setTitle(bookDto.getTitle());
        book.setIsbn(bookDto.getIsbn());
        book.setAuthor(bookDto.getAuthor());

        return book;
    }

    @Override
    public BookDto toDto(Book book) {
        checkNotNull(book, "Expected not null Entity");
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setIsbn(book.getIsbn());
        bookDto.setAuthor(book.getAuthor());

        return bookDto;
    }
}

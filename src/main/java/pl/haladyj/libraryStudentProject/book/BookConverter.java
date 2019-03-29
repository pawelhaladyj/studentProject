package pl.haladyj.libraryStudentProject.book;

import pl.haladyj.libraryStudentProject.utils.Converter;

public class BookConverter implements Converter <Book, BookDto> {

    @Override
    public Book toEntity(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setTitle(bookDto.getTitle());
        book.setIsbn(bookDto.getIsbn());
        book.setAuthor(bookDto.getAuthor());

        return book;
    }

    @Override
    public BookDto toDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setIsbn(book.getIsbn());
        bookDto.setAuthor(book.getAuthor());

        return bookDto;
    }
}

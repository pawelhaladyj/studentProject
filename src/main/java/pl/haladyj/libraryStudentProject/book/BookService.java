package pl.haladyj.libraryStudentProject.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.String.format;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookConverter bookConverter;

    @Autowired
    public BookService(BookRepository bookRepository, BookConverter bookConverter) {
        this.bookRepository = bookRepository;
        this.bookConverter = bookConverter;
    }

    public BookDto findById (Long id){

        return bookConverter.toDto(bookRepository.findById(id)
                .orElseThrow(()->new BookNotFoundException(format("book of id %d does not exist in database",id))));
    }

    public List<BookDto> findAll(){
        return bookRepository.findAll().stream().map(book -> bookConverter.toDto(book)).collect(Collectors.toList());
    }

    public BookDto createBook(BookDto bookDto){
        checkNotNull(bookDto, "Expected not empty BookDto");
        bookRepository.findByAuthorAndTitle(bookDto.getAuthor(),bookDto.getTitle())
                .ifPresent(book->{throw new DuplicateBookException("Book exists in database scope");});
        return bookConverter.toDto(bookRepository.save(bookConverter.toEntity(bookDto)));
    }

    public BookDto updateBook(BookDto bookDto){
        checkNotNull(bookDto, "Expected not empty BookDto");
        if(!bookRepository.existsById(bookDto.getId())){
            throw new BookNotFoundException(format("book of id %d does not exist",bookDto.getId()));
        }
        return bookConverter.toDto(bookRepository.save(bookConverter.toEntity(bookDto)));
    }

    public void deleteBook(BookDto bookDto){
        checkNotNull(bookDto, "Expected not empty BookDto");
        if(!bookRepository.existsById(bookDto.getId())){
            throw new BookNotFoundException(format("book of id %d does not exist",bookDto.getId()));
        }
        bookRepository.deleteById(bookDto.getId());
    }

}

package pl.haladyj.libraryStudentProject.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        return new BookDto();
    }

    public List<BookDto> findAll(){
        return new ArrayList<>();
    }

    public BookDto create(BookDto bookDto){
        bookRepository.findByIsbn(bookDto.getIsbn())
                .ifPresent(book->{throw new DuplicateBookException("Book exists in database scope");});
        return bookConverter.toDto(bookRepository.save(bookConverter.toEntity(bookDto)));
    }

    public BookDto update(BookDto bookDto){
        bookRepository.findByIsbn(bookDto.getIsbn())
                .ifPresent(book->{throw new DuplicateBookException("Book exists in database scope");});
        return bookConverter.toDto(bookRepository.save(bookConverter.toEntity(bookDto)));
    }

    public void delete(BookDto bookDto){
        bookRepository.deleteById(bookDto.getId());
    }


}

package pl.haladyj.libraryStudentProject.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        return new BookDto();
    }

    public List<BookDto> findAll(){
        return new ArrayList<>();
    }

    public BookDto create(BookDto bookDto){
        checkNotNull(bookDto, "Expected not empty BookDto");
        bookRepository.findByAuthorAndTitle(bookDto.getAuthor(),bookDto.getTitle())
                .ifPresent(book->{throw new DuplicateBookException("Book exists in database scope");});
        return bookConverter.toDto(bookRepository.save(bookConverter.toEntity(bookDto)));
    }

    public BookDto update(BookDto bookDto){
        checkNotNull(bookDto, "Expected not empty BookDto");
        if(!bookRepository.existsById(bookDto.getId())){
            throw new BookNotFoundException(format("book of id %d does not exist",bookDto.getId()));
        }
        return bookConverter.toDto(bookRepository.save(bookConverter.toEntity(bookDto)));
    }

    public void delete(BookDto bookDto){
        bookRepository.deleteById(bookDto.getId());
    }


}

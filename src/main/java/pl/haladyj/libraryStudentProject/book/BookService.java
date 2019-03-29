package pl.haladyj.libraryStudentProject.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findById (Long id){
        return new Book();
    }

    public List<Book> findAll(){
        return new ArrayList<>();
    }

    public Book create(Book book){
        return bookRepository.save(book);
    }

    public Book update(Book book){
        return bookRepository.save(book);
    }

    public void delete(Book book){
        bookRepository.delete(book);
    }


}

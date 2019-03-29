package pl.haladyj.libraryStudentProject.author;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorDto findById(Long id){
        return null;
    }

    public List<AuthorDto> findAll(){
        return new ArrayList<>();
    }

    public AuthorDto createAuthor(AuthorDto authorDto){
        return null;
    }

    public AuthorDto updateAuthor(AuthorDto authorDto){
        return null;
    }

    public void deleteAuthor (AuthorDto authorDto){

    }
}

package pl.haladyj.libraryStudentProject.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.String.format;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorConverter authorConverter;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, AuthorConverter authorConverter) {
        this.authorRepository = authorRepository;
        this.authorConverter = authorConverter;
    }

    public AuthorDto findById(Long id){
        return authorConverter.toDto(authorRepository.findById(id)
                .orElseThrow(()->new AuthorNotFoundException(format("Author of id %d does not exist in database scope",id))));
    }

    public List<AuthorDto> findAll(){
        return authorRepository.findAll().stream().map(author -> authorConverter.toDto(author)).collect(Collectors.toList());
    }

    public AuthorDto createAuthor(AuthorDto authorDto){
        checkNotNull(authorDto, "Expected not empty AuthorDto");
        authorRepository.findByFirstNameAndMiddleNameAndLastName(authorDto.getFirstName(),authorDto.getMiddleName(),authorDto.getLastName())
                .ifPresent(book -> {throw new DuplicateAuthorException("Author already exist in database scope");});
        return authorConverter.toDto(authorRepository.save(authorConverter.toEntity(authorDto)));
    }

    public AuthorDto updateAuthor(AuthorDto authorDto){
        checkNotNull(authorDto, "Expected not empty AuthorDto");
        return authorConverter.toDto(authorRepository
                .findByFirstNameAndMiddleNameAndLastName(authorDto.getFirstName(),authorDto.getMiddleName(),authorDto.getLastName())
                .orElseThrow(()->new AuthorNotFoundException(format("Author of id %d does not exist in database scope",authorDto.getId()))));
    }

    public void deleteAuthor (AuthorDto authorDto){
        checkNotNull(authorDto,"Expected not empty AuthorDto");
        if(!authorRepository.existsById(authorDto.getId())){
            throw new AuthorNotFoundException(format("author of id % does not exist in database scope", authorDto.getId()));
        }
        authorRepository.deleteById(authorDto.getId());

    }
}

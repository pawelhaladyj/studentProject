package pl.haladyj.libraryStudentProject.author;

import pl.haladyj.libraryStudentProject.utils.Converter;

public class AuthorConverter implements Converter<Author, AuthorDto> {

    @Override
    public Author toEntity(AuthorDto authorDto) {
        Author author = new Author();
        author.setId(authorDto.getId());
        author.setFirstName(authorDto.getFirstName());
        author.setMiddleName(authorDto.getMiddleName());
        author.setLastName(authorDto.getLastName());
        author.setBooks(authorDto.getBooks());
        return author;
    }

    @Override
    public AuthorDto toDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setFirstName(author.getFirstName());
        authorDto.setMiddleName(author.getMiddleName());
        authorDto.setLastName(author.getLastName());
        authorDto.setBooks(author.getBooks());
        return authorDto;
    }
}

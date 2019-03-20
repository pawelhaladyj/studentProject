package pl.haladyj.libraryStudentProject.reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;
import static pl.haladyj.libraryStudentProject.reader.ReaderConverter.toDto;
import static pl.haladyj.libraryStudentProject.reader.ReaderConverter.toEntity;

@Service
public class ReaderService {

    private final ReaderRepository readerRepository;

    @Autowired
    public ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    public Optional<ReaderDto> findReaderById(long readerId){
        return readerRepository.findById(readerId).map(ReaderConverter::toDto);
    }

    public List<ReaderDto> findAllReaders(){
        return readerRepository.findAll().stream().map(ReaderConverter::toDto).collect(Collectors.toList());
    }

    public ReaderDto createReader (ReaderDto readerDto){
        checkNotNull(readerDto, "Expected non-empty readerDto");
        readerRepository.findByFirstNameAndLastName(readerDto.getFirstName(),readerDto.getLastName())
                .ifPresent(reader -> {
                    throw new DuplicateReaderException("Reader already exists in a database scope");
                });
        return toDto(readerRepository.save(toEntity(readerDto)));
    }


}

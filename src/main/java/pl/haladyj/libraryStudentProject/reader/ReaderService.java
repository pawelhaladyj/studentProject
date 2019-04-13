package pl.haladyj.libraryStudentProject.reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.String.format;

@Service
public class ReaderService {

    private final ReaderRepository readerRepository;
    private final ReaderConverter readerConverter;

    @Autowired
    public ReaderService(ReaderRepository readerRepository, ReaderConverter readerConverter) {
        this.readerRepository = readerRepository;
        this.readerConverter = readerConverter;
    }

    public ReaderDto findReaderById(long readerId){
        return readerConverter.toDto(readerRepository.findById(readerId).orElseThrow(
                ()-> new ReaderNotFoundException(format("reader of id %d does not exist", readerId))
        ));
    }

    public List<ReaderDto> findAllReaders(){
        return readerRepository
                .findAll()
                .stream()
                .map(reader -> readerConverter
                        .toDto(reader))
                .collect(Collectors
                        .toList());
    }

    public ReaderDto createReader (ReaderDto readerDto){
        checkNotNull(readerDto, "Expected non-empty readerDto");
        readerRepository.findByFirstNameAndLastName(readerDto.getFirstName(),readerDto.getLastName())
                .ifPresent(reader -> {
                    throw new DuplicateReaderException("reader already exists in a database scope");
                });
        return readerConverter.toDto(readerRepository.save(readerConverter.toEntity(readerDto)));
    }

    //reader found and updated in frontend, id not editable
    public ReaderDto updateReader (ReaderDto readerDto){
        checkNotNull(readerDto,"Expected non-empty readerDto" );
        checkByIdIfReaderExists(readerDto.getId());
        return readerConverter.toDto(readerRepository.save(readerConverter.toEntity(readerDto)));
    }

    public void deleteReaderById (Long readerId){
        checkByIdIfReaderExists(readerId);
        readerRepository.deleteById(readerId);
    }

    private void checkByIdIfReaderExists(Long readerId) {
        if(!readerRepository.existsById(readerId)){
            throw new ReaderNotFoundException(format("reader of id %d does not exist", readerId));
        }
    }
}

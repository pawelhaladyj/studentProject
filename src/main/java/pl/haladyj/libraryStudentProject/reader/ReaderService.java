package pl.haladyj.libraryStudentProject.reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

}

package pl.haladyj.libraryStudentProject.reader;

import org.springframework.stereotype.Service;

@Service
public class ReaderService {

    private final ReaderRepository readerRepository;

    public ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }


}

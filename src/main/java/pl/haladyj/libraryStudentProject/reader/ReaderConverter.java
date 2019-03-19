package pl.haladyj.libraryStudentProject.reader;

public class ReaderConverter implements Converter<Reader, ReaderDto> {

    private ReaderConverter(){
        throw new UnsupportedOperationException();
    }


    @Override
    public Reader toEntity(ReaderDto readerDto) {
        return null;
    }

    @Override
    public ReaderDto toDto(Reader reader) {
        return null;
    }
}

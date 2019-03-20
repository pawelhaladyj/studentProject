package pl.haladyj.libraryStudentProject.reader;

import static com.google.common.base.Preconditions.checkNotNull;

public class ReaderConverter {

    private ReaderConverter(){
        throw new UnsupportedOperationException();
    }


    public static Reader toEntity(ReaderDto readerDto) {
        checkNotNull(readerDto,"Expected not null readerDto");
        Reader reader = new Reader();

        reader.setId(readerDto.getId());
        reader.setFirstName(readerDto.getFirstName());
        reader.setLastName(readerDto.getLastName());
        reader.setSsn(readerDto.getSsn());

        return reader;
    }


    public static ReaderDto toDto(Reader reader) {
        checkNotNull(reader,"Expected not null readerDto");
        ReaderDto readerDto = new ReaderDto();

        readerDto.setId(reader.getId());
        readerDto.setFirstName(reader.getFirstName());
        reader.setLastName(reader.getLastName());
        reader.setSsn(reader.getSsn());

        return readerDto;
    }
}

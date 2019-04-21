package pl.haladyj.libraryStudentProject.reader.reader;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import pl.haladyj.libraryStudentProject.reader.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.booleanThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ReaderServiceTest {

    static Reader[] testReader ={
            new Reader(1L, "Ian", "White", "12345678901","815253666"),
            new Reader(2L, "Zoe", "Brown", "12345678902","601253667"),
            new Reader(3L, "Ron", "Black", "12345678903","125253668"),
            new Reader(4L, "Nash", "Blue", "12345678904","025253669"),
    };

    static ReaderDto[] testReaderDto ={
            new ReaderDto(1L, "Ian", "White", "12345678901","815253666"),
            new ReaderDto(2L, "Zoe", "Brown", "12345678902","601253667"),
            new ReaderDto(3L, "Ron", "Black", "12345678903","125253668"),
            new ReaderDto(4L, "Nash", "Blue", "12345678904","025253669"),
    };


    @Rule public ExpectedException expectedException = ExpectedException.none();
    private ReaderService readerService;
    @MockBean private ReaderRepository readerRepository;
    private ReaderConverter readerConverter = new ReaderConverter() ;

    @Before
    public void setUp() throws Exception {
        readerService = new ReaderService(readerRepository, readerConverter);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findReaderById() {
        when(readerRepository.findById(testReaderDto[0].getId())).thenReturn(Optional.of(testReader[0]));

        ReaderDto readerDto = readerService.findReaderById(testReaderDto[0].getId());

        assertEquals(testReader[0].getId(),readerDto.getId());
        assertEquals(testReader[0].getSsn(),readerDto.getSsn());
        assertEquals(testReader[0].getLastName(),readerDto.getLastName());
        assertEquals(testReader[0].getFirstName(),readerDto.getFirstName());
        assertEquals(testReader[0].getPhoneNumber(),readerDto.getPhoneNumber());
    }

    @Test(expected = ReaderNotFoundException.class)
    public void doNotFindReaderByIdIfIdDoesNotExist() {
        when(readerRepository.findById(Long.MAX_VALUE)).thenReturn(Optional.of(testReader[0]));

        ReaderDto readerDto = readerService.findReaderById(testReaderDto[0].getId());

        assertEquals(testReader[0].getId(),readerDto.getId());
        assertEquals(testReader[0].getSsn(),readerDto.getSsn());
        assertEquals(testReader[0].getLastName(),readerDto.getLastName());
        assertEquals(testReader[0].getFirstName(),readerDto.getFirstName());
        assertEquals(testReader[0].getPhoneNumber(),readerDto.getPhoneNumber());
    }

    @Test
    public void findAllReaders() {
        Reader givenReader1 =testReader[0];
        Reader givenReader2 =testReader[1];
        ReaderDto expectedReaderDto1 =testReaderDto[0];
        ReaderDto expectedReaderDto2 =testReaderDto[1];

        List<Reader> expectedReaders = newArrayList(givenReader1,givenReader2);
        when(readerRepository.findAll()).thenReturn(expectedReaders);

        List<ReaderDto> actualReaderDtos = readerService.findAllReaders();

        assertThat(actualReaderDtos, hasSize(2));
        assertThat(actualReaderDtos, hasItems(expectedReaderDto1, expectedReaderDto2));
    }

    @Test
    public void checkByIdIfReaderExists(){
        Long notExistingReaderId = Long.MAX_VALUE;
        Reader givenReader = testReader[0];

        when(readerRepository.existsById(givenReader.getId())).thenReturn(true);

        assertTrue(readerRepository.existsById(givenReader.getId()));
        assertFalse(readerRepository.existsById(notExistingReaderId));
    }

/*    @Test(expected = DuplicateReaderException.class)
    public void createReaderThatAlreadyExists(){
        Reader givenReader = testReader[0];
        //ReaderDto duplicateGivenReader = readerConverter.toDto(givenReader);

        List<Reader> expextedReaders = newArrayList(givenReader);
        when(readerRepository.findAll()).thenReturn(expextedReaders);

        ReaderDto duplicateGivenReader = readerService.createReader(readerConverter.toDto(givenReader));
    }*/


/*    @Test
    public void createReader() {
        Reader reader = new Reader(null, "Ian", "White", "12345678901","815253666");
        Reader savedReader = testReader[0];
        ReaderDto readerDto = new ReaderDto(null, "Ian", "White", "12345678901","815253666");
        ReaderDto expectedReaderDto = testReaderDto[0];

        ReaderDto savedReaderDto = readerService.createReader(readerDto);

        assertEquals(savedReaderDto,expectedReaderDto);
    }*/

    @Test
    public void updateReader() {
    }

    @Test
    public void deleteReaderById() {
    }
}
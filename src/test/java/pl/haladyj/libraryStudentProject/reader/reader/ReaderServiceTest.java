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


import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ReaderServiceTest {

    static Reader[] testReader ={
            new Reader(1L, "Ian", "White", 1231L),
            new Reader(2L, "Zoe", "Brown", 1232L),
            new Reader(3L, "Ron", "Black", 1233L),
            new Reader(4L, "Nash", "Blue", 1234L),
    };

    static ReaderDto[] testReaderDto ={
            new ReaderDto(1L, "Ian", "White", 1231L),
            new ReaderDto(2L, "Zoe", "Brown", 1232L),
            new ReaderDto(3L, "Ron", "Black", 1233L),
            new ReaderDto(4L, "Nash", "Blue", 1234L),
    };


    @Rule public ExpectedException expectedException = ExpectedException.none();
    private ReaderService readerService;
    @MockBean private ReaderRepository readerRepository;
    private ReaderConverter readerConverter;

    @Before
    public void setUp() throws Exception {
        readerService = new ReaderService(readerRepository, readerConverter);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findReaderById() {
    }

    @Test
    public void findAllReaders() {
        Reader givenReader1 =testReader[0];
        Reader givenReader2 =testReader[1];
        ReaderDto expectedReaderDto1 =testReaderDto[0];
        ReaderDto expectedReaderDto2 =testReaderDto[1];

        List<Reader> expectedReaders = newArrayList(givenReader1,givenReader2);
        when(readerRepository.findAll()).thenReturn(expectedReaders);

        List<ReaderDto> actualReaderDtos =readerService.findAllReaders();

        assertThat(actualReaderDtos, hasSize(2));
        assertThat(actualReaderDtos, hasItems(expectedReaderDto1, expectedReaderDto2));
    }

    @Test
    public void createReader() {
    }

    @Test
    public void updateReader() {
    }

    @Test
    public void deleteReaderById() {
    }
}
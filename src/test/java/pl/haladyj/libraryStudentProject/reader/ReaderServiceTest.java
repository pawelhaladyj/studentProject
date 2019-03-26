package pl.haladyj.libraryStudentProject.reader;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ReaderServiceTest {

    static Reader[] testReader =
        new Reader[]{
                new Reader (1L,"firstName1","lastName1",1L),
                new Reader (2L,"firstName2","lastName2",2L),
                new Reader (3L,"firstName3","lastName3",3L),
                new Reader (4L,"firstName4","lastName4",4L),
        };

    static ReaderDto[] testReaderDto =
            new ReaderDto[]{
                    new ReaderDto (1L,"firstName1","lastName1",1L),
                    new ReaderDto (2L,"firstName2","lastName2",2L),
                    new ReaderDto (3L,"firstName3","lastName3",3L),
                    new ReaderDto (4L,"firstName4","lastName4",4L),
            };

    @Rule public ExpectedException expectedException = ExpectedException.none();
    private ReaderService readerService;
    @Mock private ReaderRepository readerRepository;
    @Mock private ReaderConverter readerConverter;

    @Before
    public void setUp() throws Exception {
        readerService = new ReaderService(readerRepository, readerConverter);
    }

    /*@After
    public void tearDown() throws Exception {
    }*/


/*    @Test
    public void findReaderById() {
        Reader givenReader1 = testReader[0];
        Reader givenReader2 = testReader[1];
        ReaderDto expectedReaderDto1 =testReaderDto[0];
        ReaderDto expectedReaderDto2 =testReaderDto[1];
        List<Reader> expectedReaders =newArrayList(givenReader1,givenReader2);
        when(readerRepository.findById(expectedReaderDto1.getId())).thenReturn(expectedReaderDto1);
        Long dummyId = Long.MAX_VALUE;

    }*/


    @Test
    public void findAllReaders() {
        //given
        Reader givenReader1 = testReader[0];
        Reader givenReader2 = testReader[1];
        ReaderDto expectedReaderDto1 = testReaderDto[0];
        ReaderDto expectedReaderDto2 = testReaderDto[1];

        List<Reader> expectedReaders = newArrayList(givenReader1,givenReader2);
        when(readerRepository.findAll()).thenReturn(expectedReaders);

        //when
        List<ReaderDto> actualClientsDtos = readerService.findAllReaders();

        //then
        assertThat(actualClientsDtos, hasSize(2));
        assertThat(actualClientsDtos, hasItems(expectedReaderDto1,expectedReaderDto2));

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
package pl.haladyj.libraryStudentProject.reader;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

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
        when(readerRepository.findById(testReaderDto[0].getId())).thenReturn(testReader[0]);

        Optional<ReaderDto> readerDto = readerService.findReaderById(testReaderDto[0].getId());

    }*/

    @Test
    public void findAllReaders() {
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
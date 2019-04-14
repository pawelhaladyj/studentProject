package pl.haladyj.libraryStudentProject.reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/readers")
public class ReaderController {

    private final ReaderService readerService;

    @Autowired
    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @GetMapping
    public List<ReaderDto> findAll(){
        return readerService.findAllReaders();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ReaderDto> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(readerService.findReaderById(id));
    }

    @PostMapping
    public ResponseEntity<ReaderDto> createReader (@RequestBody @Validated ReaderDto readerDto){
        readerDto = readerService.createReader(readerDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(readerDto.getId())
                .toUri();

        return ResponseEntity.created(location).body(readerDto);
    }

/*    @PutMapping("/update")
    public ResponseEntity updateReader(@RequestParam("map") String updatedReader){


    }*/

}

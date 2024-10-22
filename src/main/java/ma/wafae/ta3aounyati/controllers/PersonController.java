package ma.wafae.ta3aounyati.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.wafae.ta3aounyati.dto.requests.PersonRequest;
import ma.wafae.ta3aounyati.dto.responses.PersonResponse;
import ma.wafae.ta3aounyati.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/people")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping
    public ResponseEntity<List<PersonResponse>> getAll(){
        return ResponseEntity.ok(personService.getAll());
    }
    @PostMapping
    public ResponseEntity<PersonResponse> add(@Valid @RequestBody PersonRequest request){
        PersonResponse personResponse = personService.add(request);
        return new ResponseEntity<>(personResponse, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        personService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

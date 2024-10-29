package ma.wafae.ta3aounyati.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.wafae.ta3aounyati.dto.requests.JournalRequest;
import ma.wafae.ta3aounyati.dto.responses.JournalResponse;
import ma.wafae.ta3aounyati.services.JournalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/journals")
@RequiredArgsConstructor
public class JournalController {
    private final JournalService journalService;

    @GetMapping
    public ResponseEntity<List<JournalResponse>> getAll(@RequestHeader("UserId") Integer userId){
        return ResponseEntity.ok(journalService.getAllByUserId(userId));
    }
    @PostMapping
    public ResponseEntity<JournalResponse> add(@Valid @RequestBody JournalRequest request){
        JournalResponse journalResponse = journalService.add(request);
        return new ResponseEntity<>(journalResponse, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        journalService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

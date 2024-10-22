package ma.wafae.ta3aounyati.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.wafae.ta3aounyati.dto.requests.RoutineRequest;
import ma.wafae.ta3aounyati.dto.responses.RoutineResponse;
import ma.wafae.ta3aounyati.services.RoutineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/routine")
@RequiredArgsConstructor
public class RoutineController {
    private final RoutineService routineService;

    @GetMapping
    public ResponseEntity<List<RoutineResponse>> getAll(){
        System.out.println("routines = "+routineService.getAll());
        return ResponseEntity.ok(routineService.getAll());
    }
    @PostMapping
    public ResponseEntity<RoutineResponse> add(@Valid @RequestBody RoutineRequest request){
        RoutineResponse routineResponse = routineService.add(request);
        return new ResponseEntity<>(routineResponse, HttpStatus.OK);
    }
    @PatchMapping("/done/{id}")
    public ResponseEntity<RoutineResponse> setAsDone(@PathVariable Integer id){
        RoutineResponse routineResponse = routineService.setAsDone(id);
        return new ResponseEntity<>(routineResponse, HttpStatus.OK);
    }

    @PatchMapping("/undone/{id}")
    public ResponseEntity<RoutineResponse> setAsUndone(@PathVariable Integer id){
        RoutineResponse routineResponse = routineService.setAsUndone(id);
        return new ResponseEntity<>(routineResponse, HttpStatus.OK);
    }
    @PatchMapping("/change-time/{id}")
    public ResponseEntity<RoutineResponse> changeDate(@RequestBody Map<String, String> request, @PathVariable Integer id) {
        LocalTime time = LocalTime.parse(request.get("time")); // Parse date from the request body
        RoutineResponse routineResponse = routineService.updateTime(time, id);
        return new ResponseEntity<>(routineResponse, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        routineService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

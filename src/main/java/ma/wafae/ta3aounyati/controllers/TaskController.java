package ma.wafae.ta3aounyati.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.wafae.ta3aounyati.dto.requests.TaskRequest;
import ma.wafae.ta3aounyati.dto.responses.TaskResponse;
import ma.wafae.ta3aounyati.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAll(@RequestHeader("UserId") Integer userId){

        return ResponseEntity.ok(taskService.getAllByUserId(userId));
    }
    @PostMapping
    public ResponseEntity<TaskResponse> add(@Valid @RequestBody TaskRequest request){
        TaskResponse taskResponse = taskService.add(request);
        return new ResponseEntity<>(taskResponse, HttpStatus.OK);
    }
    @PatchMapping("/change-status/{id}")
    public ResponseEntity<TaskResponse> setAsDone(@PathVariable Integer id){
        TaskResponse taskResponse = taskService.setTaskAsDone(id);
        return new ResponseEntity<>(taskResponse, HttpStatus.OK);
    }
    @PatchMapping("/change-date/{id}")
    public ResponseEntity<TaskResponse> changeDate(@RequestBody Map<String, String> request, @PathVariable Integer id) {
        LocalDate date = LocalDate.parse(request.get("date")); // Parse date from the request body
        TaskResponse taskResponse = taskService.changeTaskDate(date, id);
        return new ResponseEntity<>(taskResponse, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        taskService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

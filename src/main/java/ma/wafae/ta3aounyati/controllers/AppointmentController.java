package ma.wafae.ta3aounyati.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.wafae.ta3aounyati.dto.requests.AppointmentRequest;
import ma.wafae.ta3aounyati.dto.responses.AppointmentResponse;
import ma.wafae.ta3aounyati.services.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<List<AppointmentResponse>> getAll(@RequestHeader("UserId") Integer userId){
        return ResponseEntity.ok(appointmentService.getAllByUserId(userId));
    }
    @GetMapping("/{date}")
    public ResponseEntity<List<AppointmentResponse>> getByDate(@PathVariable LocalDate date){
        return ResponseEntity.ok(appointmentService.getByDate(date));
    }
    @PostMapping
    public ResponseEntity<AppointmentResponse> add(@Valid @RequestBody AppointmentRequest request){
        System.out.println("Received request: " + request);
        AppointmentResponse appointmentResponse = appointmentService.add(request);
        return new ResponseEntity<>(appointmentResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        appointmentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}




package ma.wafae.ta3aounyati.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.wafae.ta3aounyati.dto.requests.LocationRequest;
import ma.wafae.ta3aounyati.dto.responses.LocationResponse;
import ma.wafae.ta3aounyati.services.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @GetMapping
    public ResponseEntity<List<LocationResponse>> getAll(@RequestHeader("UserId") Integer userId){
        return ResponseEntity.ok(locationService.getAllByUserId(userId));
    }
    @PostMapping
    public ResponseEntity<LocationResponse> add(@Valid @RequestBody LocationRequest request){
        LocationResponse locationResponse = locationService.add(request);
        return new ResponseEntity<>(locationResponse, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        locationService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

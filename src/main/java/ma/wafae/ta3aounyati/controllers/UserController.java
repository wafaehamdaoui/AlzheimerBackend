package ma.wafae.ta3aounyati.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.wafae.ta3aounyati.dto.requests.AuthenticationRequest;
import ma.wafae.ta3aounyati.dto.requests.UserRequest;
import ma.wafae.ta3aounyati.dto.responses.AuthenticationResponse;
import ma.wafae.ta3aounyati.dto.responses.UserResponse;
import ma.wafae.ta3aounyati.exceptions.ErrorResponse;
import ma.wafae.ta3aounyati.exceptions.ExceptionAbstract;
import ma.wafae.ta3aounyati.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping("/auth/signup")
    public ResponseEntity<UserResponse> add(@Valid @RequestBody UserRequest userRequest){
        UserResponse userResponse = userService.add(userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> get(@PathVariable Integer id){
        return new ResponseEntity<>(userService.get(id),HttpStatus.OK);
    }
    @PostMapping("/{id}")
    public ResponseEntity<UserResponse> update(@Valid @RequestBody UserRequest userRequest, @PathVariable Integer id){
        UserResponse userResponse = userService.update(userRequest, id);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
    @PostMapping("/reset/{id}")
    public ResponseEntity<UserResponse> resetPassword(@Valid @RequestBody String newPassword, @PathVariable Integer id){
        UserResponse userResponse = userService.resetPassword(newPassword, id);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/page")
    public Page<UserResponse> getAllUsers(Pageable pageable) {
        return userService.getAllPageable(pageable);
    }

    @PatchMapping("/change-status/{userId}")
    public ResponseEntity invalidateOrValidateAccount(
            @PathVariable Integer userId){
        userService.ActivateOrDeactivateUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        AuthenticationResponse response = userService.authenticate(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/invite/{email}")
    public ResponseEntity invite(@PathVariable String email){
        userService.invite(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(ExceptionAbstract.class)
    public ResponseEntity<ErrorResponse> handleException(ExceptionAbstract ex) {
        ErrorResponse errorResponse = new  ErrorResponse(ex.getStatus(), ex.getMessage(), ex.getErrorCode());
        return new ResponseEntity<>(errorResponse,ex.getStatus());
    }

}

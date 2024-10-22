package ma.wafae.ta3aounyati.services.impl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.wafae.ta3aounyati.config.JwtUtils;
import ma.wafae.ta3aounyati.dto.mappers.UserMapper;
import ma.wafae.ta3aounyati.dto.requests.AuthenticationRequest;
import ma.wafae.ta3aounyati.dto.requests.UserRequest;
import ma.wafae.ta3aounyati.dto.responses.AuthenticationResponse;
import ma.wafae.ta3aounyati.dto.responses.UserResponse;
import ma.wafae.ta3aounyati.exceptions.BadCredentialsException;
import ma.wafae.ta3aounyati.exceptions.ResourceAlreadyExistsException;
import ma.wafae.ta3aounyati.exceptions.ResourceNotFound;
import ma.wafae.ta3aounyati.models.User;
import ma.wafae.ta3aounyati.repositories.UserRepository;
import ma.wafae.ta3aounyati.services.EmailService;
import ma.wafae.ta3aounyati.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    private final EmailService emailService;


    @Override
    public UserResponse add(@Valid UserRequest request) {
        User user = userRepository.findByEmail(request.getEmail());
        if (user != null) {
            throw new ResourceAlreadyExistsException("Email already exist!");
        }
        user = userRepository.findByUsername(request.getUsername());
        if (user != null) {
            throw new ResourceAlreadyExistsException("Username already exist!");
        }
        user = UserMapper.INSTANCE.requestToEntity(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return UserMapper.INSTANCE.entityToResponse(userRepository.save(user));
    }

    @Override
    public List<UserResponse> getAll() {
        System.out.println("all users= "+userRepository.findAll());
        return UserMapper.INSTANCE.toDtos(userRepository.findAll());
    }

    @Override
    public Page<UserResponse> getAllPageable(Pageable pageable) {
        Page<User> usersPage = userRepository.findAll(pageable);
        return usersPage.map(UserMapper.INSTANCE::entityToResponse);
    }

    @Override
    public UserResponse get(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(
                ()->new ResourceNotFound("user not found"));
        return UserMapper.INSTANCE.entityToResponse(user);
    }

    @Override
    public UserResponse update(UserRequest request, Integer id) {
        User user = userRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("User not found"));
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        //user.setPassword(passwordEncoder.encode(request.getPassword()));
        return UserMapper.INSTANCE.entityToResponse(userRepository.save(user));
    }

    @Override
    public void delete(Integer id) {
        User user = userRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("User not found"));
        userRepository.delete(user);
    }

    @Override
    public Long getCount() {
        return userRepository.count();
    }

    @Override
    public void ActivateOrDeactivateUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("User not found"));
        userRepository.save(user);
    }

    @Override
    public AuthenticationResponse authenticate(@Valid @RequestBody AuthenticationRequest request){
        final User user = userRepository.findByUsername(request.getUsername());
        if (user==null){
            throw new BadCredentialsException("WRONG CREDENTIALS!");
        }
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
        } catch (Exception e) {
            throw new BadCredentialsException("WRONG CREDENTIALS");
        }

        final String token = jwtUtils.generateToken(user);
        return AuthenticationResponse.builder()
                .token(token)
                .user(UserMapper.INSTANCE.entityToResponse(user))
                .build();
    }

    @Override
    public UserResponse resetPassword(String newPassword, Integer id) {
        User user = userRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("User not found"));
        user.setPassword(passwordEncoder.encode(newPassword));
        return UserMapper.INSTANCE.entityToResponse(userRepository.save(user));
    }

    @Override
    public void invite(String email) {
        String address = email;
        String subject = "Invitation";
        String text = "We invite you to install application ta3aounyati to join us and sign up";

        // Send notification
        emailService.sendOrderNotification(address, subject, text);
    }

}

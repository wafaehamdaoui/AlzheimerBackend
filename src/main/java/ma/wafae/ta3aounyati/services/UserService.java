package ma.wafae.ta3aounyati.services;

import ma.wafae.ta3aounyati.dto.requests.AuthenticationRequest;
import ma.wafae.ta3aounyati.dto.requests.UserRequest;
import ma.wafae.ta3aounyati.dto.responses.AuthenticationResponse;
import ma.wafae.ta3aounyati.dto.responses.UserResponse;

public interface UserService extends CrudService<UserRequest, UserResponse, Integer>{
    void ActivateOrDeactivateUser(Integer id);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    UserResponse resetPassword(String newPassword, Integer id);

    void invite(String email);
}

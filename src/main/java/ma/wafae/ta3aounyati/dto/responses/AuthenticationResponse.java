package ma.wafae.ta3aounyati.dto.responses;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.wafae.ta3aounyati.models.User;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String token;
    private UserResponse user;
}

package ma.wafae.ta3aounyati.dto.requests;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRequest {

    @NotNull(message = "Username must not be null")
    @NotBlank(message = "Username must not be blank")
    @NotEmpty(message = "Username must not be empty")
    private String username;

    @Size(min = 8, max = 16, message = "Password must contain at least 8 characters and at most 16 characters")
    private String password;

    @Email(message = "Email must be a well-formed email address: example@example.ex")
    private String email;

    @NotNull(message = "Full name must not be null")
    private String fullName;

    private String profilePhotoUrl;

    @NotNull(message = "Age must not be null")
    @Min(value = 0, message = "Age must be greater than or equal to 0")
    private Integer age;

    private String profession;

    private String likes;

    private String dislikes;

    private String allergies;
}

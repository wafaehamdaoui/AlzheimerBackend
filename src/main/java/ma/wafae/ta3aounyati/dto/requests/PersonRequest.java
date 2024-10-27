package ma.wafae.ta3aounyati.dto.requests;


import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonRequest {

    @NotNull(message = "Name must not be null")
    @NotBlank(message = "Name must not be blank")
    @NotEmpty(message = "Name must not be empty")
    private String name;

    @NotNull(message = "Relation must not be null")
    @NotBlank(message = "Relation must not be blank")
    private String relation;

    @NotNull(message = "Phone must not be null")
    @NotBlank(message = "Phone must not be blank")
    private String phone;

    private String imagePath; // Optional: image path to the profile picture
}


package ma.wafae.ta3aounyati.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LocationRequest {
    @NotNull(message = "Name must not be null")
    @NotBlank(message = "Name must not be blank")
    @NotEmpty(message = "Name must not be empty")
    private String title;
    @NotNull(message = "Name must not be null")
    @NotBlank(message = "Name must not be blank")
    @NotEmpty(message = "Name must not be empty")
    private String coordinates;
    @NotNull(message = "Name must not be null")
    @NotBlank(message = "Name must not be blank")
    @NotEmpty(message = "Name must not be empty")
    private String imagePath;
}

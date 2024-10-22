package ma.wafae.ta3aounyati.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JournalRequest {
    @NotNull(message = "title must not be null")
    @NotBlank(message = "title must not be blank")
    @NotEmpty(message = "title must not be empty")
    private String description;
    @NotNull(message = "title must not be null")
    private LocalDateTime date;
}

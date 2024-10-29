package ma.wafae.ta3aounyati.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoutineRequest {
    @NotNull(message = "title must not be null")
    @NotBlank(message = "title must not be blank")
    @NotEmpty(message = "title must not be empty")
    private String title;         // The title of the routine item
    @NotNull(message = "category must not be null")
    @NotBlank(message = "category must not be blank")
    @NotEmpty(message = "category must not be empty")
    private String category;
    @NotNull(message = "time must not be null")
    private LocalTime time;
    private boolean done;
    @NotNull(message = "user id must not be null")
    private Integer userId;
}

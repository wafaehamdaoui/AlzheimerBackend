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
    @NotNull(message = "title must not be null")
    @NotBlank(message = "title must not be blank")
    @NotEmpty(message = "title must not be empty")
    private String category;      // The category (e.g., 'medicine', 'exercise', 'task')
    private LocalTime time;       // The time for the routine item
    private boolean done;
}

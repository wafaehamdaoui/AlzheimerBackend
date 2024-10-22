package ma.wafae.ta3aounyati.dto.responses;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalTime;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoutineResponse {
    private Integer id;
    private String title;         //
    private String category;      // The category (e.g., 'medicine', 'exercise', 'task')
    private LocalTime time;       // The time for the routine item
    private boolean done;
}

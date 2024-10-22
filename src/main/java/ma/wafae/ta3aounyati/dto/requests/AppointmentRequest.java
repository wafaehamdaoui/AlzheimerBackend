package ma.wafae.ta3aounyati.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentRequest {

    @NotNull(message = "title must not be null")
    @NotBlank(message = "title must not be blank")
    @NotEmpty(message = "title must not be empty")
    private String title;

    @NotNull(message = "title must not be null")
    @NotBlank(message = "title must not be blank")
    @NotEmpty(message = "title must not be empty")
    private String description;
    private LocalDate date;
    private LocalTime time;
}

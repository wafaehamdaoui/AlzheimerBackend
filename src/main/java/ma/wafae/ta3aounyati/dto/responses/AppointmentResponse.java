package ma.wafae.ta3aounyati.dto.responses;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AppointmentResponse {
    private Integer id;
    private String title;
    private String description;
    private LocalTime time;
    private LocalDate date;
}

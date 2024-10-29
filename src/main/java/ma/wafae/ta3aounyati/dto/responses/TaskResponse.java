package ma.wafae.ta3aounyati.dto.responses;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaskResponse {
    private Integer id;
    private String title;
    private String description;
    private boolean done ;
    private LocalDate date;
    private Integer userId;
}

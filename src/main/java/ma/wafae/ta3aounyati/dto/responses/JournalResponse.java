package ma.wafae.ta3aounyati.dto.responses;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JournalResponse {
    private Integer id;
    private String description;
    private LocalDateTime date;
    private Integer userId;
}

package ma.wafae.ta3aounyati.dto.responses;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LocationResponse {
    private Integer id;
    private String title;
    private String coordinates;
    private String imagePath;
}

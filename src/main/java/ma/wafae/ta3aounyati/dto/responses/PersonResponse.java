package ma.wafae.ta3aounyati.dto.responses;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonResponse {
    private Integer id;
    private String name;
    private String relation;
    private String phone;
    private String imagePath;
}

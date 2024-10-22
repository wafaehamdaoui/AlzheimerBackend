package ma.wafae.ta3aounyati.dto.responses;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserResponse {
    private Integer id;
    private String username;
    private String email;
    private String fullName;
    private String profilePhotoUrl; // Optional
    private Integer age;
    private String profession;
    private String likes;
    private String dislikes;
    private String allergies;
}


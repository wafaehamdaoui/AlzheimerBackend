package ma.wafae.ta3aounyati.dto.mappers;

import ma.wafae.ta3aounyati.dto.requests.UserRequest;
import ma.wafae.ta3aounyati.dto.responses.UserResponse;
import ma.wafae.ta3aounyati.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User requestToEntity(UserRequest userRequest);
    User responseToEntity(UserResponse userResponse);
    UserResponse entityToResponse(User user);
    UserRequest entityToRequest(User user);
    List<UserResponse> toDtos(List<User> users);
    List<User> toEntities(List<UserResponse> userResponses);
}

package ma.wafae.ta3aounyati.dto.mappers;

import ma.wafae.ta3aounyati.dto.requests.TaskRequest;
import ma.wafae.ta3aounyati.dto.responses.TaskResponse;
import ma.wafae.ta3aounyati.models.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    Task requestToEntity(TaskRequest taskRequest);
    Task responseToEntity(TaskResponse taskResponse);
    TaskResponse entityToResponse(Task task);
    TaskRequest entityToRequest(Task task);
    List<TaskResponse> toDtos(List<Task> tasks);
    List<Task> toEntities(List<TaskResponse> taskResponses);
}

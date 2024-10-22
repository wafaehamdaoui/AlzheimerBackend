package ma.wafae.ta3aounyati.dto.mappers;

import ma.wafae.ta3aounyati.dto.requests.RoutineRequest;
import ma.wafae.ta3aounyati.dto.responses.RoutineResponse;
import ma.wafae.ta3aounyati.models.Routine;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoutineMapper {
    RoutineMapper INSTANCE = Mappers.getMapper(RoutineMapper.class);

    // Mapping methods between request/response and entity
    Routine requestToEntity(RoutineRequest routineRequest);
    Routine responseToEntity(RoutineResponse routineResponse);
    RoutineResponse entityToResponse(Routine routine);
    RoutineRequest entityToRequest(Routine routine);
    List<RoutineResponse> toDtos(List<Routine> routines);
    List<Routine> toEntities(List<RoutineResponse> routineResponses);
}

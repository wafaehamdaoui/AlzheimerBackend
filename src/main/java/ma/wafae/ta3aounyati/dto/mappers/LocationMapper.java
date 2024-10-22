package ma.wafae.ta3aounyati.dto.mappers;

import ma.wafae.ta3aounyati.dto.requests.LocationRequest;
import ma.wafae.ta3aounyati.dto.responses.LocationResponse;
import ma.wafae.ta3aounyati.models.Location;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);

    Location requestToEntity(LocationRequest locationRequest);
    Location responseToEntity(LocationResponse locationResponse);
    LocationResponse entityToResponse(Location location);
    LocationRequest entityToRequest(Location location);
    List<LocationResponse> toDtos(List<Location> Locations);
    List<Location> toEntities(List<LocationResponse> locationResponses);
}

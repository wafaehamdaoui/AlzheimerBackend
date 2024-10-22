package ma.wafae.ta3aounyati.dto.mappers;

import ma.wafae.ta3aounyati.dto.requests.PersonRequest;
import ma.wafae.ta3aounyati.dto.responses.PersonResponse;
import ma.wafae.ta3aounyati.models.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    // Mapping methods between request/response and entity
    Person requestToEntity(PersonRequest personRequest);
    Person responseToEntity(PersonResponse personResponse);
    PersonResponse entityToResponse(Person person);
    PersonRequest entityToRequest(Person person);
    List<PersonResponse> toDtos(List<Person> people);
    List<Person> toEntities(List<PersonResponse> personResponses);
}

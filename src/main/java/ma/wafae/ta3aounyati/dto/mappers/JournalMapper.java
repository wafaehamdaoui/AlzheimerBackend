package ma.wafae.ta3aounyati.dto.mappers;

import ma.wafae.ta3aounyati.dto.requests.JournalRequest;
import ma.wafae.ta3aounyati.dto.responses.JournalResponse;
import ma.wafae.ta3aounyati.models.Journal;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JournalMapper {
    JournalMapper INSTANCE = Mappers.getMapper(JournalMapper.class);

    Journal requestToEntity(JournalRequest journalRequest);
    Journal responseToEntity(JournalResponse journalResponse);
    JournalResponse entityToResponse(Journal journal);
    JournalRequest entityToRequest(Journal journal);
    List<JournalResponse> toDtos(List<Journal> journals);
    List<Journal> toEntities(List<JournalResponse> journalResponses);
}

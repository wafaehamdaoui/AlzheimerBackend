package ma.wafae.ta3aounyati.services;

import ma.wafae.ta3aounyati.dto.requests.JournalRequest;
import ma.wafae.ta3aounyati.dto.responses.JournalResponse;

import java.util.List;

public interface JournalService extends CrudService<JournalRequest, JournalResponse, Integer>{
    List<JournalResponse> getAllByUserId(Integer userId);
}

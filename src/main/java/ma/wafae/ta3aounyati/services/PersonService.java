package ma.wafae.ta3aounyati.services;


import ma.wafae.ta3aounyati.dto.requests.PersonRequest;
import ma.wafae.ta3aounyati.dto.responses.PersonResponse;

import java.util.List;

public interface PersonService extends CrudService<PersonRequest, PersonResponse, Integer>{
    List<PersonResponse> getAllByUserId(Integer userId);
}

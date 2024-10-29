package ma.wafae.ta3aounyati.services;

import ma.wafae.ta3aounyati.dto.requests.LocationRequest;
import ma.wafae.ta3aounyati.dto.responses.LocationResponse;

import java.util.List;

public interface LocationService extends CrudService<LocationRequest, LocationResponse, Integer>{
    List<LocationResponse> getAllByUserId(Integer userId);
}

package ma.wafae.ta3aounyati.services;


import ma.wafae.ta3aounyati.dto.requests.RoutineRequest;
import ma.wafae.ta3aounyati.dto.responses.RoutineResponse;

import java.time.LocalTime;
import java.util.List;

public interface RoutineService extends CrudService<RoutineRequest, RoutineResponse, Integer>{
    List<RoutineResponse> getAllByUserId(Integer userId);
    RoutineResponse updateTime(LocalTime time, Integer id);

    RoutineResponse setAsDone(Integer id);

    RoutineResponse setAsUndone(Integer id);
}

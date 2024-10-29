package ma.wafae.ta3aounyati.services;


import ma.wafae.ta3aounyati.dto.requests.TaskRequest;
import ma.wafae.ta3aounyati.dto.responses.TaskResponse;
import org.springframework.web.bind.annotation.RequestHeader;

import java.time.LocalDate;
import java.util.List;

public interface TaskService extends CrudService<TaskRequest, TaskResponse, Integer>{
    List<TaskResponse> getAllByUserId(Integer userId);

    public TaskResponse setTaskAsDone(Integer id);

    TaskResponse changeTaskDate(LocalDate date, Integer id);
}

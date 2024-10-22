package ma.wafae.ta3aounyati.services;


import ma.wafae.ta3aounyati.dto.requests.TaskRequest;
import ma.wafae.ta3aounyati.dto.responses.TaskResponse;

import java.time.LocalDate;

public interface TaskService extends CrudService<TaskRequest, TaskResponse, Integer>{
    public TaskResponse setTaskAsDone(Integer id);

    TaskResponse changeTaskDate(LocalDate date, Integer id);
}

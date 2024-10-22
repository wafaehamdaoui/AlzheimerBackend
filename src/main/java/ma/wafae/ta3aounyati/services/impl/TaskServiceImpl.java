package ma.wafae.ta3aounyati.services.impl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.wafae.ta3aounyati.dto.mappers.TaskMapper;
import ma.wafae.ta3aounyati.dto.requests.TaskRequest;
import ma.wafae.ta3aounyati.dto.responses.TaskResponse;
import ma.wafae.ta3aounyati.exceptions.ResourceNotFound;
import ma.wafae.ta3aounyati.models.Task;
import ma.wafae.ta3aounyati.repositories.TaskRepository;
import ma.wafae.ta3aounyati.services.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    @Override
    public TaskResponse add(@Valid TaskRequest request) {
        Task task = TaskMapper.INSTANCE.requestToEntity(request);
        return TaskMapper.INSTANCE.entityToResponse(taskRepository.save(task));
    }

    @Override
    public List<TaskResponse> getAll() {
        return TaskMapper.INSTANCE.toDtos(taskRepository.findAll());
    }
    @Override
    public TaskResponse setTaskAsDone(Integer id) {
        Task task = taskRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("Task not found"));
        task.setDone(true);
        return TaskMapper.INSTANCE.entityToResponse(taskRepository.save(task));
    }

    @Override
    public TaskResponse changeTaskDate(LocalDate date, Integer id) {
        Task task = taskRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("Task not found"));
        task.setDate(date);
        return TaskMapper.INSTANCE.entityToResponse(taskRepository.save(task));
    }

    @Override
    public Page<TaskResponse> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public TaskResponse get(Integer integer) {
        return null;
    }

    @Override
    public TaskResponse update(TaskRequest request, Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        Task task = taskRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("Task not found"));
        taskRepository.delete(task);
    }

    @Override
    public Long getCount() {
        return null;
    }


}

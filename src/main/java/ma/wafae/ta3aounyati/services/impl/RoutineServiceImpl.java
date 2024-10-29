package ma.wafae.ta3aounyati.services.impl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.wafae.ta3aounyati.dto.mappers.RoutineMapper;
import ma.wafae.ta3aounyati.dto.requests.RoutineRequest;
import ma.wafae.ta3aounyati.dto.responses.RoutineResponse;
import ma.wafae.ta3aounyati.exceptions.ResourceNotFound;
import ma.wafae.ta3aounyati.models.Routine;
import ma.wafae.ta3aounyati.repositories.RoutineRepository;
import ma.wafae.ta3aounyati.services.RoutineService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class RoutineServiceImpl implements RoutineService {
    private final RoutineRepository routineRepository;
    @Override
    public RoutineResponse add(@Valid RoutineRequest request) {
        Routine routine = RoutineMapper.INSTANCE.requestToEntity(request);
        return RoutineMapper.INSTANCE.entityToResponse(routineRepository.save(routine));
    }

    @Override
    public List<RoutineResponse> getAll() {
        return RoutineMapper.INSTANCE.toDtos(routineRepository.findAll());
    }

    @Override
    public Page<RoutineResponse> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public RoutineResponse get(Integer integer) {
        return null;
    }

    @Override
    public RoutineResponse update(RoutineRequest request, Integer id) {
       return null;
    }

    @Override
    public List<RoutineResponse> getAllByUserId(Integer userId) {
        return RoutineMapper.INSTANCE.toDtos(routineRepository.findByUserId(userId));
    }

    @Override
    public RoutineResponse updateTime(LocalTime time, Integer id) {
        Routine routine = routineRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("Task not found"));
        routine.setTime(time);
        return RoutineMapper.INSTANCE.entityToResponse(routineRepository.save(routine));
    }

    @Override
    public RoutineResponse setAsDone(Integer id) {
        Routine routine = routineRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("Task not found"));
        routine.setDone(true);
        return RoutineMapper.INSTANCE.entityToResponse(routineRepository.save(routine));
    }
    @Override
    public RoutineResponse setAsUndone(Integer id) {
        Routine routine = routineRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("Task not found"));
        routine.setDone(false);
        return RoutineMapper.INSTANCE.entityToResponse(routineRepository.save(routine));
    }

    @Override
    public void delete(Integer id) {
        Routine routine = routineRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("Task not found"));
        routineRepository.delete(routine);
    }

    @Override
    public Long getCount() {
        return null;
    }
}

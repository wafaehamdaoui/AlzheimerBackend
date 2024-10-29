package ma.wafae.ta3aounyati.services.impl;

import lombok.RequiredArgsConstructor;
import ma.wafae.ta3aounyati.dto.mappers.AppointmentMapper;
import ma.wafae.ta3aounyati.dto.requests.AppointmentRequest;
import ma.wafae.ta3aounyati.dto.responses.AppointmentResponse;
import ma.wafae.ta3aounyati.exceptions.ResourceNotFound;
import ma.wafae.ta3aounyati.models.Appointment;
import ma.wafae.ta3aounyati.repositories.AppointmentRepository;
import ma.wafae.ta3aounyati.services.AppointmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    @Override
    public AppointmentResponse add(AppointmentRequest request) {
        Appointment appointment = AppointmentMapper.INSTANCE.requestToEntity(request);
        appointment.setDate(request.getDate());
        return AppointmentMapper.INSTANCE.entityToResponse(appointmentRepository.save(appointment));
    }

    @Override
    public List<AppointmentResponse> getAll() {
        return AppointmentMapper.INSTANCE.toDtos(appointmentRepository.findAll());
    }

    @Override
    public List<AppointmentResponse> getAllByUserId(Integer userId) {
        return AppointmentMapper.INSTANCE.toDtos(appointmentRepository.findByUserId(userId));
    }

    @Override
    public List<AppointmentResponse> getByDate(LocalDate date) {
        return AppointmentMapper.INSTANCE.toDtos(appointmentRepository.findAllByDate(date));
    }
    @Override
    public void delete(Integer id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("appointment not found"));
        appointmentRepository.delete(appointment);
    }

    @Override
    public Page<AppointmentResponse> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public AppointmentResponse get(Integer integer) {
        return null;
    }

    @Override
    public AppointmentResponse update(AppointmentRequest request, Integer integer) {
        return null;
    }

    @Override
    public Long getCount() {
        return null;
    }


}

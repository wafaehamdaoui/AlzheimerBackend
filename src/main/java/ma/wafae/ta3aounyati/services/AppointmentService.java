package ma.wafae.ta3aounyati.services;


import ma.wafae.ta3aounyati.dto.requests.AppointmentRequest;
import ma.wafae.ta3aounyati.dto.responses.AppointmentResponse;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public interface AppointmentService extends CrudService<AppointmentRequest, AppointmentResponse, Integer> {
    public List<AppointmentResponse> getByDate(LocalDate date);
}

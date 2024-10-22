package ma.wafae.ta3aounyati.repositories;

import ma.wafae.ta3aounyati.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
    public List<Appointment> findAllByDate(LocalDate date);
}

package pl.pawel.przychodnialekarska.dao;

import org.springframework.data.repository.CrudRepository;
import pl.pawel.przychodnialekarska.model.Patient;

public interface PatientDao extends CrudRepository<Patient, Long> {
}

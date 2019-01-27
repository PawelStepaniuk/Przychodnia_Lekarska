package pl.pawel.przychodnialekarska.dao;

import org.springframework.data.repository.CrudRepository;
import pl.pawel.przychodnialekarska.model.Doctor;

public interface DoctorDao extends CrudRepository<Doctor, Long> {
}

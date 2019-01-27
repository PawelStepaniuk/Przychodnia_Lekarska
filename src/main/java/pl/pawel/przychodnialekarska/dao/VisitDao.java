package pl.pawel.przychodnialekarska.dao;

import org.springframework.data.repository.CrudRepository;
import pl.pawel.przychodnialekarska.model.Visit;

public interface VisitDao extends CrudRepository<Visit,Long> {
}

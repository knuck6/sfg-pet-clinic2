package sfgpetclinic2.repositories;

import org.springframework.data.repository.CrudRepository;
import sfgpetclinic2.model.Visit;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}

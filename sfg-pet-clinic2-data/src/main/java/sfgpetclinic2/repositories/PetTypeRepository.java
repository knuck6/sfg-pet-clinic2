package sfgpetclinic2.repositories;

import org.springframework.data.repository.CrudRepository;
import sfgpetclinic2.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}

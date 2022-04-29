package sfgpetclinic2.repositories;

import org.springframework.data.repository.CrudRepository;
import sfgpetclinic2.model.Pet;

public interface PetRepository extends CrudRepository<Pet,Long> {
}

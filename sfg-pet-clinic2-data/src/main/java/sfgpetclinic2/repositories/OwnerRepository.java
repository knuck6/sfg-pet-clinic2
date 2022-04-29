package sfgpetclinic2.repositories;

import org.springframework.data.repository.CrudRepository;
import sfgpetclinic2.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
}

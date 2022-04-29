package sfgpetclinic2.services;



import sfgpetclinic2.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner,Long> {
    Owner findByLastName(String lastName);

}

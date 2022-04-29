package sfgpetclinic2.services.map;

import org.springframework.stereotype.Service;
import sfgpetclinic2.model.Speciality;
import sfgpetclinic2.services.SpecialtyService;

import java.util.Set;

@Service
public class SpecialtiesMapService extends AbstractMapService<Speciality,Long>implements SpecialtyService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) { super.deleteById(id);

    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);

    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}

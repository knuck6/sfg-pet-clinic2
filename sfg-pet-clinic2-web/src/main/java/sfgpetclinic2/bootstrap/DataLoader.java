package sfgpetclinic2.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sfgpetclinic2.model.*;
import sfgpetclinic2.services.OwnerService;
import sfgpetclinic2.services.PetTypeService;
import sfgpetclinic2.services.SpecialtyService;
import sfgpetclinic2.services.VetService;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final SpecialtyService specialtyService;

    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, SpecialtyService specialtyService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.specialtyService = specialtyService;

        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0 ){
            loadData();
        }
    }

       private void loadData(){
           PetType dog = new PetType();
           dog.setName("Doggy");
           PetType savedDogType = petTypeService.save(dog);
           PetType cat = new PetType();
           dog.setName("Jessie");
           PetType savedCatType = petTypeService.save(cat);

           Speciality radiology = new Speciality();
           radiology.setDescription("Radiology");
           Speciality saveRadiology = specialtyService.save(radiology);
           Speciality surgery = new Speciality();
           surgery.setDescription("Surgery");
           Speciality saveSurgery = specialtyService.save(surgery);
           Speciality dentistry = new Speciality();
           dentistry.setDescription("Dentistry");
           Speciality saveDentistry = specialtyService.save(dentistry);



           Owner owner1 = new Owner();
           //owner1.setId(1L);
           owner1.setFirstName("Mitch");
           owner1.setLastName("West");
           owner1.setAddress(" No 2 , City of Westmister");
           owner1.setCity("SE");
           owner1.setPhone("0123456789**");


           Pet mikesPet = new Pet();
           mikesPet.setPetType(savedDogType);
           mikesPet.setOwner(owner1);
           mikesPet.setBirthDate(LocalDate.of(2019,2,17));
           mikesPet.setName("Dakota");
           owner1.getPets().add(mikesPet);
           ownerService.save(owner1);


           Owner owner2 = new Owner();
           //owner2.setId(2L);
           owner2.setFirstName("Fionna");
           owner2.setLastName("Gleens");
           owner2.setAddress(" No 4 , City of Westmister");
           owner2.setCity("Re");
           owner2.setPhone("9876543210**");
           Pet fionnaCat = new Pet();
           fionnaCat.setOwner(owner2);
           fionnaCat.setName("Only Cat");
           fionnaCat.setBirthDate(LocalDate.now());
           fionnaCat.setPetType(savedCatType);
           owner2.getPets().add(fionnaCat);


           ownerService.save(owner2);

           System.out.println("Loaded Owners ....");

           Vet vet1 = new Vet();
           //vet1.setId(1L);
           vet1.setFirstName("Sam");
           vet1.setLastName("Smith");
           vet1.getSpecialities().add(saveRadiology);
           vetService.save(vet1);

           Vet vet2 = new Vet();
           //vet2.setId(2L);
           vet2.setFirstName("Jessica");
           vet2.setLastName("Mass");
           vetService.save(vet2);
           vet2.getSpecialities().add(saveSurgery);

           System.out.println("Loaded Vets ... ");


       }

}

package io.quarkus.samples.petclinic.service.Interface;
import io.quarkus.samples.petclinic.dto.perfume.PerfumeSearchRequestDto;
import io.quarkus.samples.petclinic.model.Owner;
import io.quarkus.samples.petclinic.model.Perfume;
import io.quarkus.samples.petclinic.model.Pet;
import io.quarkus.samples.petclinic.model.PetType;
import io.quarkus.samples.petclinic.model.Vet;
import io.quarkus.samples.petclinic.model.Visit;
import java.util.Collection;
import java.util.List;

public interface IClinicService {

     List<PetType> findAllPetTypes() ;

     PetType findPetTypeById(Long petTypeId) ;

     Collection<Vet> findAllVets();

     Pet findPetById(Long petId);

     Pet savePet(Pet pet);

     Pet addVisit(long petId, Visit visit);


     Pet updatePet(long petId, Pet pet);

     Collection<Perfume> findPerfumeByPerfumeTitle(String perfumeTitle);


     Collection<Perfume> findPerfumeByRequest(PerfumeSearchRequestDto perfumeSearchRequestDto);

     Perfume findPerfumeById(Long perfumeId) ;


     Perfume savePerfume(Perfume perfume) ;


     Perfume updatePerfume(long perfumeId, Perfume perfume);


     Collection<Owner> findOwnerByLastName(String ownerLastName) ;

     Owner findOwnerById(Long ownerId) ;


     Owner saveOwner(Owner owner);

     Owner updateOwner(long ownerId, Owner owner);


     Collection<Perfume> findPerfumeByPerfumer(String perfumer) ;


}

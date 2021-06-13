package io.quarkus.samples.petclinic.service.Interface;
import io.quarkus.samples.petclinic.dto.perfume.PerfumeSearchRequestDto;
import io.quarkus.samples.petclinic.model.Order;
import io.quarkus.samples.petclinic.model.Owner;
import io.quarkus.samples.petclinic.model.Perfume;
import io.quarkus.samples.petclinic.model.Pet;
import io.quarkus.samples.petclinic.model.PetType;
import io.quarkus.samples.petclinic.model.Vet;
import io.quarkus.samples.petclinic.model.Visit;
import java.util.Collection;
import java.util.List;

public interface IOrderService {
     Order saveOrder(Order order);

}

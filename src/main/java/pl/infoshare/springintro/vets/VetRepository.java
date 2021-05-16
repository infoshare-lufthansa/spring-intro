package pl.infoshare.springintro.vets;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.infoshare.springintro.pets.model.Pet;
import pl.infoshare.springintro.support.IdGenerator;
import pl.infoshare.springintro.vets.model.Vet;

import java.util.*;

@Component
@RequiredArgsConstructor
public class VetRepository {

    private final IdGenerator idGenerator;
    private final Map<Integer, Vet> vets = new HashMap<>();

    public Collection<Vet> findAll() {
        return vets.values();
    }

    public Optional<Vet> findOne(Integer vetId) {
        return Optional.ofNullable(vets.get(vetId));
    }

    public void save(Vet vet) {
        int id = idGenerator.getNext();
        vets.put(id, vet.withId(id));
    }
}

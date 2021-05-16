package pl.infoshare.springintro.pets;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import pl.infoshare.springintro.pets.model.Pet;
import pl.infoshare.springintro.support.IdGenerator;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PetRepository {

    private final IdGenerator idGenerator;
    private final Map<Integer, Pet> pets = new HashMap<>();

    public Collection<Pet> findAllByName(String name) {
        return pets.values()
                .stream()
                .filter(p -> p.getName().toUpperCase().contains(name.toUpperCase()))
                .collect(Collectors.toList());
    }

    public Optional<Pet> findOne(int id) {
        return Optional.ofNullable(pets.get(id));
    }

    public void save(Pet pet) {
        var id = idGenerator.getNext();
        pets.put(id, pet.withId(id));
    }
}

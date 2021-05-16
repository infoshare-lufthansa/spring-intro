package pl.infoshare.springintro.pets;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.infoshare.springintro.pets.model.Pet;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PetController {

    private final PetRepository petRepository;

    @GetMapping("/pets")
    public Collection<Pet> getPets(@RequestParam(defaultValue = "") String q) {
        return petRepository.findAllByName(q);
    }

    @GetMapping("/pets/{id}")
    public Optional<Pet> getPet(@PathVariable int id) {
        return petRepository.findOne(id);
    }

    @PostMapping("/pets")
    public void createPet(@RequestBody Pet pet) {
        petRepository.save(pet);
    }
}

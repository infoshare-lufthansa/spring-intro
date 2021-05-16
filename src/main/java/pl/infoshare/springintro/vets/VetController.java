package pl.infoshare.springintro.vets;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.infoshare.springintro.vets.model.Vet;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class VetController {

    private final VetRepository vetRepository;

    @GetMapping("/vets")
    public Collection<Vet> findAll() {
        return vetRepository.findAll();
    }

    @PostMapping("/vets")
    public void createVet(@RequestBody Vet vet) {
        vetRepository.save(vet);
    }
}

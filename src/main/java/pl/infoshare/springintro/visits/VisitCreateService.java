package pl.infoshare.springintro.visits;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import pl.infoshare.springintro.pets.PetRepository;
import pl.infoshare.springintro.vets.VetRepository;
import pl.infoshare.springintro.visits.model.Visit;
import pl.infoshare.springintro.visits.model.VisitRequest;

@Component
@RequiredArgsConstructor
public class VisitCreateService {

    private final VetRepository vetRepository;
    private final PetRepository petRepository;
    private final VisitRepository visitRepository;
    private final VisitDateProvider visitDateProvider;

    public Visit createNewVisit(VisitRequest visitRequest) {
        var vet = vetRepository.findOne(visitRequest.getVetId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vet not found"));
        var pet = petRepository.findOne(visitRequest.getPetId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pet not found"));

        var visitDate = visitDateProvider.getNextVisitDateFor(vet);
        return visitRepository.save(new Visit(null, vet, pet, visitDate));
    }
}

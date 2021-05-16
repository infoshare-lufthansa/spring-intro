package pl.infoshare.springintro.visits;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.infoshare.springintro.vets.model.Vet;
import pl.infoshare.springintro.visits.model.Visit;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class VisitDateProvider {

    private final VisitRepository visitRepository;

    public LocalDate getNextVisitDateFor(Vet vet) {
        return visitRepository.findAllByVet(vet)
                .stream()
                .map(Visit::getDate)
                .sorted()
                .findFirst()
                .orElse(LocalDate.now())
                .plusDays(1);
    }
}

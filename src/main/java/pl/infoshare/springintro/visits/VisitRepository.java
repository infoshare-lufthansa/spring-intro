package pl.infoshare.springintro.visits;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.infoshare.springintro.support.IdGenerator;
import pl.infoshare.springintro.vets.model.Vet;
import pl.infoshare.springintro.visits.model.Visit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class VisitRepository {

    private final IdGenerator idGenerator;
    private final Map<Integer, Visit> visits = new HashMap<>();

    public List<Visit> findAllByVet(Vet vet) {
        return visits.values()
                .stream()
                .filter(v -> Objects.equals(v.getVet().getId(), vet.getId()))
                .collect(Collectors.toList());
    }

    public Visit save(Visit visit) {
        var id = idGenerator.getNext();
        var savedVisit = visit.withId(id);

        visits.put(id, savedVisit);
        return savedVisit;
    }
}

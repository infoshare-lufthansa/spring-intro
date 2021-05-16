package pl.infoshare.springintro.visits;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.infoshare.springintro.visits.model.Visit;
import pl.infoshare.springintro.visits.model.VisitRequest;

@RestController
@RequiredArgsConstructor
public class VisitController {

    private final VisitCreateService visitCreateService;

    @PostMapping("/visits")
    public Visit createVisit(@RequestBody VisitRequest visitRequest) {
        return visitCreateService.createNewVisit(visitRequest);
    }
}

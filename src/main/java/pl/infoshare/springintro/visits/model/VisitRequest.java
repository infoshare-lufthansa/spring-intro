package pl.infoshare.springintro.visits.model;

import lombok.Value;

import java.time.LocalDate;

@Value
public class VisitRequest {
    Integer petId;
    Integer vetId;
}

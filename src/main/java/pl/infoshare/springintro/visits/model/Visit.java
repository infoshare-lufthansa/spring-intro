package pl.infoshare.springintro.visits.model;

import lombok.Value;
import lombok.With;
import pl.infoshare.springintro.pets.model.Pet;
import pl.infoshare.springintro.vets.model.Vet;

import java.time.LocalDate;

@Value
public class Visit {

    @With
    Integer id;
    Vet vet;
    Pet pet;
    LocalDate date;

}
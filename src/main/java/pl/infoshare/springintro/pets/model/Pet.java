package pl.infoshare.springintro.pets.model;

import lombok.Value;

import java.time.LocalDate;

@Value
public class Pet {

    String name;
    LocalDate birthDate;
    PetType type;
}

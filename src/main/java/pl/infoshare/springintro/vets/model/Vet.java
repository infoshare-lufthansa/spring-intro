package pl.infoshare.springintro.vets.model;

import lombok.Value;
import lombok.With;

@Value
public class Vet {

    @With
    Integer id;
    String name;
}

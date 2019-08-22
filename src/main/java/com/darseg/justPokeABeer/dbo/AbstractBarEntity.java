package com.darseg.justPokeABeer.dbo;

import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class AbsractBarEntity {
    @ManyToOne
    @JoinColumn(name = "bid")
    private BarDBO bar;
}

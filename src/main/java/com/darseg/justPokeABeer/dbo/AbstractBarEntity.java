package com.darseg.justPokeABeer.dbo;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class AbstractBarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bid")
    private BarDBO bar;
}

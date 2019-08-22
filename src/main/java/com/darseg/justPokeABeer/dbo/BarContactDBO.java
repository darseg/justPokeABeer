package com.darseg.justPokeABeer.dbo;

import com.darseg.justPokeABeer.enums.ContactType;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "bar_contact")
public class ContactDBO extends AbstractBarEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ContactType type;

    @Column(name = "contact")
    private String contact;

    @Column(name = "description")
    private String description;
}

package com.darseg.justPokeABeer.dbo;

import com.darseg.justPokeABeer.enums.ContactType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bar_contact")
public class BarContactDBO extends AbstractBarEntity {
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "type")
    private ContactType type;

    @Column(name = "contact")
    private String contact;

    @Column(name = "description")
    private String description;
}

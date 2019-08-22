package com.darseg.justPokeABeer.dbo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "bar_image")
public class BarImagesDBO extends AbstractBarEntity {
    @Column(name = "image_url")
    private String imageURL;
}

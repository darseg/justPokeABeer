package com.darseg.justPokeABeer.dbo;

import com.darseg.justPokeABeer.enums.DayOfWeek;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "bar_schedule")
public class BarScheduleDBO extends AbstractBarEntity {
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "day")
    private DayOfWeek dayOfWeek;

    private LocalTime open;

    private LocalTime close;
}

package com.darseg.justPokeABeer.dbo;

import com.darseg.justPokeABeer.enums.DayOfWeek;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;

@Data
@Table(name = "bar_schedule")
public class ScheduleDBO extends AbstractBarEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "day")
    private DayOfWeek dayOfWeek;

    private LocalTime open;

    private LocalTime close;
}

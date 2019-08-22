package com.darseg.justPokeABeer.dto;

import com.darseg.justPokeABeer.enums.DayOfWeek;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class BarScheduleDTO {
    private List<DaySchedule> daySchedules = new ArrayList<>();

    public void addDay(final DayOfWeek day, final LocalTime open, final LocalTime close) {
        daySchedules.add(new DaySchedule(day, open, close));
    }

    @Data
    @AllArgsConstructor
    public class DaySchedule {
        private DayOfWeek day;

        private LocalTime open;

        private LocalTime close;
    }
}

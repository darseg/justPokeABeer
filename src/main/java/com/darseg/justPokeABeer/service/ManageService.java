package com.darseg.justPokeABeer.service;

import com.darseg.justPokeABeer.dto.BarDTO;
import com.darseg.justPokeABeer.dto.BarScheduleDTO;
import com.darseg.justPokeABeer.enums.DayOfWeek;
import com.darseg.justPokeABeer.service.scrap.ScrapBar;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManageService {

	@Autowired
	private List<ScrapBar> scrapBars;

	@Autowired
	private BarService barService;
	
	public void load() {
		//final List<BarDTO> bars = scrapBars.stream().flatMap(scrapBar -> scrapBar.getAllBars().stream()).collect(Collectors.toList());
		final List<BarDTO> bars = new ArrayList<>();
		final BarDTO bar = new BarDTO("fake", "fake2");
		final BarScheduleDTO barScheduleDTO = new BarScheduleDTO();
		barScheduleDTO.addDay(DayOfWeek.MONDAY, LocalTime.parse("12:00"), LocalTime.parse("22:00"));
		barScheduleDTO.addDay(DayOfWeek.FRIDAY, LocalTime.parse("12:00"), LocalTime.parse("23:00"));
		bar.setSchedule(barScheduleDTO);
		barService.saveBar(bar);
		//System.out.println(bars);
	}
}
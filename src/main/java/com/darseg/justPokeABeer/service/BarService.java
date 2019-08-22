package com.darseg.justPokeABeer.service;

import com.darseg.justPokeABeer.converter.BarConverter;
import com.darseg.justPokeABeer.dbo.BarDBO;
import com.darseg.justPokeABeer.dto.BarDTO;
import com.darseg.justPokeABeer.repository.BarRepository;
import com.darseg.justPokeABeer.repository.BarScheduleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BarService {
    private BarRepository barRepository;

    private BarScheduleRepository barScheduleRepository;

    private BarConverter barConverter;

    public BarDTO getBar(final Long id) {
        final BarDBO bar = barRepository.getByBid(id);
        return barConverter.convertToDto(bar);
    }

    public void saveBar(final BarDTO bar) {
        final BarDBO barDBO = barConverter.convertToDbo(bar);
        barRepository.save(barDBO);
        barScheduleRepository.saveAll(barDBO.getSchedules());
    }
}

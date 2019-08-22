package com.darseg.justPokeABeer.service;

import com.darseg.justPokeABeer.dbo.BarDBO;
import com.darseg.justPokeABeer.repository.BarRepository;
import com.darseg.justPokeABeer.service.scrap.ScrapBar;
import com.darseg.justPokeABeer.service.scrap.impl.ScrapGusto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class ManageServiceConfiguration {
    @Bean
    public ManageService getManageService() {
        final List<ScrapBar> scrapBars = new ArrayList<>();
        scrapBars.add(new ScrapGusto());
        return new ManageService();
    }

    @Bean
    public List<ScrapBar> scrapBars() {
        final List<ScrapBar> scrapBars = new ArrayList<>();
        scrapBars.add(new ScrapGusto());
        return scrapBars;
    }
}

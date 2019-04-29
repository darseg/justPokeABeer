package com.darseg.justPokeABeer.service.scrap;

import com.darseg.justPokeABeer.dto.BarDTO;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Component
public interface ScrapBar {
	
	BarDTO getBar(Document doc);
}

package com.darseg.justPokeABeer.service;

import com.darseg.justPokeABeer.dto.BarDTO;
import com.darseg.justPokeABeer.service.scrap.ScrapBar;
import com.darseg.justPokeABeer.service.scrap.impl.ScrapGusto;
import lombok.AllArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@AllArgsConstructor
@Service
public class ManageService {
	
	final ScrapBar scrapBar = new ScrapGusto();
	
	
	public void load() {
		try {
			final Document doc = Jsoup.connect("http://vilna.gusto.by/")
					.userAgent("Chrome/4.0.249.0")
					.referrer("http://www.google.com")
					.get();
			
			final BarDTO bar = scrapBar.getBar(doc);
			
			System.out.println(bar);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
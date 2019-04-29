package com.darseg.justPokeABeer.service.scrap.impl;

import com.darseg.justPokeABeer.dto.BarDTO;
import com.darseg.justPokeABeer.service.scrap.ScrapBar;
import lombok.AllArgsConstructor;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;


@AllArgsConstructor
public class ScrapGusto implements ScrapBar {
	
	@Override
	public BarDTO getBar(final Document doc) {
		final Element content = doc.select("div.content").get(0);
		
		final String name = content.select("h1").text();
		final Elements restInfos = content.select("div.rest-info");
		final Element restInfo = restInfos.first();
		
		final BarDTO bar = new BarDTO(name);
		bar.setName(name);
		
		for(final Element elem: restInfo.select("div")) {
			final String title = elem.select("strong").text();
			
			switch (title){
				case "Адрес:":
					bar.setAddress(elem.childNodes().get(1).toString());
					
					break;
				case "Телефоны":
					System.out.println(elem.text());
			}
			
		}
		
		return bar;
	}
}

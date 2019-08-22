package com.darseg.justPokeABeer.service.scrap.impl;

import com.darseg.justPokeABeer.dto.BarDTO;
import com.darseg.justPokeABeer.service.scrap.ScrapBar;
import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class ScrapGusto implements ScrapBar {
	final String generalURL = "http://gusto.by/places/bars/";

	@Override
	public List<BarDTO> getAllBars() {
		final Stream<String> pages = getDocumentAfterJSExecution(generalURL).select("a.pagination_link")
				.stream().map(e -> generalURL.concat(e.text()));

		return pages.map(s -> getDocumentAfterJSExecution(s).select("a.placesPreview_link"))
				.flatMap(elements -> elements.stream().map(element -> getBar(element.attr("href"))))
				.collect(Collectors.toList());

	}

	@Override
	public BarDTO getBar(final String url) {
		final Document doc = getDocument(url);
		final Elements content = doc.select("div.wrapper");
		if (content.isEmpty()) {
			return null;
		}

		final BarDTO bar = new BarDTO(1L, "1", "1");

		processHeader(bar, content.select("div.place_header div.container"));

		return bar;
	}

	private void processHeader(final BarDTO bar, final Elements header) {
		if (header.isEmpty()) {
			return;
		}

		bar.setName(header.select("h1 span.h1").text());
		//bar.setCategory(header.select("p.place_titleDesc").text());
		bar.setAddress(header.select("p.modalMap_address").text());

	}
}

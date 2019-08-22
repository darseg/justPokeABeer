package com.darseg.justPokeABeer.service.scrap;

import com.darseg.justPokeABeer.dto.BarDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Component;

import org.openqa.selenium.*;

import java.io.IOException;
import java.util.List;

@Component
public interface ScrapBar {
	
	BarDTO getBar(String url);
	List<BarDTO> getAllBars();

	default Document getDocument(final String url, final String userAgent, final String referrer) throws IOException {
			return Jsoup.connect(url).userAgent(userAgent).referrer(referrer).get();
	}

	default Document getDocument(final String url) {
		try {
			return getDocument(url, "Chrome/4.0.249.0", "http://www.google.com");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	default Document getDocumentAfterJSExecution(final String url) {
		DesiredCapabilities settings = new DesiredCapabilities();
		settings.setJavascriptEnabled(true);
		settings.setCapability("userAgent", "Chrome/74.0.3729.169");
		settings.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "E:/Work/phantomjs-2.1.1-windows/bin/phantomjs.exe");
		WebDriver driver = new PhantomJSDriver(settings);
		driver.get(url);
		return Jsoup.parse(driver.getPageSource());
	}
}
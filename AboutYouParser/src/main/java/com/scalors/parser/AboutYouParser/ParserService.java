package com.scalors.parser.AboutYouParser;

import java.net.URL;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scalors.parser.AboutYouParser.model.AboutYouApiResponse;
import com.scalors.parser.AboutYouParser.model.ProductHolder;

public class ParserService {
	XmlWritter writter = new XmlWritter();

	public void parseJson(String url) {
		String productName;
		double initialPrice;
		double currentPrice;

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		AboutYouApiResponse mappedObject;
		try {
			mappedObject = objectMapper.readValue(new URL(url), AboutYouApiResponse.class);

			List<ProductHolder> data = mappedObject.getData();
			System.out.println("Amount of extracted products = " + data.size());

			writter.createOffersContainer();
			for (int i = 0; i < data.size(); i++) {
				productName = data.get(i).getAttributes().getName();
				initialPrice = data.get(i).getAttributes().getOldPrice();
				currentPrice = data.get(i).getAttributes().getPrice().getMin();
				writter.writeContent(productName, initialPrice, currentPrice);
			}
			writter.saveToFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Amount of triggered HTTP request = 1");
	}

	public ParserService() throws ParserConfigurationException {
		super();
	}
}
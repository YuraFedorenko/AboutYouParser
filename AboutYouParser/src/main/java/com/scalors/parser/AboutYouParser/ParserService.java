package com.scalors.parser.AboutYouParser;

import java.io.File;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scalors.parser.AboutYouParser.model.AboutYouApiResponse;
import com.scalors.parser.AboutYouParser.model.ProductHolder;

public class ParserService {

	public static final String xmlFilePath = "./outputFile/xmlfile.xml";

	
	public void parseJson(String url) {
		String productName;
		double initialPrice;
		double currentPrice;
		
		ObjectMapper objectMapper = new ObjectMapper();

		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		AboutYouApiResponse mappedObject;
		try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();
			Element root = document.createElement("Offers");
			document.appendChild(root);

			mappedObject = objectMapper.readValue(new URL(url), AboutYouApiResponse.class);

			 List<ProductHolder> data =  mappedObject.getData();
			System.out.println("Amount of extracted products = " + data.size());

			for (int i = 0; i < data.size(); i++) {
				productName = data.get(i).getAttributes().getName();
				initialPrice = data.get(i).getAttributes().getOldPrice();
				currentPrice = data.get(i).getAttributes().getPrice().getMin();
				
				Element offer = document.createElement("Offer");
				root.appendChild(offer);
				
				Element product = document.createElement("Product");
				product.appendChild(document.createTextNode(productName));
				offer.appendChild(product);
				
				Element initPrice = document.createElement("InitialPrice");
				initPrice.appendChild(document.createTextNode((initialPrice/100)+ ""));
				offer.appendChild(initPrice);
				
				Element priceCurrent = document.createElement("CurrentPrice");
				priceCurrent.appendChild(document.createTextNode((currentPrice/100)+ ""));
				offer.appendChild(priceCurrent);
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(xmlFilePath));

			transformer.transform(domSource, streamResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Amount of triggered HTTP request = 1");

	}
}
package com.scalors.parser.AboutYouParser;

import java.io.File;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

public class ParserService {

	public static final String xmlFilePath = "./outputFile/xmlfile.xml";

	@SuppressWarnings("unchecked")
	public void parseJson(String url) {

		Map<String, Object> embededMap;
		LinkedHashMap<String, Object> attributes;
		String name;
		ObjectMapper objectMapper = new ObjectMapper();

		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		Map<String, Object> mappedObject;
		try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();
			Element root = document.createElement("offers");
			document.appendChild(root);

			mappedObject = objectMapper.readValue(new URL(url), Map.class);

			List<?> data = (List<?>) mappedObject.get("data");
			System.out.println("Amount of extracted products = " + data.size());

			for (int i = 0; i < data.size(); i++) {
				embededMap = (Map<String, Object>) data.get(i);
				attributes = (LinkedHashMap<String, Object>) (embededMap.get("attributes"));
				name = (String) (attributes.get("name"));

				Element offer = document.createElement("offer");
				root.appendChild(offer);
				Element product = document.createElement("product");
				product.appendChild(document.createTextNode(name));
				offer.appendChild(product);
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
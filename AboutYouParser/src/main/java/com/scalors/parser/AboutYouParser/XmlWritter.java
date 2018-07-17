package com.scalors.parser.AboutYouParser;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlWritter {

	public static final String xmlFilePath = "./outputFile/xmlfile.xml";

	DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
	Document document = documentBuilder.newDocument();
	Element root;

	public void createOffersContainer() {
		root = document.createElement("Offers");
		document.appendChild(root);
	}

	public void writeContent(String productName, double initialPrice, double currentPrice) {
		Element offer = document.createElement("Offer");
		root.appendChild(offer);

		Element product = document.createElement("Product");
		product.appendChild(document.createTextNode(productName));
		offer.appendChild(product);

		Element initPrice = document.createElement("InitialPrice");
		initPrice.appendChild(document.createTextNode((initialPrice / 100) + ""));
		offer.appendChild(initPrice);

		Element priceCurrent = document.createElement("CurrentPrice");
		priceCurrent.appendChild(document.createTextNode((currentPrice / 100) + ""));
		offer.appendChild(priceCurrent);
	}

	public void saveToFile() {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer;
		try {
			transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(xmlFilePath));

			transformer.transform(domSource, streamResult);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}

	public XmlWritter() throws ParserConfigurationException {
		super();
	}
}
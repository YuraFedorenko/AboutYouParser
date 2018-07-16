package com.scalors.parser.AboutYouParser.model;

public class Relationships {
	
	Product brand;

	public Product getBrand() {
		return brand;
	}

	public void setBrand(Product brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return String.format("Relationships [brand=%s]", brand);
	}
}

package com.scalors.parser.AboutYouParser.model;

public class Attributes {
	
	String name;
	Price price;
	double oldPrice;
	ProductName attributes;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}
	@Override
	public String toString() {
		return String.format("Attributes [name=%s, price=%s, oldPrice=%s]", name, price, oldPrice);
	}
	public ProductName getAttributes() {
		return attributes;
	}
	public void setAttributes(ProductName attributes) {
		this.attributes = attributes;
	}
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
	
	
}

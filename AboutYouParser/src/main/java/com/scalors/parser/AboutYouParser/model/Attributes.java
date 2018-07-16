package com.scalors.parser.AboutYouParser.model;

public class Attributes {
	
	String name;
	Price price;
	String oldPrice;
	ProductName attributes;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Price getCampaignPrice() {
		return price;
	}
	public void setCampaignPrice(Price campaignPrice) {
		this.price = campaignPrice;
	}
	public String getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(String oldPrice) {
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
	
	
}

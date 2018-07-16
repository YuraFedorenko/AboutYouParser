package com.scalors.parser.AboutYouParser.model;

public class Product {
	
	ProductName data;

	public ProductName getData() {
		return data;
	}

	public void setData(ProductName data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return String.format("Product [data=%s]", data);
	}
}

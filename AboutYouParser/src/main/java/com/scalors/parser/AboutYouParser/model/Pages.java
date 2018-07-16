package com.scalors.parser.AboutYouParser.model;

public class Pages {
	
	int total;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return String.format("Pages [total=%s]", total);
	}
	
}

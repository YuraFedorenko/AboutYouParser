package com.scalors.parser.AboutYouParser.model;

public class ProductHolder {
	
	private Attributes attributes;
	private Relationships relationships;
	
	public Attributes getAttributes() {
		return attributes;
	}
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}
	public Relationships getRelationships() {
		return relationships;
	}
	public void setRelationships(Relationships relationships) {
		this.relationships = relationships;
	}
	@Override
	public String toString() {
		return String.format("ProductHolder [attributes=%s, relationships=%s]", attributes, relationships);
	}

}

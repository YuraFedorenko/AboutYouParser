package com.scalors.parser.AboutYouParser.model;

import java.util.Map;

public class IncludedAttributesHolder {
	
	Map<String,Brand> attributes;

	public Map<String, Brand> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Brand> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		return String.format("Attributes [attributes=%s]", attributes);
	}
}

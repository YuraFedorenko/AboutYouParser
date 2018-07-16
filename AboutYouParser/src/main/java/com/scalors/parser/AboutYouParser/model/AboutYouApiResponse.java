package com.scalors.parser.AboutYouParser.model;

import java.util.List;

public class AboutYouApiResponse {

	private List<ProductHolder> data;
	private IncludedAttributesHolder included;
	private Pagination meta;

	public List<ProductHolder> getData() {
		return data;
	}

	public void setData(List<ProductHolder	> data) {
		this.data = data;
	}

	public IncludedAttributesHolder getIncluded() {
		return included;
	}

	public void setIncluded(IncludedAttributesHolder included) {
		this.included = included;
	}

	public Pagination getMeta() {
		return meta;
	}

	public void setMeta(Pagination meta) {
		this.meta = meta;
	}
	@Override
	public String toString() {
		return String.format("AboutYouApiResponse [data=%s, \n included=%s]", data, included);
	}
	}

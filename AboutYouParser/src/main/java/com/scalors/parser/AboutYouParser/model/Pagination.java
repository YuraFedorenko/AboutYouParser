package com.scalors.parser.AboutYouParser.model;

public class Pagination {

	Pages pagination;

	public Pages getPagination() {
		return pagination;
	}

	public void setPagination(Pages pagination) {
		this.pagination = pagination;
	}

	@Override
	public String toString() {
		return String.format("Pagination [pagination=%s]", pagination);
	}
	
}

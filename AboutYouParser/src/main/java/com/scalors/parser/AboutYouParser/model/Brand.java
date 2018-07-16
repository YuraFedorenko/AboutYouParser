package com.scalors.parser.AboutYouParser.model;

public class Brand {

		String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return String.format("Brand [name=%s]", name);
		}
}

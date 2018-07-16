package com.scalors.parser.AboutYouParser.model;

public class Price {

		String min;

		public String getMin() {
			return min;
		}

		public void setMin(String min) {
			this.min = min;
		}

		@Override
		public String toString() {
			return String.format("Price [min=%s]", min);
		}
		
}

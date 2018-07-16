package com.scalors.parser.AboutYouParser.model;

public class Price {

		double min;

		public double getMin() {
			return min;
		}

		public void setMin(double min) {
			this.min = min;
		}

		@Override
		public String toString() {
			return String.format("Price [min=%s]", min);
		}
		
}

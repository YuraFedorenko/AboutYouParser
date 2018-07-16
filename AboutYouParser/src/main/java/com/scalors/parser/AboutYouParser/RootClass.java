package com.scalors.parser.AboutYouParser;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class RootClass {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException{
		long startTime = new Date().getTime();
		
		String URL = String.format("https://api.aboutyou.de/search/%s?keyedIncludes=true&version=41&page[size]=10000&page[number]=1&sort=topseller&"
				+ "filter[category]=20202&gender=male&include=brand,defaultImage,defaultVariant,modelImage,products.defaultImage,products.modelImage,"
				+ "products.productStreamSizes,products.brand,products.defaultVariant", args[0]);
		ParserService parserService = new ParserService();
		parserService.parseJson(URL);
		
		long endTime = new Date().getTime();
		System.out.println("Run time = "+(endTime-startTime)+" ms");
		
	}
}

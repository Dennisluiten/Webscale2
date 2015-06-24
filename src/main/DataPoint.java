package main;

public class DataPoint {
	int userID;
	String platfrom;
	String language;
	int age;
	String searchEngine;
	int header;
	String adtype;
	String color;
	int productID;
	int price;
	boolean response;
	
	public DataPoint(int userID, String platfrom, String language, int age,
			String searchEngine, int header, String adtype, String color,
			int productID, int price, boolean response) {
		this.userID = userID;
		this.platfrom = platfrom;
		this.language = language;
		this.age = age;
		this.searchEngine = searchEngine;
		this.header = header;
		this.adtype = adtype;
		this.color = color;
		this.productID = productID;
		this.price = price;
		this.response = response;
	}

	public DataPoint(int userID, String platfrom, String language, int age,
			String searchEngine) {
		this.userID = userID;
		this.platfrom = platfrom;
		this.language = language;
		this.age = age;
		this.searchEngine = searchEngine;
	}
	
	
}

package main;

import java.util.Random;

import enums.Adtype;
import enums.Color;
import enums.Language;
import enums.Platform;
import enums.SearchEngine;

public class DataPoint {
	int runID				  = 0;
	int i					  = 0;
	int userID                = 0;
	Platform platform         = Platform.mobile;
	Language language         = Language.NA;
	int age                   = -1;
	SearchEngine searchEngine = SearchEngine.NA;
	int header                = -1; // 5 - 15 - 35
	Adtype adtype             = Adtype.BANNER;
	Color color               = Color.BLACK;
	int productID             = -1;		// 10 - 25
	int price                 = -1;     // 0 - 50  -> 10-40
	boolean success           = false;
	
	private static Random random = new Random(System.currentTimeMillis());
	
	public DataPoint (){
		System.out.println("Creating empty datapoint.");
	}
	
	public DataPoint(int userID, Platform platform, Language language, int age,
			SearchEngine searchEngine, int header, Adtype adtype, Color color,
			int productID, int price, boolean response, int runID, int i) {
		this.userID = userID;
		this.platform = platform;
		this.language = language;
		this.age = age;
		this.searchEngine = searchEngine;
		this.header = header;
		this.adtype = adtype;
		this.color = color;
		this.productID = productID;
		this.price = price;
		this.success = response;
		this.runID = runID;
		this.i = i;
	}

	public DataPoint(int userID, Platform platform, Language language, int age,
			SearchEngine searchEngine, int runID, int i) {
		this.userID = userID;
		this.platform = platform;
		this.language = language;
		this.age = age;
		this.searchEngine = searchEngine;
		this.runID = runID;
		this.i = i;
//		System.out.println("Adding random arguments to context.");
		header = randomHeader();
		adtype = Adtype.values()[random.nextInt(3)];
		color = Color.values()[random.nextInt(5)];
		productID = random.nextInt(16)+10;
		price = random.nextInt(41) + 10;
	}
	
	public String toCsvString(){
		return String.format("%d,%s,%s,%d,%s,%d,%s,%s,%d,%d,%b,%d,%d\n", userID, platform, language, age, searchEngine, header, adtype, color, productID, price, success, runID, i);
	}
	
	public int randomHeader(){
		int r = random.nextInt(3);
		if(r == 0)
			return 5;
		else if(r == 1)
			return 15;
		else 
			return 35;
	}
	
	public int reward (){
//		System.out.println(String.format("Sucess: %b, price: %d", success, price));
		if(success)
			return price;
		else
			return 0;
	}
	
	
}

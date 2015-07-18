package main;

import java.util.LinkedList;

import enums.Adtype;
import enums.Language;
import enums.MyColor;
import enums.Platform;
import enums.SearchEngine;

public class Filter {
	boolean header5;
	boolean header15;
	boolean header35;
	boolean adBanner;
	boolean adSky;
	boolean adSquare;
	boolean green;
	boolean blue;
	boolean red;
	boolean black;
	boolean white;
	boolean [] productID = new boolean [26];
	boolean [] price = new boolean [51];
	boolean total;
	
	boolean [] userID = new boolean [5000];
	boolean OSX;
	boolean windows;
	boolean linux;
	boolean mobile;
	boolean EN;
	boolean NL;
	boolean GE;
	boolean LangNA;
	boolean [] age = new boolean [110];
	boolean google;
	boolean bing;
	
	
	public Filter(){
		
	}	
	
	public static LinkedList<DataPoint> filterSENA(LinkedList<DataPoint> data){	
		LinkedList<DataPoint> filteredOnes = new LinkedList<DataPoint>();
		for(DataPoint dp:data){
			if(dp.searchEngine == SearchEngine.NA)
				filteredOnes.add(dp);
		}		
		return filteredOnes;
	}
	
	
	public static LinkedList<DataPoint> filterBing(LinkedList<DataPoint> data){	
		LinkedList<DataPoint> filteredOnes = new LinkedList<DataPoint>();
		for(DataPoint dp:data){
			if(dp.searchEngine == SearchEngine.Bing)
				filteredOnes.add(dp);
		}		
		return filteredOnes;
	}
	
	
	public static LinkedList<DataPoint> filterGoogle(LinkedList<DataPoint> data){	
		LinkedList<DataPoint> filteredOnes = new LinkedList<DataPoint>();
		for(DataPoint dp:data){
			if(dp.searchEngine == SearchEngine.Google)
				filteredOnes.add(dp);
		}		
		return filteredOnes;
	}
	
	
	public static LinkedList<DataPoint> filterAge(LinkedList<DataPoint> data, int age){	
		LinkedList<DataPoint> filteredOnes = new LinkedList<DataPoint>();
		for(DataPoint dp:data){
			if(dp.age == age)
				filteredOnes.add(dp);
		}		
		return filteredOnes;
	}
	
	
	public static LinkedList<DataPoint> filterLangNA(LinkedList<DataPoint> data){	
		LinkedList<DataPoint> filteredOnes = new LinkedList<DataPoint>();
		for(DataPoint dp:data){
			if(dp.language == Language.NA)
				filteredOnes.add(dp);
		}		
		return filteredOnes;
	}
	
	
	public static LinkedList<DataPoint> filterNL(LinkedList<DataPoint> data){	
		LinkedList<DataPoint> filteredOnes = new LinkedList<DataPoint>();
		for(DataPoint dp:data){
			if(dp.language ==Language.NL)
				filteredOnes.add(dp);
		}		
		return filteredOnes;
	}
	
	public static LinkedList<DataPoint> filterGE(LinkedList<DataPoint> data){	
		LinkedList<DataPoint> filteredOnes = new LinkedList<DataPoint>();
		for(DataPoint dp:data){
			if(dp.language == Language.GE)
				filteredOnes.add(dp);
		}		
		return filteredOnes;
	}
	
	
	public static LinkedList<DataPoint> filterEN(LinkedList<DataPoint> data){	
		LinkedList<DataPoint> filteredOnes = new LinkedList<DataPoint>();
		for(DataPoint dp:data){
			if(dp.language == Language.EN)
				filteredOnes.add(dp);
		}		
		return filteredOnes;
	}
	
	
	public static LinkedList<DataPoint> filterMobile(LinkedList<DataPoint> data){	
		LinkedList<DataPoint> filteredOnes = new LinkedList<DataPoint>();
		for(DataPoint dp:data){
			if(dp.platform == Platform.mobile)
				filteredOnes.add(dp);
		}		
		return filteredOnes;
	}
	
	public static LinkedList<DataPoint> filterLinux(LinkedList<DataPoint> data){	
		LinkedList<DataPoint> filteredOnes = new LinkedList<DataPoint>();
		for(DataPoint dp:data){
			if(dp.platform == Platform.Linux)
				filteredOnes.add(dp);
		}		
		return filteredOnes;
	}
	
	
	public static LinkedList<DataPoint> filterWindows(LinkedList<DataPoint> data){	
		LinkedList<DataPoint> filteredOnes = new LinkedList<DataPoint>();
		for(DataPoint dp:data){
			if(dp.platform == Platform.Windows)
				filteredOnes.add(dp);
		}		
		return filteredOnes;
	}
	
	public static LinkedList<DataPoint> filterOSX(LinkedList<DataPoint> data){	
		LinkedList<DataPoint> filteredOnes = new LinkedList<DataPoint>();
		for(DataPoint dp:data){
			if(dp.platform == Platform.OSX)
				filteredOnes.add(dp);
		}		
		return filteredOnes;
	}
	
	public static LinkedList<DataPoint> filterUserID(LinkedList<DataPoint> data, int id){	
		LinkedList<DataPoint> filteredOnes = new LinkedList<DataPoint>();
		for(DataPoint dp:data){
			if(dp.userID == id)
				filteredOnes.add(dp);
		}		
		return filteredOnes;
	}
	
	public static LinkedList<DataPoint> filterPrice(LinkedList<DataPoint> data, int price){	
		LinkedList<DataPoint> filteredOnes = new LinkedList<DataPoint>();
		for(DataPoint dp:data){
			if(dp.price == price)
				filteredOnes.add(dp);
		}		
		return filteredOnes;
	}
	
	public static LinkedList<DataPoint> filterProductID(LinkedList<DataPoint> data, int id){	
		LinkedList<DataPoint> filteredOnes = new LinkedList<DataPoint>();
		for(DataPoint dp:data){
			if(dp.productID == id)
				filteredOnes.add(dp);
		}		
		return filteredOnes;
	}
	
	public static LinkedList<DataPoint> filterBlack(LinkedList<DataPoint> data){	
		LinkedList<DataPoint> filteredOnes = new LinkedList<DataPoint>();
		for(DataPoint dp:data){
			if(dp.color == MyColor.BLACK)
				filteredOnes.add(dp);
		}		
		return filteredOnes;
	}
	
	public static LinkedList<DataPoint> filterRed(LinkedList<DataPoint> data){	
		LinkedList<DataPoint> filteredOnes = new LinkedList<DataPoint>();
		for(DataPoint dp:data){
			if(dp.color == MyColor.RED)
				filteredOnes.add(dp);
		}		
		return filteredOnes;
	}
	
	public static LinkedList<DataPoint> filterWhite(LinkedList<DataPoint> data){	
		LinkedList<DataPoint> filteredOnes = new LinkedList<DataPoint>();
		for(DataPoint dp:data){
			if(dp.color == MyColor.WHITE)
				filteredOnes.add(dp);
		}		
		return filteredOnes;
	}
	
	public static LinkedList<DataPoint> filterBlue(LinkedList<DataPoint> data){	
		LinkedList<DataPoint> filteredOnes = new LinkedList<DataPoint>();
		for(DataPoint dp:data){
			if(dp.color == MyColor.BLUE)
				filteredOnes.add(dp);
		}		
		return filteredOnes;
	}
	
	public static LinkedList<DataPoint> filterGreen(LinkedList<DataPoint> data){	
		LinkedList<DataPoint> filteredOnes = new LinkedList<DataPoint>();
		for(DataPoint dp:data){
			if(dp.color == MyColor.GREEN)
				filteredOnes.add(dp);
		}		
		return filteredOnes;
	}
	
	public static LinkedList<DataPoint> filterAdSquare(LinkedList<DataPoint> data){	
		LinkedList<DataPoint> filteredOnes = new LinkedList<DataPoint>();
		for(DataPoint dp:data){
			if(dp.adtype == Adtype.SQUARE)
				filteredOnes.add(dp);
		}		
		return filteredOnes;
	}
	
	public static LinkedList<DataPoint> filterAdSky(LinkedList<DataPoint> data){	
		LinkedList<DataPoint> filteredOnes = new LinkedList<DataPoint>();
		for(DataPoint dp:data){
			if(dp.adtype == Adtype.SKYSCRAPER)
				filteredOnes.add(dp);
		}		
		return filteredOnes;
	}
	
	public static LinkedList<DataPoint> filterAdBanner(LinkedList<DataPoint> data){	
		LinkedList<DataPoint> filteredOnes = new LinkedList<DataPoint>();
		for(DataPoint dp:data){
			if(dp.adtype == Adtype.BANNER)
				filteredOnes.add(dp);
		}		
		return filteredOnes;
	}
	
	
	public static LinkedList<DataPoint> filterHeader35(LinkedList<DataPoint> data){	
		LinkedList<DataPoint> filteredOnes = new LinkedList<DataPoint>();
		for(DataPoint dp:data){
			if(dp.header == 35)
				filteredOnes.add(dp);
		}		
		return filteredOnes;
	}
	
	public static LinkedList<DataPoint> filterHeader15(LinkedList<DataPoint> data){	
		LinkedList<DataPoint> filteredOnes = new LinkedList<DataPoint>();
		for(DataPoint dp:data){
			if(dp.header == 15)
				filteredOnes.add(dp);
		}		
		return filteredOnes;
	}
	
	public static LinkedList<DataPoint> filterHeader5(LinkedList<DataPoint> data){	
		LinkedList<DataPoint> filteredOnes = new LinkedList<DataPoint>();
		for(DataPoint dp:data){
			if(dp.header == 5)
				filteredOnes.add(dp);
		}		
		return filteredOnes;
	}
	
	public static LinkedList<DataPoint> filterNone(LinkedList<DataPoint> data){	
		return data;
	}

	
	
}

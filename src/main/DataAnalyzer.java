package main;

import java.util.LinkedList;

public class DataAnalyzer {

	//Rewards
	Average header5 = new Average("Header5");
	Average header15 = new Average("Header15");
	Average header35 = new Average("Header35");
	Average adBanner = new Average("Ad Banner");
	Average adSky = new Average("Ad Skyscraper");
	Average adSquare = new Average("Ad Square");
	Average green = new Average("Green");
	Average blue = new Average("Blue");
	Average red = new Average("Red");
	Average black = new Average("Black");
	Average white = new Average("White");
	Average [] productID = new Average [26];
	Average [] price = new Average [51];
	Average total = new Average("Total");

	Average [] userID = new Average [5000];
	Average OSX = new Average ("OSX");
	Average windows = new Average ("Windows");
	Average linux= new Average ("Linux");
	Average mobile = new Average ("Mobile");
	Average EN= new Average ("EN");
	Average NL= new Average ("NL");
	Average GE = new Average ("GE");
	Average LangNA= new Average ("Lang N/A");
	Average [] age = new Average [110];
	Average google = new Average ("Google");
	Average bing = new Average ("Bing");
	Average SENA= new Average ("Searcher N/A");

	public DataAnalyzer(){
		for(int i = 0; i< productID.length; i++)
			productID[i] = new Average(String.format("ProductID=%d", i));
		for(int i = 0; i< price.length; i++)
			price[i] = new Average(String.format("Price=%d", i));		
		for(int i = 0; i< userID.length; i++)
			userID[i] = new Average(String.format("UserID=%d", i));
		for(int i = 0; i< age.length; i++)
			age[i] = new Average(String.format("Age=%d", i));
	}

	public void analyseContextSimple(LinkedList<DataPoint> data){
		for(DataPoint dp: data){
			userID[dp.userID].streamingAverage(dp.reward);
			switch(dp.platform){
			case OSX: OSX.streamingAverage(dp.reward); break;
			case Windows: windows.streamingAverage(dp.reward); break;
			case Linux: linux.streamingAverage(dp.reward); break;
			case mobile: mobile.streamingAverage(dp.reward); break;
			}
			switch(dp.language){
			case EN: EN.streamingAverage(dp.reward); break;
			case GE: GE.streamingAverage(dp.reward); break;
			case NL: NL.streamingAverage(dp.reward); break;
			case NA: LangNA.streamingAverage(dp.reward); break;
			}
			switch(dp.searchEngine){
			case Google: google.streamingAverage(dp.reward); break;
			case Bing: bing.streamingAverage(dp.reward); break;
			case NA: SENA.streamingAverage(dp.reward); break;
			}
			age[dp.age].streamingAverage(dp.reward);

		}
	}

	public void analyseArgumentsSimple(LinkedList<DataPoint> data){
		for(DataPoint dp: data){
			switch(dp.header){
			case 5: header5.streamingAverage(dp.reward); break;
			case 15: header15.streamingAverage(dp.reward); break;
			case 35: header35.streamingAverage(dp.reward); break;
			}
			switch (dp.adtype){
			case BANNER: adBanner.streamingAverage(dp.reward); break;
			case SKYSCRAPER: adSky.streamingAverage(dp.reward); break;
			case SQUARE: adSquare.streamingAverage(dp.reward); break;
			}
			switch(dp.color){
			case BLACK: black.streamingAverage(dp.reward); break;
			case BLUE: blue.streamingAverage(dp.reward); break;
			case GREEN: green.streamingAverage(dp.reward); break;
			case RED: red.streamingAverage(dp.reward); break;
			case WHITE: white.streamingAverage(dp.reward); break;
			}
			productID[dp.productID].streamingAverage(dp.reward);
			price[dp.price].streamingAverage(dp.reward);
			total.streamingAverage(dp.reward);

		}
	}

	public void printAveragesUserID(){
		for(Average a: userID)
			a.print();
	}

	public void printAveragesAge(){
		for(Average a: age)
			a.print();
	}

	public void printAveragesPlatform(){
		OSX.print();
		windows.print();
		linux.print();
		mobile.print();
	}

	public void printAveragesLang(){
		EN.print();
		NL.print();
		GE.print();
		LangNA.print();
	}

	public void printAveragesSE(){
		google.print();
		bing.print();
		SENA.print();
	}

	public void printAveragesAllContext(){
		printAveragesUserID();
		printAveragesAge();
		printAveragesPlatform();
		printAveragesLang();
		printAveragesSE();
		total.print();
	}

	public void printAveragesHeader(){
		header5.print();
		header15.print();
		header35.print();
	}

	public void printAveragesAdType(){
		adBanner.print();
		adSky.print();
		adSquare.print();
	}

	public void printAveragesColor(){
		green.print();
		blue.print();
		red.print();
		black.print();
		white.print();
	}

	public void printAveragesProductID(){
		for(Average a: productID)
			a.print();
	}

	public void printAveragesPrice(){
		for (Average a: price)
			a.print();
	}

	public void printAveragesAllArguments(){
		printAveragesHeader();
		printAveragesAdType();
		printAveragesColor();
		printAveragesProductID();
		printAveragesPrice();
		total.print();
	}
	
	public void printTotal(){
		total.print();
	}

}

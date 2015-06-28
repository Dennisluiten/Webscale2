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
	
	public DataAnalyzer(){
		for(int i = 0; i< productID.length; i++)
			productID[i] = new Average(String.format("ProductID=%d", i));
		for(int i = 0; i< price.length; i++)
			price[i] = new Average(String.format("Price=%d", i));
		
	}

	public void analyseArgumentsSimple(LinkedList<DataPoint> data){
		for(DataPoint dp: data){
			switch(dp.header){
			case 5: header5.streamingAverage(dp.reward()); break;
			case 15: header15.streamingAverage(dp.reward()); break;
			case 35: header35.streamingAverage(dp.reward()); break;
			}
			switch (dp.adtype){
			case BANNER: adBanner.streamingAverage(dp.reward()); break;
			case SKYSCRAPER: adSky.streamingAverage(dp.reward()); break;
			case SQUARE: adSquare.streamingAverage(dp.reward()); break;
			}
			switch(dp.color){
			case BLACK: black.streamingAverage(dp.reward()); break;
			case BLUE: blue.streamingAverage(dp.reward()); break;
			case GREEN: green.streamingAverage(dp.reward()); break;
			case RED: red.streamingAverage(dp.reward()); break;
			case WHITE: white.streamingAverage(dp.reward()); break;
			}
			productID[dp.productID].streamingAverage(dp.reward());
			price[dp.price].streamingAverage(dp.reward());
			total.streamingAverage(dp.reward());
			
		}
	}
	
	public void printAverages(){
		header5.print();
		header15.print();
		header35.print();
		adBanner.print();
		adSky.print();
		adSquare.print();
		green.print();
		blue.print();
		red.print();
		black.print();
		white.print();
		for(Average a: productID)
			a.print();
		for (Average a: price)
			a.print();
		total.print();
	}

}

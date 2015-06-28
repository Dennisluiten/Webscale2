package main;

import java.util.LinkedList;

public class DataAnalyzer {
	
	//Rewards
	Average header5 = new Average();
	Average header15 = new Average();
	Average header35 = new Average();
	Average adBanner = new Average();
	Average adSky = new Average();
	Average adSquare = new Average();
	Average green = new Average();
	Average blue = new Average();
	Average red = new Average();
	Average black = new Average();
	Average white = new Average();
	Average [] productID = new Average [26];
	Average [] price = new Average [51];
	
	public DataAnalyzer(){
		
	}

	public void analyseArgumentsSimple(LinkedList<DataPoint> data){

		for(DataPoint dp: data){
			switch(dp.header){
			case 5: header5.streamingAverage(dp.reward()); break;
			case 15: header15.streamingAverage(dp.reward()); break;
			case 35: header15.streamingAverage(dp.reward()); break;
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
			
		}
	}

}

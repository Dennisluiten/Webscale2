package main;

public class Betas {
	double header5;
	double header15;
	double header35;
	double adBanner;
	double adSky;
	double adSquare;
	double green;
	double blue;
	double red;
	double black;
	double white;
	double productID;
	double price;
	
	public int bestPriceEstimate(DataPoint dp){
		Double estimate = 0.0;
		switch(dp.header){
		case 5: estimate += header5; break;
		case 15: estimate += header15; break;
		case 35: estimate += header35; break;
		}
		switch (dp.adtype){
		case BANNER: estimate += adBanner; break;
		case SKYSCRAPER: estimate += adSky; break;
		case SQUARE: estimate += adSquare; break;
		}
		switch(dp.color){
		case BLACK: estimate += black; break;
		case BLUE: estimate += blue; break;
		case GREEN: estimate += green; break;
		case RED: estimate += red; break;
		case WHITE: estimate += white; break;
		}
		estimate += dp.productID*productID;
		estimate += dp.price*price;		
		return estimate.intValue();
	}
	
	
	
	public void update(){
		
	}
	
	
}

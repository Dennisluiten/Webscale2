package main;

import enums.Adtype;
import enums.MyColor;

public class EstimatorSet {
	SuccessEstimate header5 = new SuccessEstimate("Header5");
	SuccessEstimate header15 = new SuccessEstimate("Header15");
	SuccessEstimate header35 = new SuccessEstimate("Header35");
	SuccessEstimate adBanner = new SuccessEstimate("Ad Banner");
	SuccessEstimate adSky = new SuccessEstimate("Ad Skyscraper");
	SuccessEstimate adSquare = new SuccessEstimate("Ad Square");
	SuccessEstimate green = new SuccessEstimate("GREEN");
	SuccessEstimate blue = new SuccessEstimate("BLUE");
	SuccessEstimate red = new SuccessEstimate("RED");
	SuccessEstimate black = new SuccessEstimate("BLACK");
	SuccessEstimate white = new SuccessEstimate("WHITE");
	SuccessEstimate [] productID = new SuccessEstimate [26];
	SuccessEstimate [] price = new SuccessEstimate [51];
	SuccessEstimate total = new SuccessEstimate("Total");
	
	public EstimatorSet(){
		for(int i = 0; i< productID.length; i++)
			productID[i] = new SuccessEstimate(String.format("ProductID=%d", i));
		for(int i = 0; i< price.length; i++)
			price[i] = new SuccessEstimate(String.format("Price=%d", i));		
	}
	
	public DataPoint propose(DataPoint context){
		int header = bestHeader();
		Adtype ad = bestAd();
		MyColor color = bestColor();
		int pID = bestPID();
		int price = bestPrice();
		context.addArguments(header, ad, color, pID, price);
		return context;
	}
	
	private int bestPrice() {
		SuccessEstimate best = price[0];
		for(int i = 1;i < price.length; i++)
			best = pickBest(best, price[i]);
		String s = best.name.substring(6);
		return Integer.parseInt(s);
	}

	private int bestPID() {
		SuccessEstimate best = productID[0];
		for(int i = 1;i < productID.length; i++)
			best = pickBest(best, productID[i]);
		String s = best.name.substring(10);
		return Integer.parseInt(s);
	}

	private MyColor bestColor() {
		SuccessEstimate best = green;
		best = pickBest(best, blue);
		best = pickBest(best, red);
		best = pickBest(best, black);
		best = pickBest(best, white);
		return MyColor.valueOf(best.name);
	}

	private Adtype bestAd(){
		if(adBanner.successRate() > adSky.successRate()){
			if(adBanner.successRate() > adSquare.successRate()){
				return Adtype.BANNER;
			}else{
				return Adtype.SKYSCRAPER;
			}
		}else{
			if(adSky.successRate() > adSquare.successRate()){
				return Adtype.SKYSCRAPER;
			}else{
				return Adtype.SQUARE;
			}
			
		}
	}
	
	private int bestHeader(){
		if(header5.successRate() > header15.successRate()){
			if(header5.successRate() > header35.successRate()){
				return 5;
			}else{
				return 35;
			}
		}else{
			if(header15.successRate() > header35.successRate()){
				return 15;
			}else{
				return 35;
			}
			
		}
	}
	
	
	public void update(DataPoint dp){
		switch(dp.header){
		case 5: header5.update(dp.success); break;
		case 15: header15.update(dp.success); break;
		case 35: header35.update(dp.success); break;
		}
		switch (dp.adtype){
		case BANNER: adBanner.update(dp.success); break;
		case SKYSCRAPER: adSky.update(dp.success); break;
		case SQUARE: adSquare.update(dp.success); break;
		}
		switch(dp.color){
		case BLACK: black.update(dp.success); break;
		case BLUE: blue.update(dp.success); break;
		case GREEN: green.update(dp.success); break;
		case RED: red.update(dp.success); break;
		case WHITE: white.update(dp.success); break;
		}
		productID[dp.productID].update(dp.success);
		price[dp.price].update(dp.success);
		total.update(dp.success);
	}
	
	public void print(){
		System.out.println("Printing Estimator");
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
		for(SuccessEstimate e: productID)
			e.print();
		for(SuccessEstimate e: price)
			e.print();
		total.print();
	}
	
	private SuccessEstimate pickBest(SuccessEstimate est1, SuccessEstimate est2){
		if(est1.successRate() > est2.successRate())
			return est1;
		return est2;
	}
}

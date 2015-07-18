package main;

import enums.Adtype;
import enums.MyColor;

public class EstimatorSet {
	LeakySuccessEstimate header5 = new LeakySuccessEstimate("Header5");
	LeakySuccessEstimate header15 = new LeakySuccessEstimate("Header15");
	LeakySuccessEstimate header35 = new LeakySuccessEstimate("Header35");
	LeakySuccessEstimate adBanner = new LeakySuccessEstimate("Ad Banner");
	LeakySuccessEstimate adSky = new LeakySuccessEstimate("Ad Skyscraper");
	LeakySuccessEstimate adSquare = new LeakySuccessEstimate("Ad Square");
	LeakySuccessEstimate green = new LeakySuccessEstimate("GREEN");
	LeakySuccessEstimate blue = new LeakySuccessEstimate("BLUE");
	LeakySuccessEstimate red = new LeakySuccessEstimate("RED");
	LeakySuccessEstimate black = new LeakySuccessEstimate("BLACK");
	LeakySuccessEstimate white = new LeakySuccessEstimate("WHITE");
	LeakySuccessEstimate [] productID = new LeakySuccessEstimate [26];
	LeakySuccessEstimate [] price = new LeakySuccessEstimate [51];
	LeakySuccessEstimate total = new LeakySuccessEstimate("Total");
	
	public EstimatorSet(){
		for(int i = 0; i< productID.length; i++)
			productID[i] = new LeakySuccessEstimate(String.format("ProductID=%d", i));
		for(int i = 0; i< price.length; i++)
			price[i] = new LeakySuccessEstimate(String.format("Price=%d", i));		
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
	
	public void printBestArguments(){
		int header = bestHeader();
		Adtype ad = bestAd();
		MyColor color = bestColor();
		int pID = bestPID();
		int price = bestPrice();
		
		System.out.println(String.format("Header: %d, Adtype: %-10s, Color: %-8s, Product ID: %d, Price: %d", header, ad.toString(), color.toString(), pID, price));
	}
	
	private int bestPrice() {
		LeakySuccessEstimate best = price[0];
		int bestPrice = 0;
		for(int i = 1; i < price.length; i++){
			double estRewardBest = best.successRate()*bestPrice;
			double estRewardNext = price[i].successRate()*i;
			if(estRewardNext > estRewardBest){
				best = price[i];
				bestPrice = i;
			}	
		}
		return bestPrice;
	}

	private int bestPID() {
		LeakySuccessEstimate best = productID[0];
		for(int i = 1;i < productID.length; i++)
			best = pickBest(best, productID[i]);
		String s = best.name.substring(10);
		return Integer.parseInt(s);
	}

	private MyColor bestColor() {
		LeakySuccessEstimate best = green;
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
		for(LeakySuccessEstimate e: productID)
			e.print();
		for(LeakySuccessEstimate e: price)
			e.print();
		total.print();
	}
	
	private LeakySuccessEstimate pickBest(LeakySuccessEstimate est1, LeakySuccessEstimate est2){
		if(est1.successRate() > est2.successRate())
			return est1;
		return est2;
	}
}

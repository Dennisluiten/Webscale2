package main;

public class Average {
	private double average = 0;
	private int n = 0, fails = 0;
	private String name;
	
	public Average (String name){
		this.name = name;
	}
	
	public void streamingAverage(int nextDataPoint){
		n++;
		average += (nextDataPoint-average)/n;
		if(nextDataPoint == 0){
			fails++;
		}
	}
	
	public void print(){
		if(!(name.contains("=") && n == 0))
		System.out.println(String.format("%-15s:  Average=%.3f     n=%d     success rate=%.3f", name, average, n, 1-fails*1.0/n));
	}
	
	
}

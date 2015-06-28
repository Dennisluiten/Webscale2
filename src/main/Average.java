package main;

public class Average {
	private double average = 0;
	private int n = 0;
	private String name;
	
	public Average (String name){
		this.name = name;
	}
	
	public void streamingAverage(int nextDataPoint){
		n++;
		average += (nextDataPoint-average)/n;
	}
	
	public void print(){
		System.out.println(String.format("%s:  Average=%.3f  n=%d ", name, average, n));
	}
}

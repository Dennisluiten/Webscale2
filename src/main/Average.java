package main;

public class Average {
	int average = 0, n = 0;
	
	public Average (){
		
	}
	
	public void streamingAverage(int nextDataPoint){
		n++;
		average += (nextDataPoint-average)/n;
	}
}

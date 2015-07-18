package main;

public class LeakySuccessEstimate {
	String name;
	int successes = 0;
	int n = 0;
	double estimate;
	int leakyness = 100;
	
	public LeakySuccessEstimate(String name){
		this.name = name;
	}

	
	public void update(boolean success){
		if(n<leakyness){
		n++;
		if(success){
			successes++;
		}
		estimate = successes*1.0/n;
		}else{
			estimate *= 1 - (1/leakyness);
			if(success){
				estimate += 1/leakyness;
			}
		}	
	}
	
	public double successRate(){
		return estimate;
	}
	
	public void  print(){
		if(!(name.contains("=") && n == 0))
			System.out.println(String.format("%-15s:  success rate=%.3f", name, estimate));
	}
}

package main;

public class SuccessEstimate {
	String name;
	int successes = 0 ;
	int n = 0;
	
	public SuccessEstimate(String name){
		this.name = name;
	}
	/**
	 * Wordt deze uberhaubt ergens gebruikt?
	 * @param name
	 * @param successes
	 * @param n
	 */
	public SuccessEstimate(String name, int successes, int n){
		this.name = name;
		this.successes = successes;
		this.n = n;
	}
	
	public void update(boolean success){
		n++;
		if(success)
			successes++;
	}
	
	public double successRate(){
		return successes*1.0/n;
	}
	
	public void  print(){
		if(!(name.contains("=") && n == 0))
			System.out.println(String.format("%-15s:  successes=%d     n=%d     success rate=%.3f", name, successes, n, successes*1.0/n));
	}
}

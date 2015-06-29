package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class PageProposer {
	private ArrayList<EstimatorSet> estimates = new ArrayList<EstimatorSet> ();
	private int nrOfEstimateSets = 100;
	private Random random = new Random(System.currentTimeMillis());
	
	public PageProposer(){
		for(int i = 0; i < nrOfEstimateSets; i++){
			estimates.add(new EstimatorSet());
		}
		initWithRandomData();
	}

	private void initWithRandomData() {
		LinkedList<DataPoint> randomData = InputOutput.loadFromCSV("resources/output 10x10000 random.txt");
		for(DataPoint dp: randomData){
			updateEstimates(dp);
		}
		
	}
	
	public DataPoint proposePage(int i, int runid){
		DataPoint context = ServerHandler.getContext(i, runid, false);
		int r = random.nextInt(nrOfEstimateSets);
		DataPoint proposal = estimates.get(r).propose(context);
		ServerHandler.proposePage(proposal);
		updateEstimates(proposal);
		return proposal;
	}
	
	private void updateEstimates(DataPoint dp){
		for(EstimatorSet e: estimates){
			int r = random.nextInt(2);
			if(r == 1)
				e.update(dp);
		}
	}
	
	
}

package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class PageProposer {
	private ArrayList<EstimatorSet> estimates = new ArrayList<EstimatorSet> ();
	private int nrOfEstimateSets = 1000;
	private Random random = new Random(System.currentTimeMillis());
	
	public PageProposer(){
		for(int i = 0; i < nrOfEstimateSets; i++){
			estimates.add(new EstimatorSet());
		}
		initWithExistingData();
	}

	private void initWithExistingData() {
		LinkedList<DataPoint> data = InputOutput.loadFromCSV("resources/output random runs 1-9.txt");
			
		for(DataPoint dp: data){
			updateEstimates(dp);
		}
//		data = InputOutput.loadFromCSV("resources/output simple bayes runs 10-14 j=100.txt");	
//		for(DataPoint dp: data){
//			updateEstimates(dp);
//		}
		
	}
	
	public DataPoint proposePage(int i, int runid){
//		DataPoint context = ServerHandler.getContext(i, runid, false);
		DataPoint context = new DataPoint();
		int r = random.nextInt(nrOfEstimateSets);
		DataPoint proposal = estimates.get(r).propose(context);
		ServerHandler.proposePage(proposal);
		updateEstimates(proposal);
		return proposal;
	}
	
	public void printAllBestEstimates(){
		for(EstimatorSet e: estimates)
			e.printBestArguments();
	}
	
	private void updateEstimates(DataPoint dp){
		for(EstimatorSet e: estimates){
			int r = random.nextInt(2);
			if(r == 1)
				e.update(dp);
		}
	}
	
	
}

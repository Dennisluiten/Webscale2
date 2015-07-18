package main;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		new Main();
		System.out.println("Main process finished.");
	}
	
	public Main(){
	//	gatherRandomData();
	//	analyze();
		doStuffjaaaj();
	//	printEstimates();
	}
	
	private void doStuffjaaaj(){
		PageProposer pp = new PageProposer();
		LinkedList<DataPoint> data = new LinkedList<>();
		for (int runID = 10001; runID < 10101; runID++){
			for (int i = 1; i < 100000; i++){
				if(i%100 ==0)
					System.out.println(runID + "-"+ i);
				DataPoint dp = pp.proposePage(i, runID);				
				data.add(dp);
			}
		}
		InputOutput.saveToCSV(data, "resources/output volgende test.txt");
	}
	
	private void printEstimates(){
		PageProposer pp = new PageProposer();
		pp.printAllBestEstimates();
	}
	
	private void analyze(){
		LinkedList<DataPoint> data = InputOutput.loadFromCSV("resources/output volgende test.txt");
		for (int i = 0; i < 1; i++){
			LinkedList<DataPoint> filtData = Filter.filterNone(data);
			DataAnalyzer analyzer = new DataAnalyzer();
			analyzer.analyseArgumentsSimple(filtData);
//			analyzer.analyseContextSimple(filtData);
			analyzer.printAveragesAllArguments();
//			System.out.print("Age: " + i + "  ");
//			analyzer.printTotal();
		}
	}
	
	private void gatherRandomData(){
		LinkedList<DataPoint> data = new LinkedList<>();
		for (int runID = 5000; runID < 5005; runID++){
			for (int i = 1; i < 10000; i++){
				System.out.println(runID + "-"+ i);
				DataPoint dp = ServerHandler.getContext(i, runID, true);
				ServerHandler.proposePage(dp);

				data.add(dp);
			}
		}
		InputOutput.saveToCSV(data, "resources/output random runs 5000-5004.txt");
	}

}

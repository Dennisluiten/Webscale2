package main;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		new Main();
		System.out.println("Main process finished.");
	}
	
	public Main(){
//		gatherRandomData();
		analyze();
	}
	
	private void doStuffjaaaj(){
		PageProposer pp = new PageProposer();
		LinkedList<DataPoint> data = new LinkedList<>();
		for (int runID = 10; runID < 15; runID++){
			for (int i = 1; i < 10000; i++){
				System.out.println(runID + "-"+ i);
				DataPoint dp = pp.proposePage(i, runID);				
				data.add(dp);
			}
		}
		InputOutput.saveToCSV(data, "resources/output eerste test.txt");
	}
	
	private void analyze(){
		LinkedList<DataPoint> data = InputOutput.loadFromCSV("resources/output.txt");
		
		DataAnalyzer analyzer = new DataAnalyzer();
		analyzer.analyseArgumentsSimple(data);
		analyzer.printAverages();
	}
	
	private void gatherRandomData(){
		LinkedList<DataPoint> data = new LinkedList<>();
		for (int runID = 1; runID < 10; runID++){
			for (int i = 1; i < 10000; i++){
				System.out.println(runID + "-"+ i);
				DataPoint dp = ServerHandler.getContext(i, runID, true);
				ServerHandler.proposePage(dp);

				data.add(dp);
			}
		}
		InputOutput.saveToCSV(data, "");
	}

}

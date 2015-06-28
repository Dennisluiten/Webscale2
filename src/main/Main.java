package main;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		LinkedList<DataPoint> data = InputOutput.loadFromCSV("resources/output 10x10000 random.txt");
		
		DataAnalyzer analyzer = new DataAnalyzer();
		analyzer.analyseArgumentsSimple(data);
		analyzer.printAverages();
		
		System.out.println("Main process finished.");
	}
	
	private void gatherRandomData(){
		LinkedList<DataPoint> data = new LinkedList<>();
		for (int runID = 1; runID < 10; runID++){
			for (int i = 1; i < 10000; i++){
				System.out.println(runID + "-"+ i);
				DataPoint dp = ServerHandler.getContext(i, runID);
				ServerHandler.submitResponse(dp);

				data.add(dp);
			}
		}
		InputOutput.saveToCSV(data, "");
	}

}

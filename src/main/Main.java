package main;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
//		DataPoint d = new DataPoint ();
//		LinkedList<DataPoint> ds = new LinkedList<>();
//		ds.add(d);
//		CsvHandler.saveToCSV(ds);
//		LinkedList<DataPoint> ds2 = CsvHandler.loadFromCSV();
//		System.out.println(ds2.get(0).toCsvString());
		
		LinkedList<DataPoint> ds3 = new LinkedList<>();
		
		for (int runID = 1; runID < 10; runID++){
//			System.out.println(runID);
			for (int i = 1; i < 10000; i++){
				System.out.println(runID + "-"+ i);
				DataPoint dp = ServerHandler.getContext(i, runID);
				ServerHandler.submitResponse(dp);
				ds3.add(dp);
			}
		}
		CsvHandler.saveToCSV(ds3);
	}

}

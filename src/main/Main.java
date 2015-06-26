package main;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		DataPoint d = new DataPoint ();
		LinkedList<DataPoint> ds = new LinkedList<>();
		ds.add(d);
		CsvHandler.saveToCSV(ds);
		LinkedList<DataPoint> ds2 = CsvHandler.loadFromCSV();
		System.out.println(ds2.get(0).toCsvString());
	}

}

package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

public class OutputWriter {
	private static String standardCsvPath = "resources/output.txt";
	
	public static void saveToCSV(LinkedList<DataPoint> datapoints, String path){
		if(path == ""){
			path = OutputWriter.standardCsvPath;
		}
		try {
			 
			File file = new File(path); 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(DataPoint d: datapoints)
				bw.write(d.toCsvString());
			bw.close();
 
			System.out.println("Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static LinkedList<DataPoint> loadFromCSV(String path) {
		if(path == ""){
			path = OutputWriter.standardCsvPath;
		}
		LinkedList<DataPoint> data = new LinkedList<DataPoint>();
		try {
			for (String line : Files.readAllLines(Paths.get(path))) {
			    String[] part = line.split(",");
			    int userID                = Integer.parseInt(part[0]);
				Platform platform         = Platform.valueOf(part[1]);
				Language language         = Language.valueOf(part[2]);
				int age                   = Integer.parseInt(part[3]);
				SearchEngine searchEngine = SearchEngine.valueOf(part[4]);
				int header                = Integer.parseInt(part[5]);
				Adtype adtype             = Adtype.valueOf(part[6]);
				Color color               = Color.valueOf(part[7]);
				int productID             = Integer.parseInt(part[8]);
				int price                 = Integer.parseInt(part[9]);
				boolean response          = Boolean.getBoolean(part[10]);
				int runID				  = Integer.parseInt(part[11]);
				int i					  = Integer.parseInt(part[12]);
				
				data.add(new DataPoint(userID, platform, language, age, searchEngine, header, adtype, color, productID, price, response, runID, i));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
}

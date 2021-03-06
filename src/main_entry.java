import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class main_entry {
	public static void main(String args[])
	{
		if(args.length < 1){
			System.err.println("Please specify filename");
			System.exit(1);
		}
		
		String filename = args[0]; 
		BufferedReader br = null;
		String line = "";
		String delimiter = ",";
		ArrayList<String[]> tripList = new ArrayList<String[]>();
		String[] columnHeaders = null;
				
		try {

			br = new BufferedReader(new FileReader(filename));
			line = br.readLine(); //skip the first line that contains the titles of the columns.
			columnHeaders = line.split(delimiter);
			while ((line = br.readLine()) != null) {

			        // use comma as separator
				String[] trip = line.split(delimiter);
				tripList.add(trip);
//hello this is test 2
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		InformationGainCalculator igc = new InformationGainCalculator(tripList, columnHeaders);
		double value = igc.CalculateEntropy();
		double other_value = igc.CalculateAttributeEntropy(5);
		
		System.out.println(value);
		System.out.println(other_value);
		
		
		//I'm also thinking we need some sort of node class to
		//hold all the branches and decisions
	}
}

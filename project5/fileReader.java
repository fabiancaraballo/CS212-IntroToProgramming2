import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class fileReader {
	
	private static String path;
	
	
	public fileReader(String file_path) {
		path = file_path;
	}
	
	public ArrayList<java.lang.String> OpenFile() throws IOException {
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr); 
		
		
		int numOfLines = readLines();
		ArrayList<String> textData = new ArrayList<String>(numOfLines);
		
		
		
		for(int i = 0; i < numOfLines; i++) {
			String line = textReader.readLine();
			textData.add(line);
			
		}
		
		textReader.close();
		return textData;
 	}
	
	public static int readLines() throws IOException  {
		
		FileReader newFile = new FileReader(path);
		BufferedReader newText = new BufferedReader(newFile); 
		
		
		String aLine;
		int numOfLines  = 0;
		while ((aLine = newText.readLine()) != null) {
			numOfLines++;
		}
		newText.close();
		
		return numOfLines;
		
		
	}

	
	

	
}


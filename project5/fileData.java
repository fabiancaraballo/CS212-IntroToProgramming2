import java.io.IOException;
import java.util.ArrayList;


public class fileData extends fileReader {
	
	/**
	public static void main(String[] args) throws IOException {
		
		System.out.println(fileList());
		
	}
	**/
	
	public fileData(String file_path) {
		super(file_path);
		// TODO Auto-generated constructor stub
	}

	public static  ArrayList<java.lang.String> fileList() throws IOException {
		
		String file_name = "/Users/fabiancaraballo/eclipse-workspace/Assignment3/Project5/src/phonebook_test.txt";
		
		fileReader file = new fileReader(file_name);
		ArrayList<String> arrLines = new ArrayList<String>(48783);
		arrLines = file.OpenFile();

		
		return arrLines; 
		
	}

}




public class createTxtFile {
	public static void main( String[] args ) {
		createPhoneFile application = new createPhoneFile(); 
		application.openFile();
		application.addRecords();
	    application.closeFile();
	   } // end main
	
} // end class CreateSequentialFileTest



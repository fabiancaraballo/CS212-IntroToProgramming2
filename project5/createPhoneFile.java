import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class createPhoneFile extends phoneRecord {
	
	private Formatter output; // object used to output text to file
	   // enable user to open file
	public void openFile() {
		try {
	       output = new Formatter("output.txt"); // open the file
	    } // end try
	    catch ( SecurityException securityException ) {
	        System.err.println("You do not have write access to this file." );
	        System.exit( 1 ); // terminate the program
	    } // end catch
	    catch ( FileNotFoundException fileNotFoundException ) { 
	    	System.err.println( "Error opening or creating file." );
	    System.exit( 1 );
	    }//
	}	

	
	// add records to file
	public void addRecords() {
	   // object to be written to file
	   phoneRecord record = new phoneRecord();
	   
	   Scanner input = new Scanner( System.in );
	   System.out.printf( "%s\n%s\n%s\n%s\n\n",
	      "To terminate input, type the end-of-file indicator ",
	      "when you are prompted to enter input.",
	      "On UNIX/Linux/Mac OS X type <ctrl> d then press Enter",
	      "On Windows type <ctrl> z then press Enter" );
	   System.out.printf( "%s\n%s",
	      "Enter phone number (> 0), first name, and last name.",
	      "? " );
	   while ( input.hasNext() ) // loop until end-of-file indicator 
	   {
		   try // output values to file
		   {
			   record.setPhone( input.nextInt() ); // read account number
			   record.setFirstName( input.next() ); // read first name
			   record.setLastName( input.next() ); // read last name
	   
			   if ( record.getpNum() > 0 ) {
				 output.format( "%d %s %s %.2f\n", record.getpNum(),
						   record.getFirstName(), record.getLastName());
				   
			   }
			   else {
				   System.out.println("Phone number must be greater than 0." );
			   }
			   
		   }
	       catch ( FormatterClosedException formatterClosedException ) {
	            System.err.println( "Error writing to file." );
	            return;
	       } // end catch
	       catch ( NoSuchElementException elementException ) {
	            System.err.println( "Invalid input. Please try again." );
	            input.nextLine(); // discard input so user can try again
	       } // end catch
	         System.out.printf( "%s %s\n%s", "Enter phone number (>0),",
	            "first name, and last name.", "? " );
	      } // end while
	   } // end method addRecords
	
	public void closeFile() {
	      if ( output != null )
	         output.close();
	   } // end method closeFile
	} // end class CreateTextFile


//Got this code from the textbook
	



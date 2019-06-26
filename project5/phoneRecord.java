
public class phoneRecord {
	
	private int phoneNumber;
	private String firstName;
	private String lastName;
	
	
	// no-argument constructor calls other constructor with default values
	public phoneRecord() {
		this( 0, "", ""); // call four-argument constructor
	} // end no-argument AccountRecord constructor
	
	// initialize a record
	public phoneRecord( int acct, String first, String last) {
		setPhone( acct );
		setFirstName( first );
		setLastName( last );
	} // end four-argument AccountRecord constructor
	
	 // set account number
	public void setPhone( int phone )	{
		phoneNumber = phone;
	} // end method setAccount
	
	// get account number
	public int getpNum() {
		return phoneNumber;
	} // end method getAccount
	 // set first name
	
	public void setFirstName( String first ) {
		firstName = first;
	} // end method setFirstName
	// get first name
	public String getFirstName() {
		return firstName;
	} // end method getFirstName
	
	// set last name
	public void setLastName( String last ) {
		lastName = last;
	} // end method setLastName
	
	 // get last name
	 public String getLastName() {
		 return lastName;
	 } // end method getLastName
	
	
	

}

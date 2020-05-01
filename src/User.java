/*
 * This is the class of the User 
 * this method to set the user's fisrt name, last name and pastport information
 * this method to get the user's fisrt name, last name and pastport information
 */
public class User {
	private String firstName;
	private String lastName;
	private String passport;
	private String email;
	
	//this is the constructor
	public User() {
		this.firstName = "nobody";
		this.lastName = "nobody";
		this.passport = "00000000";
		this.email = "";
	}
	
	//this is getter method
	public String getFirstName() {
		return this.firstName;
	}
	//this is getter method
	public String getLastName() {
		return this.lastName;
	}
	//this is getter method
	public String getPassport() {
		return this.passport;
	}
	//This is the set method
	public void setFirstName(String fname) {
		this.firstName = fname;
	}
	//This is the set method
	public void setLastName(String lname) {
		this.lastName = lname;
	}
	//This is the set method
	public void setPassport(String passport) {
		this.passport = passport;
	}
	
	//this is getter method
	public String getEmail() {
		return this.email;
	}
	
	//This is the set method
	public void setEmail(String email) {
		this.email = email;
	}
	
	//This method to check the user already have or not
	public boolean isSameUser(User userToCompare) {
		String firstNameToCompare = userToCompare.getFirstName();
		String lastNameToCompare = userToCompare.getLastName();
		String passportToCompare = userToCompare.getPassport();
		String emailToCompare = userToCompare.getEmail();
		
		return firstNameToCompare.equals(this.firstName) 
				&& lastNameToCompare.equals(this.lastName) 
				&& passportToCompare.equals(this.passport)
				&& emailToCompare.equals(this.email);
	}
}

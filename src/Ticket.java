/*
 * This class records the information about the user's ticket
 */
public class Ticket {
	
	// Initializing each String for flight ticket information
	private String flight;
	private String departAirport;
	private String arriveAirport;
	
	private String departTime;
	private String departDay;
	private String departMonth;
	private String departYear;
	
	private String arriveTime;
	private String arriveDay;
	private String arriveMonth;
	private String arriveYear;
	
	private String seatRow;
	private String seatCol;
	private String seatClass;
	
	private String aircompany;
	private boolean isRoundTrip;
	private double price;

	// This is the contructor
	public Ticket() {
		this.flight = "";
		this.departAirport = "";
		this.arriveAirport = "";
		
		this.departTime = "";
		this.departDay = "";
		this.departMonth = "";
		this.departYear = "";
		
		this.arriveTime = "";
		this.arriveDay = "";
		this.arriveMonth = "";
		this.arriveYear = "";
		
		this.seatRow = "";
		this.seatCol = "";
		this.seatClass = "";
		
		this.aircompany = "";
		this.isRoundTrip = false;
		this.price = 0.0;
	}
	
	// Boolean method to determine if flight is round trip
	public boolean isRoundTripTicket() {
		return this.isRoundTrip;
	}
	
	// Method to set the ticket as round trip
	public void setRoundTripticket() {
		this.isRoundTrip = true;
	}
	
	// Method for departing airport for round trip
	public String getBackDepartAirport() {
		if (isRoundTrip == false) return "";
		return this.arriveAirport;
	}
	
	// Method for apprivint airport for round trip
	public String getBackarriveAirport() {
		if (isRoundTrip == false) return "";
		return this.departAirport;
	}
	
	// Method to get flight
	public String getFlight() {
		return this.flight;
	}
	
	// Method to get name of air company
	public String getAircompany() {
		return this.aircompany;
	}
	
	// Method to get price of ticket
	public double getPrice() {
		return this.price;
	}
	
	// Methods to get departure and arrival time
	public String getDepartTime() {
		return this.departTime;
	}
	public String getArriveTime() {
		return this.arriveTime;
	}
	
	// Methods to set departure and arrival dates 
	public String getDepartDate() {
		return this.departYear + "-" + this.departMonth + "-" + this.departDay;
	}
	public String getArriveDate() {
		return this.arriveYear + "-" + this.arriveMonth + "-" + this.arriveDay;
	}
	
	// Method to get departing and arrival airport
	public String getDepartAirport() {
		return this.departAirport;
	}
	public String getArriveAirport() {
		return this.arriveAirport;
	}
	
	// Methods to get departure day, month and year
	public String getDepartDay() {
		return this.departDay;
	}
	public String getDepartMonth() {
		return this.departMonth;
	}
	public String getDepartYear() {
		return this.departYear;
	}
	
	// Methods to get arrival day, month and year
	public String getArriveDay() {
		return this.arriveDay;
	}
	public String getArriveMonth() {
		return this.arriveMonth;
	}
	public String getArriveYear() {
		return this.arriveYear;
	}
	
	// Methods to get seat row, column and class
	public String getSeatRow() {
		return this.seatRow;
	}
	public String getSeatCol() {
		return this.seatCol;
	}
	public String getSeatClass() {
		return this.seatClass;
	}
	
	// Method to set the set the seat class, row and column
	public String getSeat() {
		return this.seatClass + " " + this.getSeatRow() + "," + this.getSeatCol();
	}
	
	// Methods to set the departing and arriving airport
	public void setDepartAirport(String deptAirport) {
		this.departAirport = deptAirport;
	}
	public void setArriveAirport(String arriveAirport) {
		this.arriveAirport = arriveAirport;
	}
	
	// Methods to set the departing day, month and year
	public void setDepartDay(String date) {
		this.departDay = date;
	}
	public void setDepartMonth(String month) {
		this.departMonth = month;
	}
	
	public void setDepartYear(String year) {
		this.departYear = year;
	}
	
	// Methods to set the arrival day, month and year
	public void setArriveDay(String date) {
		this.arriveDay = date;
	}
	public void setArriveMonth(String month) {
		this.arriveMonth = month;
	}
	public void setArriveYear(String year) {
		this.arriveYear = year;
	}
	
	// Methods to set the seat row, column and class
	public void setSeatRow(String row) {
		this.seatRow = row;
	}
	public void setSeatCol(String col) {
		this.seatCol = col;
	}
	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}
	
	// Methods to set the flight, air company and price
	public void setFlight(String flight) {
		this.flight = flight;
	}
	public void setAircompany(String aircompany) {
		this.aircompany = aircompany;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	// Methods to set the departure time and arrival time
	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}
	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}
}

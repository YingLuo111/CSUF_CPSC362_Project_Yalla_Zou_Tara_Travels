/*
 * This is the record the inofrmation about the user's
 * to record all of the user filled choice informations
 * that will used to the finally list 
 */
public class Ticket {
	//Initialize the each of the information about user
	private String departAirport;
	private String destAirport;
	private String leavingDate;
	private String leavingMonth;
	private String leavingYear;
	private String returnDate;
	private String returnMonth;
	private String returnYear;
	private String seatRow;
	private String seatCol;
	private String seatClass;
	private boolean isRoundTrip;
	//this is the constructor
	public Ticket() {
		this.departAirport = "";
		this.destAirport = "";
		this.leavingDate = "";
		this.leavingMonth = "";
		this.leavingYear = "";
		this.returnDate = "";
		this.returnMonth = "";
		this.returnYear = "";
		this.seatRow = "";
		this.seatRow = "";
		this.seatCol = "";
		this.seatClass = "";
		this.isRoundTrip = false;
	}
	
	public boolean isRoundTripTicket() {
		return this.isRoundTrip;
	}
	
	public void setRoundTripticket() {
		this.isRoundTrip = true;
	}
	
	public String getBackDepartAirport() {
		if (isRoundTrip == false) return "";
		return this.destAirport;
	}
	
	public String getBackDestAirport() {
		if (isRoundTrip == false) return "";
		return this.departAirport;
	}
	
	public String getDepartAirport() {
		return this.departAirport;
	}
	
	public String getDestAirport() {
		return this.destAirport;
	}
	
	public String getLeavingDate() {
		return this.leavingDate;
	}
	
	public String getLeavingMonth() {
		return this.leavingMonth;
	}
	
	public String getLeavingYear() {
		return this.leavingYear;
	}
	
	public String getReturnDate() {
		return this.returnDate;
	}
	
	public String getReturnMonth() {
		return this.returnMonth;
	}
	
	public String getReturnYear() {
		return this.returnYear;
	}
	
	public String getSeatRow() {
		return this.seatRow;
	}
	
	public String getSeatCol() {
		return this.seatCol;
	}
	
	public String getSeatClass() {
		return this.seatClass;
	}
	
	public void setDepartAirport(String deptAirport) {
		this.departAirport = deptAirport;
	}
	
	public void setDestAirport(String destAirport) {
		this.destAirport = destAirport;
	}
	
	public void setLeavingDate(String date) {
		this.leavingDate = date;
	}
	
	public void setLeavingMonth(String month) {
		this.leavingMonth = month;
	}
	
	public void setLeavingYear(String year) {
		this.leavingYear = year;
	}
	
	public void setReturnDate(String date) {
		this.returnDate = date;
	}
	
	public void setReturnMonth(String month) {
		this.returnMonth = month;
	}
	
	public void setReturnYear(String year) {
		this.returnYear = year;
	}
	
	public void setSeatRow(String row) {
		this.seatRow = row;
	}
	
	public void setSeatCol(String col) {
		this.seatCol = col;
	}
	
	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}
}

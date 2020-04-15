/*
 * This is the Resvervation method
 * to the all of the information about the users reservation
 * Reserve Ticket
 * Reserve Service
 */
public class Reservation {
	private User user;
	private Ticket ticket;
	private Service service;
	
	public Reservation() {
		this.ticket = null;
		this.service = null;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public Ticket getTicket() {
		return this.ticket;
	}
	
	public Service getService() {
		return this.service;
	}
	
	public void setUser(User u) {
		this.user = u;
	}
	
	public void setTicket(Ticket t) {
		this.ticket = t;
	}
	
	public void setService(Service s) {
		this.service = s;
	}
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PerInfo extends JPanel implements ActionListener{
	
	// Initializing the JLabels in Personal Information Class
	JLabel label1 = new JLabel("  Personal Information ");
    JLabel label2 = new JLabel("  Enter your Personal Information ");
	
	// Initializing JButtons used in Personal Information class 
	JButton finish                  = new JButton(" Finish-->>");
	JButton backPersonalInfoHome  = new JButton("<<--Back Information Home");
	JButton backHome                = new JButton("<<--Back Home");
	
	// Initializing TextFields used in Personal Information class
	JTextField userEnter1;
	JTextField userEnter2;
	
	//JTextArea finishTextArea = new JTextArea("");
	
	// Initializing the JLabels to insert images into
	JLabel image  = new JLabel(" ");
	JLabel image2 = new JLabel(" ");
	
	// Initializing JPanels used in Personal Information class
	JPanel main   = new JPanel();
	JPanel panelC = new JPanel();
	JPanel panelN = new JPanel();
	JPanel panelW = new JPanel();
	JPanel panelS = new JPanel();
	JPanel panelEnter = new JPanel();
	JPanel panelShow = new JPanel();
	
	//private CardLayout card = new CardLayout();
	
	// Initializing the images that will be used 
    private ImageIcon Picture;
	private Image Img;
	private ImageIcon Picture2;
	private Image Img2;
	
	// Creating an object of Fly class 
	private Fly flyContainer;
	
	public PerInfo(Fly container) {
		
		flyContainer = container;
		setSize(800,800);
		setLayout(new BorderLayout());
		
		// Setting fonts
		label1.setFont(new Font("Arial", Font.BOLD, 25));
		label2.setFont(new Font("Arial", Font.BOLD, 25));
		 
		// Setting JLabel Backgrounds 
		setJLabelBackGround(label1, Color.BLACK,new Color(100,149,237));
		setJLabelBackGround(label1, Color.BLACK,new Color(100,149,237));
		
		 
		setJButtonBackGround(finish, Color.BLACK,new Color(100,149,237));
		setJButtonBackGround( backPersonalInfoHome, Color.BLACK,new Color(100,149,237));
		setJButtonBackGround(backHome, Color.BLACK,new Color(100,149,237));
		 
		userEnter1 = new JTextField("Please enter your name (First Last)",12);
	 	userEnter2 = new JTextField("Please enter your passport number",12);
	 	
		// Inserting the image icons
		Picture = new ImageIcon("resources/Images/subtitle.png");
		Img = Picture.getImage().getScaledInstance(900, 250, java.awt.Image.SCALE_SMOOTH);
		image.setIcon(new ImageIcon(Img));
		
		Picture2 = new ImageIcon("resources/Images/personalImageSorth.png");
		Img2 = Picture2.getImage().getScaledInstance(900, 250, java.awt.Image.SCALE_SMOOTH);
		image2.setIcon(new ImageIcon(Img2));
		
		userEnter1.setVisible(true);
		userEnter2.setVisible(true);
		
		panelW.setBackground(new Color(100,149,237));
		main.setLayout(new BorderLayout());
		panelN.add(image);
		panelS.add(image2);
		
		
		panelEnter.setBackground(new Color(100,149,237));
		panelEnter.setLayout(new GridLayout(3,1));
		panelEnter.add(label2);
		panelEnter.add(userEnter1);
		panelEnter.add(userEnter2);
		
		
		panelC.setBackground(new Color(100,149,237));
		panelC.add(panelEnter,BorderLayout.CENTER);
		
		
		panelW.setLayout(new GridLayout(4, 1));
		panelW.add(label1);
		panelW.add(finish);
		panelW.add( backPersonalInfoHome);
		panelW.add(backHome);
		
		// Adding the panels to the main JPanel
		main.add(panelN, BorderLayout.NORTH);
		main.add(panelS, BorderLayout.SOUTH);
		main.add(panelW, BorderLayout.WEST);
		main.add(panelC, BorderLayout.CENTER);
		
		add(main);
		
		finish.addActionListener(this);
		backHome.addActionListener(this);
		backPersonalInfoHome.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
		
        // If user clicks finish button, show currentFlightInfo card
		if(source == finish){
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(),"currentFightInfo");
			
			setCurUserInfo();
			String curInfo = getCurInfo();
			flyContainer.setCurFlightInfo(curInfo);
		}
		
		// If user clicks Back Information Home button, show personalInfoHomePanel card 
		else if(source == backPersonalInfoHome) {
			
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(),"personalInfoHomePanel");
		}
		// If user clicks Back home button, show HomePanel card
		else if(source == backHome) {
			
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(), "HomePanel");
			//reset the information
			flyContainer.reset();
		}
		
	}
	// Function to set JButton settings 
	public void setJButtonBackGround(JButton b, Color FC,Color BC) {
		
		b.setForeground(FC);       
		b.setBackground(BC);       
		b.setOpaque(true);               
		b.setBorderPainted(false);        
	}
	// Function to set JLabel settings 
   public void setJLabelBackGround(JLabel l, Color FC,Color BC) {
		l.setOpaque(true);  
		l.setBackground(BC);
		l.setForeground(FC);
		
	}
   // Function to set JTextArea settings 
   public void setJTextAreaBackGround(JTextArea t, Color FC,Color BC) {
		t.setOpaque(true);  
		t.setBackground(BC);
		t.setForeground(FC);
		
	}
   
   // This function is called if the user wants to reset their input
   public void reset() {
		userEnter1.setText("Please enter your Name (First Last): "); 
	 	userEnter2.setText("Please enter your passport number: ");
   }
   
   // Function to set the current user's information
   private void setCurUserInfo() {
	   User curUser = flyContainer.getCurUser();
	   String firstname = "", lastname = "";
	   String[] names = userEnter1.getText().split("\\s+");
	   if (names.length > 1) {
		   firstname = names[0];
		   lastname = names[1];
	   } else if (names.length == 1) {
		   firstname = names[0];
	   }
	   
	   curUser.setFirstName(firstname);
	   curUser.setLastName(lastname);
	   curUser.setPassport(userEnter2.getText());
   }
   
   // Function to get the curent flight information
   private String getCurInfo() {
		  User u = flyContainer.getCurUser();
		  Ticket t = flyContainer.getCurTicket();
		  Service s = flyContainer.getCurService();
		  
		  String userInfo = getUserInfo(u);
		  String ticketInfo = getTicketInfo(t);
		  String serviceInfo = getServiceInfo(s);
		  
		  return userInfo + "\n\n" + ticketInfo + "\n" + serviceInfo;
	  }
   
	 // Function to get the user's infromation: First name, last name and passport number 
	 private String getUserInfo(User u) {
		  String firstname = u.getFirstName();
		  String lastname = u.getLastName();
		  String passport = u.getPassport();
		  
		  String userInfo = "FirstName: " + firstname + "\t\t" + "LastName:" + lastname;
		  userInfo += "\nPassport: " + passport;
		  
		  return userInfo;
	  }
	  
	 // Function to get the ticket information
	  private String getTicketInfo(Ticket t) {
		  String departAirport = t.getDepartAirport();
		  String destAirport = t.getDestAirport();
		  String departMonth = t.getLeavingMonth();
		  String departDate = t.getLeavingDate();
		  String departYear = t.getLeavingYear();
		  String seatRow = t.getSeatRow();
		  String seatCol = t.getSeatCol();
		  String seatClass = t.getSeatClass();
		  String returnMonth = "", returnDate = "", returnYear = "";
		  if (t.isRoundTripTicket() == true) {
			  returnMonth = t.getReturnMonth();
			  returnDate = t.getReturnDate();
			  returnYear = t.getReturnYear();
		  }
		  
		  // This outputs the ticket information 
		  String ticketInfo = "Departure: " + departAirport + "\t" + "Arrival: " + destAirport + "\n";
		  ticketInfo += "Leaving on: " + departMonth + "/" + departDate + "/" + departYear + "\n";
		  if (t.isRoundTripTicket() == true) {
			  ticketInfo += "Return from: " + destAirport + "\t" + "Return at: " + departAirport + "\n";
			  ticketInfo += "Return on: " + returnMonth + "/" + returnDate + "/" + returnYear + "\n";
		  }
		  ticketInfo += "Cabin Class: " + seatClass + "\n";
		  ticketInfo += "Seat at: Row " + seatRow + " Col " + seatCol;
		  
		  return ticketInfo;
		  
	  }
	  // Function to get the service information 
	  private String getServiceInfo(Service s) {
		  ArrayList<String> babyServices = null, foodServices = null, disableServices = null;
		  
		  if (s.isBabyBooked()) {
			  babyServices = s.getBookedBabyService();
		  }
		  
		  if (s.isDisableBooked()) {
			  disableServices = s.getBookedDisabledFacilities();
		  }
		  
		  if (s.isFoodBooked()) {
			  foodServices = s.getBookedFoods();
		  }
		  
		  String serviceInfo = "";
		  if (babyServices != null) {
			  serviceInfo += "\nBooked baby services are: \n";
			  for (int i = 0; i < babyServices.size() - 1; i++) {
				  serviceInfo += babyServices.get(i) + ", ";
			  }
			  serviceInfo += babyServices.get(babyServices.size() - 1);
		  }
		  
		  if (disableServices != null) {
			  serviceInfo += "\nBooked disabled services are: \n";
			  for (int i = 0; i < disableServices.size() - 1; i++) {
				  serviceInfo += disableServices.get(i) + ", ";
			  }
			  serviceInfo += disableServices.get(disableServices.size() - 1);
		  }
		  
		  if (foodServices != null) {
			  serviceInfo += "\nBooked food services are: \n";
			  for (int i = 0; i < foodServices.size() - 1; i++) {
				  serviceInfo += foodServices.get(i) + ", ";
			  }
			  serviceInfo += foodServices.get(foodServices.size() - 1);
		  }
		  
		  return serviceInfo;
	  }
}

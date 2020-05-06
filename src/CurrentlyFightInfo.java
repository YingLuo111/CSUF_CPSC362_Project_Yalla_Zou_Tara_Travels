/*
 *  This class is the final panel shown after a user has successfully 
 *  booked their flight. From here, they can share theiir email or
 *  go back to the personal information home.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CurrentlyFightInfo extends JPanel implements ActionListener{
	
	// Initializing the JLabels, Jbuttons, JPanels, ImageIcons, Images and JTextArea
	JLabel label1 = new JLabel(" Congratulations ! ");
    JLabel label2 = new JLabel("  Enter City and Date again ");
	
	
    JButton finish                  = new JButton(" Finish and Payment-->>");
	JButton backPersonalIyInfoHome  = new JButton("<<--Back Personal Information Home");
	JButton shareWithEmail          = new JButton("<< Share to my email >>");
	JButton backHome                = new JButton("<<--Back Home");
	
	
	JLabel image  = new JLabel(" ");
	JLabel image2 = new JLabel(" ");
	
	
	JPanel main   = new JPanel();
	JPanel panelC = new JPanel();
	JPanel panelN = new JPanel();
	JPanel panelW = new JPanel();
	JPanel panelS = new JPanel();
	
	//private CardLayout card = new CardLayout();
	
    private ImageIcon Picture;
	private Image Img;
	private ImageIcon Picture2;
	private Image Img2;
	private JTextArea finalInfo;
	
	// Creating a variable flycontainer of type Fly
	private Fly flyContainer;
	
	/*
	 * Constructor of this class. It sets all of the JLabels,
	 * JButtons, JPanels, Images, font, background, size and layout
	 */
	public CurrentlyFightInfo(Fly container) {
		flyContainer = container;
		setSize(800,800);
		setLayout(new BorderLayout());
		
		Font arial25 = new Font("Arial", Font.BOLD, 25);
		 label1.setFont(arial25);
		 setJLableBackGround(label1, Color.BLACK,new Color(135,206,250));
		 label2.setFont(arial25);
		 setJLableBackGround(label1, Color.BLACK,new Color(135,206,250));
		 
		 setJButtonBackGround(finish, Color.BLACK,new Color(135,206,250));
		 setJButtonBackGround(backPersonalIyInfoHome, Color.BLACK,new Color(135,206,250));
		 setJButtonBackGround(shareWithEmail, Color.BLACK,new Color(135,206,250));
		 setJButtonBackGround(backHome, Color.BLACK,new Color(135,206,250));
		 
		Picture = new ImageIcon("resources/Images/subtitle.png");
		Img = Picture.getImage().getScaledInstance(900, 200, java.awt.Image.SCALE_SMOOTH);
		image.setIcon(new ImageIcon(Img));
		
		Picture2 = new ImageIcon("resources/Images/HomeImageSorth.png");
		Img2 = Picture2.getImage().getScaledInstance(900, 250, java.awt.Image.SCALE_SMOOTH);
		image2.setIcon(new ImageIcon(Img2));
		
		finalInfo = new JTextArea();
		finalInfo.setBackground(new Color(135,206,250));
		
		main.setLayout(new BorderLayout());
		panelN.add(image);
		panelS.add(image2);
		
		panelC.setBackground(new Color(135,206,250));
		panelC.add(finalInfo);
		
		panelW.setBackground(new Color(135,206,250));
		panelW.setLayout(new GridLayout(5, 1));
		panelW.add(label1);
		panelW.add(finish);
		panelW.add(backPersonalIyInfoHome);
		panelW.add(shareWithEmail);
		panelW.add(backHome);
		
		main.add(panelN, BorderLayout.NORTH);
		main.add(panelS, BorderLayout.SOUTH);
		main.add(panelW, BorderLayout.WEST);
		main.add(panelC, BorderLayout.CENTER);
		
		add(main);
		
		finish.addActionListener(this);
		backPersonalIyInfoHome.addActionListener(this);
		backHome.addActionListener(this);
		shareWithEmail.addActionListener(this);	
	}

	/*
	 * This is the actionperformed to execute the button's actions
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
		
        // When user selects "Back Personal Info Home" button, "personiallyInfoHomePanel" appears
		if(source == backPersonalIyInfoHome){
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(),"personiallyInfoHomePanel");
		}
		
		// When user selects "Finish" button, "HomePanel" appears 
		else if(source == finish) {
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(), "HomePanel");
			flyContainer.reset();
		}
		
		// When user selects "Back Home" button, "HomePanel" appears
		else if(source == backHome) {
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(), "HomePanel");
			
			// Information resets
			flyContainer.reset();
		} 
		
		/*
		 * When user selects "Share Eith Email" button, email confirmation is sent to the 
		 * user's email, signaled by a message dialog saying the email was sent successfully 
		 */
		else if (source == shareWithEmail) {
			String curInfo = getCurInfo();
			SendEmail.send(flyContainer.getCurUser().getEmail(), curInfo);
			JOptionPane.showMessageDialog(null, "Your booking infomation has been send to " + flyContainer.getCurUser().getEmail());
		}
	}
	
	// Method to set JButton background 
	public void setJButtonBackGround(JButton b, Color FC,Color BC) {
		b.setForeground(FC);       
		b.setBackground(BC);       
		b.setOpaque(true);               
		b.setBorderPainted(false);        
	}
	
	// Method to set JLabel background
   public void setJLableBackGround(JLabel l, Color FC,Color BC) {
		l.setOpaque(true);  
		l.setBackground(BC);
		l.setForeground(FC);
	}
   
   // Method to set JTextArea background
   public void setJTextAreaBackGround(JTextArea t, Color FC,Color BC) {
		t.setOpaque(true);  
		t.setBackground(BC);
		t.setForeground(FC);
		
	}
   
   // Method to reset JTextArea
   public void reset() {
		finalInfo.setText(""); 
   }

   // Method to set the info
   public void setDisplayedInfo(String info) {
	   finalInfo.setText(info);
   }
   
   // Method to get the user's personal, ticket and service info
   private String getCurInfo() {
		  User u = flyContainer.getCurUser();
		  Ticket t = flyContainer.getCurTicket();
		  Service s = flyContainer.getCurService();
		  
		  String userInfo = getUserInfo(u);
		  String ticketInfo = getTicketInfo(t);
		  String serviceInfo = getServiceInfo(s);
		  
		  return userInfo + "\n\n" + ticketInfo + "\n" + serviceInfo;
	  }
	  
   // Method to get user's first and last name, and passport number
	  private String getUserInfo(User u) {
		  String firstname = u.getFirstName();
		  String lastname = u.getLastName();
		  String passport = u.getPassport();
		  
		  String userInfo = "FirstName: " + firstname + "\t" + "LastName:" + lastname;
		  userInfo += "\nPassport: " + passport;
		  
		  return userInfo;
	  }
	  
	  // Method to get all the details of the user's flight ticket 
	  private String getTicketInfo(Ticket t) {
		  String departAirport = t.getDepartAirport();
		  String destAirport = t.getArriveAirport();
		  String departMonth = t.getDepartMonth();
		  String departDate = t.getDepartDay();
		  String departYear = t.getDepartYear();
		  String seatRow = t.getSeatRow();
		  String seatCol = t.getSeatCol();
		  String seatClass = t.getSeatClass();
		  String returnMonth = "", returnDate = "", returnYear = "";
		  if (t.isRoundTripTicket() == true) {
			  returnMonth = t.getArriveMonth();
			  returnDate = t.getArriveDay();
			  returnYear = t.getArriveYear();
		  }
		  
		  String ticketInfo = "Departure at: " + departAirport + "\t" + "Arrival at: " + destAirport + "\n";
		  ticketInfo += "Leaving on: " + departMonth + "/" + departDate + "/" + departYear + "\n";
		  if (t.isRoundTripTicket() == true) {
			  ticketInfo += "Return from: " + destAirport + "\t" + "Return at: " + departAirport + "\n";
			  ticketInfo += "Return on: " + returnMonth + "/" + returnDate + "/" + returnYear + "\n";
		  }
		  ticketInfo += "Cabin class: " + seatClass + "\n";
		  ticketInfo += formatSeatInfo(seatClass, Integer.parseInt(seatRow), Integer.parseInt(seatCol));
		  
		  return ticketInfo;
		  
	  }
	  
	  // Method to get all the service info the user booked 
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
			  serviceInfo += " \n";
			  serviceInfo += "\nBooked disabled services are: \n";
			  for (int i = 0; i < disableServices.size() - 1; i++) {
				  serviceInfo += disableServices.get(i) + ", ";
			  }
			  serviceInfo += disableServices.get(disableServices.size() - 1);
		  }
		  
		  if (foodServices != null) {
			  serviceInfo += " \n";
			  serviceInfo += "\nBooked food services are: \n";
			  for (int i = 0; i < foodServices.size() - 1; i++) {
				  serviceInfo += foodServices.get(i) + ", ";
			  }
			  serviceInfo += foodServices.get(foodServices.size() - 1);
		  }
		  
		  return serviceInfo;
	  }
	  
	  // Method to format the user's seat into letters and numbers 
	  private String formatSeatInfo(String seatClass, int row, int col) {
		  String seatInfo = "Seat at: ";
		  if (seatClass.equals("Economy Class")) {
			  String seat = String.valueOf(row + 5);
			  //skip the aisle
			  if (col <3) {
				 seat += (char) ('A' + col);  
			  } else if (col >= 4) {
				 seat += (char) ('A' + col - 1);
			  }
			  seatInfo += seat;
		  }
		  
		  if (seatClass.equals("First Class")) {
			  String seat = String.valueOf(row + 1);
			  //skip the aisle
			  if (col < 2) {
				 seat += (char) ('A' + col);  
			  } else if (col >= 3) {
				 seat += (char) ('A' + col - 1);
			  }
			  seatInfo += seat;
		  }
		  return seatInfo;
	  }
}

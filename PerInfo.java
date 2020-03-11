import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PerInfo extends JPanel implements ActionListener{
	JLabel label1 = new JLabel("  The Personially Information ");
    JLabel label2 = new JLabel("  Enter your Personially Information ");
	
	
	JButton finish                  = new JButton(" Finish-->>");
	JButton backPersonalIyInfoHome  = new JButton("<<--Back Information Home");
	JButton backHome                = new JButton("<<--Back Home");
	
	JTextField userEnter1;
	JTextField userEnter2;
	
	//JTextArea finishTextArea = new JTextArea("");
	
	
	JLabel image  = new JLabel(" ");
	JLabel image2 = new JLabel(" ");
	
	
	JPanel main   = new JPanel();
	JPanel panelC = new JPanel();
	JPanel panelN = new JPanel();
	JPanel panelW = new JPanel();
	JPanel panelS = new JPanel();
	JPanel panelEnter = new JPanel();
	JPanel panelShow = new JPanel();
	
	//private CardLayout card = new CardLayout();
	
    private ImageIcon Picture;
	private Image Img;
	private ImageIcon Picture2;
	private Image Img2;
	
	
	private Fly flyContainer;
	
	public PerInfo(Fly container) {
		
		flyContainer = container;
		setSize(800,800);
		setLayout(new BorderLayout());
		
		 label1.setFont(new Font("Arial", Font.BOLD, 25));
		 setJLableBackGround(label1, Color.BLACK,new Color(100,149,237));
		 label2.setFont(new Font("Arial", Font.BOLD, 25));
		 setJLableBackGround(label1, Color.BLACK,new Color(100,149,237));
		
		 
		 setJButtonBackGround(finish, Color.BLACK,new Color(100,149,237));
		 setJButtonBackGround( backPersonalIyInfoHome, Color.BLACK,new Color(100,149,237));
		 setJButtonBackGround(backHome, Color.BLACK,new Color(100,149,237));
		 
		userEnter1= new JTextField("Please enter your name Fist Last",12);
	 	userEnter2= new JTextField("Please enter your pastport number",12);
	 	
		 
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
		panelW.add( backPersonalIyInfoHome);
		panelW.add(backHome);
		
		main.add(panelN, BorderLayout.NORTH);
		main.add(panelS, BorderLayout.SOUTH);
		main.add(panelW, BorderLayout.WEST);
		main.add(panelC, BorderLayout.CENTER);
		
		add(main);
		
		finish.addActionListener(this);
		backHome.addActionListener(this);
		 backPersonalIyInfoHome.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
		
		if(source == finish){
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(),"currentlyFightInfo");
			
			setCurUserInfo();
			String curInfo = getCurInfo();
			flyContainer.setCurFlightInfo(curInfo);
		}else if(source == backPersonalIyInfoHome) {
			
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(),"personiallyInfoHomePanel");
		}else if(source == backHome) {
			
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(), "HomePanel");
			//reset the information
			flyContainer.reset();
		}
		
	}
	public void setJButtonBackGround(JButton b, Color FC,Color BC) {
		
		b.setForeground(FC);       
		b.setBackground(BC);       
		b.setOpaque(true);               
		b.setBorderPainted(false);        
	}
   public void setJLableBackGround(JLabel l, Color FC,Color BC) {
		l.setOpaque(true);  
		l.setBackground(BC);
		l.setForeground(FC);
		
	}
   public void setJTextAreaBackGround(JTextArea t, Color FC,Color BC) {
		t.setOpaque(true);  
		t.setBackground(BC);
		t.setForeground(FC);
		
	}
	
   public void reset() {
		userEnter1.setText("Please enter your name Fist Last"); 
	 	userEnter2.setText("Please enter your pastport number");
   }
   
   
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
   private String getCurInfo() {
		  User u = flyContainer.getCurUser();
		  Ticket t = flyContainer.getCurTicket();
		  Service s = flyContainer.getCurService();
		  
		  String userInfo = getUserInfo(u);
		  String ticketInfo = getTicketInfo(t);
		  String serviceInfo = getServiceInfo(s);
		  
		  return userInfo + "\n\n" + ticketInfo + "\n" + serviceInfo;
	  }
	  
	  private String getUserInfo(User u) {
		  String firstname = u.getFirstName();
		  String lastname = u.getLastName();
		  String passport = u.getPassport();
		  
		  String userInfo = "FirstName: " + firstname + "\t\t" + "LastName:" + lastname;
		  userInfo += "\nPassport: " + passport;
		  
		  return userInfo;
	  }
	  
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
		  
		  String ticketInfo = "Departure at: " + departAirport + "\t" + "Arrival at: " + destAirport + "\n";
		  ticketInfo += "Leaving on: " + departMonth + "/" + departDate + "/" + departYear + "\n";
		  if (t.isRoundTripTicket() == true) {
			  ticketInfo += "Return from: " + destAirport + "\t" + "Return at: " + departAirport + "\n";
			  ticketInfo += "Return on: " + returnMonth + "/" + returnDate + "/" + returnYear + "\n";
		  }
		  ticketInfo += "Cabin class: " + seatClass + "\n";
		  ticketInfo += "Seat at: Row " + seatRow + " Col " + seatCol;
		  
		  return ticketInfo;
		  
	  }
	  
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

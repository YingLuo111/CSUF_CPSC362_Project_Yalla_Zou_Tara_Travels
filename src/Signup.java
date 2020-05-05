import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// This is the Signup class. It uses ActionListener 
public class Signup extends JPanel implements ActionListener{
	
	// Initializing the JPanels, JLabels, JTextfields, JButtons
	// ImageIcons and Images 
	private JPanel panelHome         = new JPanel();
	private JPanel panelSignup       = new JPanel();
 
	private JLabel title             = new JLabel();
	private JLabel username          = new JLabel("     Username >>>");
	private JLabel password    		 = new JLabel("     Password >>>");
	private JLabel email           	 = new JLabel("     Email    >>>");
	private JTextField userText 	 = new JTextField("",20);
	private JTextField passText 	 = new JTextField("",20);
	private JTextField emailText 	 = new JTextField("",20);
	
	private JButton buttonSignup     = new JButton("Sign Up");
	private JButton buttonBack       = new JButton("Back");

	private JLabel image             = new JLabel(" ");
	private JLabel image2            = new JLabel(" ");

    private ImageIcon Picture;
	private Image Img;
	private ImageIcon Picture2;
	private Image Img2;
	
	// Creating a variable flycontainer of type Fly
	private Fly flyContainer;
	
	// Creating a variable dbmgr of type DBManager
	private DBManager dbmgr;
	
	private String passwordStr = "";
	
	CardLayout cardLayout = new CardLayout();
	
	/*
	 * This is the constructor of the class, it uses the input for classes
	 * Fly and DBManager. It sets all of the JLabels, JButtons, JPanels, 
	 * Images, fonts, backgrounds, size and layout.
	 */
	public Signup(Fly container, DBManager dbmgr) {
	
		flyContainer = container;
		this.dbmgr = dbmgr;
		
		setLayout(cardLayout);
		setSize(1000,800);
	
		title = new JLabel("        Yalla Zou Tara Travels Login ");
	    title.setFont(new Font("PilGi", Font.BOLD, 40));
	    setJLableBackGround(title, Color.BLACK,new Color(135,206,250));
	
	    Font arial25 = new Font("Arial", Font.BOLD, 25);
	    buttonBack.setFont(arial25);
	    buttonBack.setToolTipText("返回\n"+ " بازگشت");
	    buttonSignup.setFont(arial25);
	    buttonSignup.setToolTipText("注册\n"+ "ثبت نام");
	    
	    username.setFont(arial25);
	    username.setToolTipText("用户名\n"+ "نام کاربری");
	    
	    password.setFont(arial25);
	    password.setToolTipText("密码\n" + "کلمه عبور");
	    
	    email.setFont(arial25);
	    email.setToolTipText("电子邮箱\n" + "پست الکترونیک");
	    
	    setJLableBackGround(username, Color.BLACK,new Color(176,224,230));
	    setJLableBackGround(password, Color.BLACK,new Color(95,158,160));
	    setJLableBackGround(email, Color.BLACK,new Color(32,178,170));

	    setJButtonBackGround(buttonBack, Color.BLACK,Color.YELLOW);
	    setJButtonBackGround(buttonSignup, Color.BLACK,Color.PINK);

        Picture = new ImageIcon("resources/Images/HomeImagenorth.png");
		Img = Picture.getImage().getScaledInstance(900, 300, java.awt.Image.SCALE_SMOOTH);
		image.setIcon(new ImageIcon(Img));
	
		Picture2 = new ImageIcon("resources/Images/HomeImageSorth.png");
		Img2 = Picture2.getImage().getScaledInstance(900, 300, java.awt.Image.SCALE_SMOOTH);
		image2.setIcon(new ImageIcon(Img2));
		
		panelSignup.setLayout(new GridLayout(4, 2));
		panelSignup.add(username);
		panelSignup.add(userText);
		panelSignup.add(password);
		panelSignup.add(passText);
		panelSignup.add(email);
		panelSignup.add(emailText);
		panelSignup.add(buttonBack);
		panelSignup.add(buttonSignup);
	
		panelHome.setLayout(new GridLayout(4, 1));
		panelHome.add(image);
		panelHome.add(title); 
		panelHome.add(panelSignup);
		panelHome.add(image2);
		add(panelHome,"Panel1");
		
		buttonBack.addActionListener(this);
		buttonSignup.addActionListener(this);
		
		// Key listener method to hide the user's password input 
		// changing the characters to "*"
	    KeyListener keyListener = new KeyListener() {
	        public void keyPressed(KeyEvent keyEvent) {}

	        public void keyReleased(KeyEvent keyEvent) {
	        	char key = keyEvent.getKeyChar();
	        	if (Character.isAlphabetic(key) || Character.isDigit(key)) {
		            JTextField textField = (JTextField) keyEvent.getSource();
		            String text = textField.getText();
		            if (text.length() == 1) {
		            	passwordStr = "";
		            }
		            
		            passwordStr += text.substring(text.length() - 1);
		            String newText = text.substring(0, text.length() - 1) + "*";
		            textField.setText(newText);	
	        	}
		    }

	        public void keyTyped(KeyEvent keyEvent) {}
	      };
	      
	      passText.addKeyListener(keyListener);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		// When the user selects "Back" button, "LoginPanel" appears 
		if(source == buttonBack){
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(), "LoginPanel");
		}
		
		// When the user selects "Sign Up" button, the user's input is read 
		// by the program
		else if(source == buttonSignup){
			String username = userText.getText();
			String password = passwordStr;
			String email    = emailText.getText();
			
			if (! validateUsername(username) || ! validatePassword(password) || ! validateEmail(email)) {
				return;
			}
			
			// If the user's inputs are valid, they sign up successfully
			if (dbmgr.insertUserEntryToDB(username, password, email)) {
				int clicked = JOptionPane.showOptionDialog(null, "Sign up succeed! Now navigate to log in.", "Congratulations!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

				if(clicked == JOptionPane.OK_OPTION)
				{
					CardLayout flyCardLayout = flyContainer.getCardLayout();
					flyCardLayout.show(flyContainer.getContentPane(), "LoginPanel");
				}
			} 
			
			// If the user's inputs are invalid, the sign up is unsuccessful
			else {
				JOptionPane.showMessageDialog(null, "Sorry, sign up failed, please try again.");
			}
		}
	}
	
	// Method to set JButton Background 
   public void setJButtonBackGround(JButton b, Color FC,Color BC) {
		b.setForeground(FC);       
		b.setBackground(BC);       
		b.setOpaque(true);               
		b.setBorderPainted(false);        
	}
  
   // Method to set JLabel Background
   public void setJLableBackGround(JLabel l, Color FC,Color BC) {
		l.setOpaque(true);  
		l.setBackground(BC);
		l.setForeground(FC);
	}
  
   // Boolean method to check if the username is valid 
	private boolean validateUsername(String username) {
		boolean result = false;
		if (username != null && username.length() > 0) {
			result = true;
		} else {
			JOptionPane.showMessageDialog(null, "Username could not be empty, please enter a username!");
		}
		return result;
	}
	
	// Boolean method to check if password is valid 
	private boolean validatePassword(String password) {
		boolean result = false;
		if (password != null && password.length() > 0) {
			result = true;
		} else {
			JOptionPane.showMessageDialog(null, "Password could not be empty, please enter a password!");
		}
		return result;
	}
	
	// Boolean method to check if email is valid
	private boolean validateEmail(String email) {
		boolean result = false;
		if (email != null && email.length() > 0) {
			result = true;
		} else {
			JOptionPane.showMessageDialog(null, "Email could not be empty, please enter an email!");
		}
		return result;
	}
}

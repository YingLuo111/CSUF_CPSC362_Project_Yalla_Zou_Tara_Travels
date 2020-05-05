/*
 * This is the class of main JPanel Home
 * Home class extends JPanel
 * This class includes the two subhome buttons
 * and it can go to one of the other sub two home classes
 * by clicking the button
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

// This is the Home class 
public class Home extends JPanel implements ActionListener{
	
	// Initializing the JPanels, JLabels, JButtons, ImageIcons and Images
	private JPanel panelHome         = new JPanel();
	private JPanel panelButton       = new JPanel();

	private JLabel title             = new JLabel();

	private JButton buttonSelect     = new JButton("Book a Flight");
	//**
	//private JButton buttonInfomation = new JButton("Flight Information");
 	//private JButton buttonSevice     = new JButton("More Services");
	
	private JButton buttonPersinal   = new JButton("Personal Information");

	private JLabel image             = new JLabel(" ");
	private JLabel image2            = new JLabel(" ");
	
   	private ImageIcon Picture;
	private Image Img;
	private ImageIcon Picture2;
	private Image Img2;
	
	//Initialize the JFrame flyContainer from Fly class
	private Fly flyContainer;
	
	CardLayout cardLayout = new CardLayout();
	
	// Home class constructor
	public Home(Fly container) {
		
		// Setting the layout, size, title, fonts, backgrounds, tool tips
		// Images, and JButtons 
		flyContainer = container;
		setLayout(cardLayout);
		setSize(1000,800);
		
		title = new JLabel("        Yalla Zou Tara Travels ");
		title.setFont(new Font("PilGi", Font.BOLD, 40));
		setJLableBackGround(title, Color.BLACK,new Color(135,206,250));
		buttonSelect.setFont(new Font("Arial", Font.BOLD, 25));
		buttonSelect.setToolTipText("航班选择\n" + "پروازها");
//	    	buttonInfomation.setFont(new Font("Arial", Font.BOLD, 25));
//	    	buttonSevice.setFont(new Font("Arial", Font.BOLD, 25));
	    	buttonPersinal.setFont(new Font("Arial", Font.BOLD, 25));
	    	buttonPersinal.setToolTipText("个人信息\n" + "اطلاعات شخصی");
	    
	 	setJButtonBackGround(buttonSelect, Color.BLACK,Color.YELLOW);
//	    	setJButtonBackGround(buttonInfomation, Color.BLACK,Color.PINK);
//	    	setJButtonBackGround(buttonSevice, Color.BLACK,new Color(50,205,50));
	    	setJButtonBackGround(buttonPersinal, Color.BLACK,new Color(32,178,170));
	  
        	Picture = new ImageIcon("resources/Images/HomeImagenorth.png");
		Img = Picture.getImage().getScaledInstance(900, 300, java.awt.Image.SCALE_SMOOTH);
		image.setIcon(new ImageIcon(Img));
		
		Picture2 = new ImageIcon("resources/Images/HomeImageSorth.png");
		Img2 = Picture2.getImage().getScaledInstance(900, 300, java.awt.Image.SCALE_SMOOTH);
		image2.setIcon(new ImageIcon(Img2));
		
		panelButton.setLayout(new GridLayout(1, 2));
		panelButton.add(buttonSelect);
//		panelButton.add(buttonInfomation);
//		panelButton.add(buttonSevice);
		panelButton.add(buttonPersinal);
		
		panelHome.setLayout(new GridLayout(4, 1));
		panelHome.add(image);
		panelHome.add(title); 
		panelHome.add(panelButton);
		panelHome.add(image2);
		add(panelHome,"Panel1");
		
		buttonSelect.addActionListener(this);
//		buttonInfomation.addActionListener(this);
//		buttonSevice.addActionListener(this);
		buttonPersinal.addActionListener(this);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		// If user selects "Select Button", "SelectButtonsHomePanel" appears
		if(source == buttonSelect){
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(), "SelectButtonsHomePanel");
//		}else if(source == buttonInfomation){
//			CardLayout flyCardLayout = flyContainer.getCardLayout();
//			flyCardLayout.show(flyContainer.getContentPane(),"informationHomePanel");
//		}else if(source == buttonSevice) {
//			CardLayout flyCardLayout = flyContainer.getCardLayout();
//			flyCardLayout.show(flyContainer.getContentPane(), "seviceHomePanel");
		}
		
		// If user selects "Personal Button", "PersoniallyInfoHomePanel" appears
		else if(source == buttonPersinal) {
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(),"personiallyInfoHomePanel");
		}
	}
	
	// Method to set JButton background
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
}

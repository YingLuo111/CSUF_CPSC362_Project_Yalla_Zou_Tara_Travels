/*
 * This the sub JPanel for the JPanel Baby help
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//This is the class of the JPanel BabyHelp and implements ActionListener
public class BabyHelp extends JPanel implements ActionListener, ItemListener{
	//Initializes all of the JLabels, JButtons, JComboBoxes and JPanels
	
	JLabel label1            = new JLabel("The Baby/Child Service ");
	JLabel label2            = new JLabel(" Please Select");
	JLabel label3            = new JLabel(" What Service Do You Need To Reserve?");
	JButton finish           = new JButton("Finish or Skip to Next -->>");
	JButton backMoreSevice   = new JButton("<<--Back More Service");
	JButton backHome         = new JButton("<<--Back Home");
	
	JLabel image  = new JLabel(" ");
	JLabel image2 = new JLabel(" ");
	JLabel image3 = new JLabel(" ");
	
	JPanel main   = new JPanel();
	JPanel panelC = new JPanel();
	JPanel panelN = new JPanel();
	JPanel panelW = new JPanel();
	JPanel panelE = new JPanel();
	JPanel panelS = new JPanel();
   
    private JCheckBox babyBasket;
    private JCheckBox childUnaccompaniedMinor;
    
    private ImageIcon Picture;
	private Image Img;
	private ImageIcon Picture2;
	private Image Img2;
	private ImageIcon Picture3;
	private Image Img3;

	private Fly flyContainer;
	
	/*
	 * This is the constructor of this class. It sets all of the JLabels,
	 * JButtons, JPanels, font, backgound, size and layout 
	 */
	public BabyHelp(Fly container) {
		
		flyContainer = container;
		setSize(800,800);
		setLayout(new BorderLayout());
		
		Font arial25 = new Font("Arial", Font.BOLD, 25);
		label1.setFont(arial25);
		setJLableBackGround(label1, Color.BLACK,new Color(255,240,245));
		label2.setFont(arial25);
		setJLableBackGround(label2, Color.BLACK,new Color(255,240,245));
		label3.setFont(new Font("Arial", Font.BOLD, 15));
		setJLableBackGround(label3, Color.BLACK,new Color(255,240,245));
		 
		setJButtonBackGround(finish, Color.BLACK,new Color(255,240,245));
		setJButtonBackGround(backMoreSevice, Color.BLACK,new Color(255,240,245));
		setJButtonBackGround(backHome, Color.BLACK,new Color(255,240,245));
		
		Picture = new ImageIcon("resources/Images/subtitle.png");
		Img = Picture.getImage().getScaledInstance(900, 250, java.awt.Image.SCALE_SMOOTH);
		image.setIcon(new ImageIcon(Img));
		
		Picture2 = new ImageIcon("resources/Images/service-imgey.png");
		Img2 = Picture2.getImage().getScaledInstance(900, 150, java.awt.Image.SCALE_SMOOTH);
		image2.setIcon(new ImageIcon(Img2));
		
		Picture3 = new ImageIcon("resources/Images/babyImage.png");
		Img3     = Picture3.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
		image3.setIcon(new ImageIcon(Img3));
		
		babyBasket              = new JCheckBox("Baby Basket", false);
		childUnaccompaniedMinor = new JCheckBox("Unaccompanied Minor", false);

		main.setLayout(new BorderLayout());
		
		panelN.add(image);
		panelS.add(image2);
		
		panelC.setBackground(new Color(255,240,245));
		panelC.setLayout(new GridLayout(4,1));
		panelC.add(label2);
		panelC.add(label3);
		panelC.add(babyBasket);
		panelC.add(childUnaccompaniedMinor);
		
		panelW.setBackground(new Color(255,240,245));
		panelW.setLayout(new GridLayout(4, 1));
		panelW.add(label1);
		panelW.add(finish);
		panelW.add(backMoreSevice);
		panelW.add(backHome);
		
		panelE.add(image3);
		
		main.add(panelN, BorderLayout.NORTH);
		main.add(panelS, BorderLayout.SOUTH);
		main.add(panelW, BorderLayout.WEST);
		main.add(panelE, BorderLayout.EAST);
		main.add(panelC, BorderLayout.CENTER);
		
		add(main);
		
		finish.addActionListener(this);
		backHome.addActionListener(this);
		backMoreSevice.addActionListener(this);
		
		babyBasket.addItemListener(this);
		childUnaccompaniedMinor.addItemListener(this);
		
	}
	
	/*
	 * This is the actionperformed to execute the button's actions
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
		// When the user selects "Finish" button, "foodHelpPanel" appears
		if(source == finish){
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(),"foodHelpPanel");
			
			Service curService = flyContainer.getCurService();
			
			if (babyBasket.isSelected()) {
				curService.addBabyService("Baby Basket");
			}
			if (childUnaccompaniedMinor.isSelected()) {
				curService.addBabyService("Unaccompanied Child");
			}	
		}
		
		// When user selects "Back More Service" button, "serviceHomePanel" appears
		else if(source == backMoreSevice) {
			
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(),"seviceHomePanel");
		}
		
		// When user selects "Back Home" button, "HomePanel" appears 
		else if(source == backHome) {
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(), "HomePanel");
			
			// Information resets
			flyContainer.reset();
		}	
	}
	
	// Method to set the JButton Background
	public void setJButtonBackGround(JButton b, Color FC,Color BC) {
		b.setForeground(FC);       
		b.setBackground(BC);       
		b.setOpaque(true);               
		b.setBorderPainted(false);        
	}
	
	// Method to set the JLabel background
 	public void setJLableBackGround(JLabel l, Color FC,Color BC) {
		l.setOpaque(true);  
		l.setBackground(BC);
		l.setForeground(FC);
	}
	
	// Method to set the JTextArea background
   	public void setJTextAreaBackGround(JTextArea t, Color FC,Color BC) {
		t.setOpaque(true);  
		t.setBackground(BC);
		t.setForeground(FC);
	}

   @Override
   public void itemStateChanged(ItemEvent e) {}
	
   // Method to reset the JCheckBoxes
	public void reset() {
		babyBasket.setSelected(false);              
		childUnaccompaniedMinor.setSelected(false); 
	}
}

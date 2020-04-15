/*
 * This the sub JPanel for the JPanel luggage
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//This is the class of the JPanel Luggage and implements ActionListener
public class Luggage extends JPanel implements ActionListener{
	//Initialize all of the JLable, JButton,JComboBox and JPanel
    JLabel label1 = new JLabel("  The Luggage information ");
	
	JButton firstBusinessClass        = new JButton("First Class/Business Class");
	JButton economyClass              = new JButton(" Economy Class");
	JButton backSevice                = new JButton("<<--Back Information Home");
	JButton backHome                  = new JButton("<<--Back Home");
	
	JTextArea firstBusinessLabel         = new JTextArea("");
	JTextArea economyClassLabel          = new JTextArea("");
	
	JLabel image = new JLabel(" ");
	JLabel image2 = new JLabel(" ");
	
	
	JPanel main = new JPanel();
	JPanel panelC = new JPanel();
	JPanel panelN = new JPanel();
	JPanel panelW = new JPanel();
	JPanel panelS = new JPanel();
	
	
    private ImageIcon Picture;
	private Image Img;
	private ImageIcon Picture2;
	private Image Img2;
	
	
	private Fly flyContainer;
	/*
	 * This is the constructor  of this class
	 *this consturctor setting the all of the JLabel's
	 *JButton's, JPanel's font,backgound, size and layout 
	 */
	public Luggage(Fly container) {
		
		flyContainer = container;
		setSize(800,800);
		setLayout(new BorderLayout());
		
		 label1.setFont(new Font("Arial", Font.BOLD, 25));
		 setJLableBackGround(label1, Color.BLACK,new Color(135,206,250));
		 
		 firstBusinessLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		 setJTextAreaBackGround(firstBusinessLabel, Color.BLACK,new Color(135,206,250));
		 
		 economyClassLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		 setJTextAreaBackGround(economyClassLabel, Color.BLACK,new Color(135,206,250));
		 
		 setJButtonBackGround(firstBusinessClass, Color.BLACK,new Color(135,206,250));
		 setJButtonBackGround(economyClass, Color.BLACK,new Color(135,206,250));
		 setJButtonBackGround(backSevice, Color.BLACK,new Color(135,206,250));
		 setJButtonBackGround(backHome, Color.BLACK,new Color(135,206,250));
		 
		 Picture = new ImageIcon("resources/Images/subtitle.png");
		Img = Picture.getImage().getScaledInstance(900, 250, java.awt.Image.SCALE_SMOOTH);
		image.setIcon(new ImageIcon(Img));
			
		Picture2 = new ImageIcon("resources/Images/infoImageSorth.png");
		Img2 = Picture2.getImage().getScaledInstance(900, 150, java.awt.Image.SCALE_SMOOTH);
		image2.setIcon(new ImageIcon(Img2));
		
		
		panelW.setBackground(new Color(135,206,250));
		main.setLayout(new BorderLayout());
		panelN.add(image);
		panelS.add(image2);
		
		panelC.setBackground(new Color(135,206,250));
		panelC.add(firstBusinessLabel);
		panelC.add(economyClassLabel);
		
		panelW.setLayout(new GridLayout(5, 1));
		panelW.add(label1);
		panelW.add(firstBusinessClass);
		panelW.add(economyClass);
		panelW.add(backSevice);
		panelW.add(backHome);
		
		main.add(panelN, BorderLayout.NORTH);
		main.add(panelS, BorderLayout.SOUTH);
		main.add(panelW, BorderLayout.WEST);
		main.add(panelC, BorderLayout.CENTER);
		
		add(main);
		
		firstBusinessClass.addActionListener(this);
		economyClass.addActionListener(this);
		backHome.addActionListener(this);
		backSevice.addActionListener(this);
	}
	/*
	 * This is the actionperformed to execute the button's action 
	 * if the user click the different buttonSelect go to the  different Select action
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
		
		if(source == firstBusinessClass){
			firstBusinessLabel.setVisible(true);
			firstBusinessLabel.setText("We will specify the maximum dimensions\n"
					                 + " and/or weight of carry-on baggage taken \n"
					                 + "into the cabin. Each First Class/Business\n"
					                 + " Class passenger can carry two (2) pieces of\n"
					                 + " carry-on baggage, with each weighing no more\n"
					                 + " than eight (8) kilos (17 lbs.). \n" );
			economyClassLabel.setVisible(false);
		}else if(source == economyClass){
			economyClassLabel.setVisible(true);
			economyClassLabel.setText("Each Economy Class passenger can carry up \n"
					                 + "to one piece of carry-on baggage that weighs\n"
					                 + " no more than five (5) kilos (11 lbs.).");
			
			firstBusinessLabel.setVisible(false);
		}else if(source == backSevice) {
			
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(),"informationHomePanel");
			
		}else if(source == backHome) {
			
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(), "HomePanel");
			//reset the information
			flyContainer.reset();
		}
		
	}
	/*
	 * This is the method to set the JButton Background 
	 * This is the method to set the JLabel Background 
	 * This is the method to set the JTextArea Background 
	 */
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
		firstBusinessLabel.setVisible(false);
		economyClassLabel.setVisible(false);
   }
}



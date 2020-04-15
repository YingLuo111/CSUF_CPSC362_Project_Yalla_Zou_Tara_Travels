/*
 * This the sub JPanel for the JPanel Seclect
 * The user can enter the Name and ticket number and date
 * And the fight ticket will be cancel 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//This is the class of the JPanel Oneline Rdfound and implements ActionListener
public class OnlineRefound extends JPanel implements ActionListener{
	//Initialize all of the JLable, JButton,JComboBox and JPanel
	private JLabel label1 = new JLabel("  Online Refound ");
	private JLabel label2 = new JLabel("Enter Name,Tickit number and Date agina ");
		
		
	private JButton subMit                = new JButton(" Submit");
	private JButton reEnter               = new JButton(" Reenter");
	private JButton backSevice            = new JButton("<<--Back Sevice Home");
	private JButton backHome              = new JButton("<<--Back Home");
		
	private JTextField userEnter1;
	private JTextField userEnter2;
	private JTextField userEnter3;
	private JTextField userEnter4;
	private JTextField userEnter5;
		
	private JTextArea subMitTextArea = new JTextArea("");
		
		
	private JLabel image  = new JLabel(" ");
	private JLabel image2 = new JLabel(" ");
		
		
	private JPanel main   = new JPanel();
	private JPanel panelC = new JPanel();
	private JPanel panelN = new JPanel();
	private JPanel panelW = new JPanel();
	private JPanel panelS = new JPanel();
	private JPanel panelEnter = new JPanel();
	private JPanel panelShow = new JPanel();
		
		//private CardLayout card = new CardLayout();
		
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
		public OnlineRefound(Fly container) {
			
			flyContainer = container;
			setSize(800,800);
			setLayout(new BorderLayout());
			
			 label1.setFont(new Font("Arial", Font.BOLD, 25));
			 setJLableBackGround(label1, Color.BLACK,new Color(135,206,250));
			 label2.setFont(new Font("Arial", Font.BOLD, 25));
			 setJLableBackGround(label1, Color.BLACK,new Color(135,206,250));
			 
			 subMitTextArea.setFont(new Font("Arial", Font.PLAIN, 17));
			 setJTextAreaBackGround(subMitTextArea, Color.BLACK,new Color(135,206,250));
			 
			 setJButtonBackGround(subMit, Color.BLACK,new Color(135,206,250));
			 setJButtonBackGround(reEnter, Color.BLACK,new Color(135,206,250));
			 setJButtonBackGround(backSevice, Color.BLACK,new Color(135,206,250));
			 setJButtonBackGround(backHome, Color.BLACK,new Color(135,206,250));
			 
			userEnter1= new JTextField("Please your Name",12);
			userEnter5= new JTextField("Please your Ticket number",12);
		 	userEnter2= new JTextField("Please enter the month",12);
		 	userEnter3= new JTextField("Please enter the day",12);
		 	userEnter4= new JTextField("Please enter the year",12);
			 
			Picture = new ImageIcon("resources/Images/subtitle.png");
			Img = Picture.getImage().getScaledInstance(900, 250, java.awt.Image.SCALE_SMOOTH);
			image.setIcon(new ImageIcon(Img));
			
			Picture2 = new ImageIcon("resources/Images/selectImageSorth.png");
			Img2 = Picture2.getImage().getScaledInstance(900, 150, java.awt.Image.SCALE_SMOOTH);
			image2.setIcon(new ImageIcon(Img2));
			
			userEnter1.setVisible(true);
			userEnter2.setVisible(true);
			userEnter3.setVisible(true);
			userEnter4.setVisible(true);
			
			panelW.setBackground(new Color(135,206,250));
			main.setLayout(new BorderLayout());
			panelN.add(image);
			panelS.add(image2);
			
			
			panelEnter.setBackground(new Color(135,206,250));
			panelEnter.setLayout(new GridLayout(5,1));
			panelEnter.add(label2);
			panelEnter.add(userEnter1);
			panelEnter.add(userEnter2);
			panelEnter.add(userEnter3);
			panelEnter.add(userEnter4);
			
			panelShow.setBackground(new Color(135,206,250));
			panelShow.add(subMitTextArea,BorderLayout.CENTER);
			
			panelC.setBackground(new Color(135,206,250));
			panelC.add(panelEnter,BorderLayout.CENTER);
			panelC.add(panelShow,BorderLayout.CENTER);
			
			
			
			
			panelW.setLayout(new GridLayout(5, 1));
			panelW.add(label1);
			panelW.add(reEnter);
			panelW.add(subMit);
			panelW.add(backSevice);
			panelW.add(backHome);
			
			main.add(panelN, BorderLayout.NORTH);
			main.add(panelS, BorderLayout.SOUTH);
			main.add(panelW, BorderLayout.WEST);
			main.add(panelC, BorderLayout.CENTER);
			
			add(main);
			
			
			subMit.addActionListener(this);
			reEnter.addActionListener(this);
			backHome.addActionListener(this);
			backSevice.addActionListener(this);
			
		}
		/*
		 * This is the actionperformed to execute the button's action 
		 * if the user click the different buttonSelect go to the  different Select subPanel
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
	        Object source = e.getSource();
			
			if(source == subMit){
				userEnter1.setVisible(false);
				userEnter2.setVisible(false);
				userEnter3.setVisible(false);
				userEnter4.setVisible(false);
				userEnter5.setVisible(false);
				subMitTextArea.setVisible(true);
				subMitTextArea.setText("On "+ userEnter2.getText()+ " - " +userEnter3.getText()+" - "+
						                 userEnter4.getText()+"\n"+ "The "+ userEnter1.getText() + "\n"+
						                 "Thanks you choice Holiday Air Company\n"+
						                 "Your tickit cancel successful.\n"+
						                 "You will get refound money at 24 hours\n"+
						                 "Hope you will choice our Company next time.\n"+
						                 "Have a nice day. =^.^= ");
				
			}else if(source == reEnter) {
			
				subMitTextArea.setVisible(false);
				userEnter1.setVisible(true);
				userEnter5.setVisible(true);
				userEnter2.setVisible(true);
				userEnter3.setVisible(true);
				userEnter4.setVisible(true);
				
				
			}else if(source == reEnter) {
			
				subMitTextArea.setVisible(false);
				userEnter1.setVisible(true);
				userEnter5.setVisible(true);
				userEnter2.setVisible(true);
				userEnter3.setVisible(true);
				userEnter4.setVisible(true);
				
				
			}else if(source == backSevice) {
				
				CardLayout flyCardLayout = flyContainer.getCardLayout();
				flyCardLayout.show(flyContainer.getContentPane(),"SelectButtonsHomePanel");
				
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
	//This is the reset mothed to reset the information
	    public void reset() {
			userEnter1.setText("Please your Name"); 
			userEnter5.setText("Please your Ticket number");
		 	userEnter2.setText("Please enter the month");
		 	userEnter3.setText("Please enter the day");
		 	userEnter4.setText("Please enter the year");
	    }
}

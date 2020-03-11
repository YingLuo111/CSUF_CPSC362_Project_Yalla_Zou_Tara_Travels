import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CurrentlyFightInfo extends JPanel implements ActionListener{
	JLabel label1 = new JLabel(" Congratulations ! ");
    JLabel label2 = new JLabel("  Enter City and Date agina ");
	
	
    JButton finish                  = new JButton(" Finish-->>");
	JButton backPersonalIyInfoHome  = new JButton("<<--Back Personal Information Home");
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
	
	private Fly flyContainer;
	
	public CurrentlyFightInfo(Fly container) {
		
		flyContainer = container;
		setSize(800,800);
		setLayout(new BorderLayout());
		
		 label1.setFont(new Font("Arial", Font.BOLD, 25));
		 setJLableBackGround(label1, Color.BLACK,new Color(135,206,250));
		 label2.setFont(new Font("Arial", Font.BOLD, 25));
		 setJLableBackGround(label1, Color.BLACK,new Color(135,206,250));
		 
		 
		 setJButtonBackGround(finish, Color.BLACK,new Color(135,206,250));
		 setJButtonBackGround(backPersonalIyInfoHome, Color.BLACK,new Color(135,206,250));
		 setJButtonBackGround(backHome, Color.BLACK,new Color(135,206,250));
		 
		Picture = new ImageIcon("resources/Images/subtitle.png");
		Img = Picture.getImage().getScaledInstance(900, 200, java.awt.Image.SCALE_SMOOTH);
		image.setIcon(new ImageIcon(Img));
		
		Picture2 = new ImageIcon("resources/Images/personalImageSorth.png");
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
		panelW.setLayout(new GridLayout(4, 1));
		panelW.add(label1);
		panelW.add(finish);
		panelW.add(backPersonalIyInfoHome);
		panelW.add(backHome);
		
		main.add(panelN, BorderLayout.NORTH);
		main.add(panelS, BorderLayout.SOUTH);
		main.add(panelW, BorderLayout.WEST);
		main.add(panelC, BorderLayout.CENTER);
		
		add(main);
		
		
		finish.addActionListener(this);
		backPersonalIyInfoHome.addActionListener(this);
		backHome.addActionListener(this);
	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
		
		if(source == backPersonalIyInfoHome){
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(),"personiallyInfoHomePanel");
			
		}else if(source == finish) {
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(), "HomePanel");
			flyContainer.reset();
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
		finalInfo.setText(""); 
   }

   public void setDisplayedInfo(String info) {
	   finalInfo.setText(info);
   }
}


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class RightPanel extends JPanel implements ActionListener
{
	JLabel userid,password,dev,lak,ros,aka;
	Label prompt;
	JTextField usertf;
	JPasswordField pwf;
	JButton login,reset;
	JFrame mf;
	Login lg;
	Font font=new Font("Arial",Font.BOLD,15);
	Font font2=new Font("Times New Roman",Font.BOLD,30);
	Font font1=new Font("Times New Roman",Font.ITALIC,35);
	JLabel photo1;
	public RightPanel(Login lg)
	{
		this.lg=lg;
		setLayout(null);
		photo1=new JLabel(new ImageIcon("Logi.JPG"));
		add(photo1);
		photo1.setBounds(20,40,400,170);
		userid=new JLabel("User Name");
		password=new JLabel("Password");
		dev=new JLabel("Devloped By:");
		lak=new JLabel("B Ocean Patro");
		ros=new JLabel("I Lakshmi Narayana");
		aka=new JLabel(" ");
		usertf=new JTextField(10);
		pwf=new JPasswordField(10);
		login=new JButton("Login");
		reset=new JButton("Reset");
		add(dev);
		dev.setFont(font2);
		dev.setBounds(60,420,300,50);
		add(lak);
		lak.setFont(font1);
		lak.setBounds(120,470,300,50);
		add(ros);
		ros.setFont(font1);
		ros.setBounds(120,520,300,50);
		add(aka);
		aka.setFont(font1);
		aka.setBounds(120,570,300,50);
		add(userid);
		userid.setBounds(130,250,100,25);
		userid.setFont(font);
		add(usertf);
		usertf.setBounds(230,250,100,25);
		add(password);
		password.setBounds(130,300,100,25);
		password.setFont(font);
		add(pwf);
		pwf.setBounds(230,300,100,25);
		add(login);
		login.setBounds(130,350,80,25);
		add(reset);
		reset.setBounds(250,350,80,25);
		login.addActionListener(this);//registration
		reset.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==reset)
		{
			usertf.setText("");
			pwf.setText("");
			usertf.requestFocus();
		}
		else
			if(ae.getSource()==login)
			{
				String u,t;
				char p[];
				u=usertf.getText();
				p=pwf.getPassword();
				t=new String(p);
				if(u.equals("ece") && t.equals("ece"))
				{
						mf=new MainFrame();
						lg.setVisible(false);
				}
				if(u.equals("akash") && t.equals("akash"))
				{
						mf=new MainFrame();
						lg.setVisible(false);
				}
				if(u.equals("roshan") && t.equals("roshan"))
				{
						mf=new MainFrame();
						lg.setVisible(false);
				}
				if(u.equals("kanhu") && t.equals("kanhu"))
				{
						mf=new MainFrame();
			       		lg.setVisible(false);
				}
				if(u.equals("lakshmi") && t.equals("lakshmi"))
				{
						mf=new MainFrame();
						lg.setVisible(false);
				}
				else
				{
						usertf.setText("");
						pwf.setText("");
						usertf.requestFocus();
						try
						{
							prompt=new Label("Login Failed......TRY AGAIN");
							prompt.setBounds(70,400,400,25);
							prompt.setFont(font);
							prompt.setForeground(Color.red);
							add(prompt);
					    	Thread.sleep(1000);
					    	prompt.setText("");
							Thread.sleep(1000);
							prompt.setForeground(Color.blue);
							prompt.setText("Student is not present");
							prompt.setText("");
							remove(prompt);
						    Thread.sleep(1000);
					    }
					    catch(Exception e)
						{
							System.out.println(e);
			            }
		        }
			}
	}
}
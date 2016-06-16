import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainFrame extends JFrame implements ActionListener
{
	JButton k1,k2,k3,k4,k5,k6,k7;
	Font font=new Font("Arial",Font.BOLD,20);
	public MainFrame()
	{
		super("Library Management");//set the title
		setLayout(null);
		setSize(1200,750);
		setVisible(true);//view the frame
		k1=new JButton("Add New Book");
		k2=new JButton("Remove A Book");
		k3=new JButton("Search & Issue Book");
		k4=new JButton("Check");
		k5=new JButton("Return A Book");
		k6=new JButton("Add A Faculty");
		k7=new JButton("Add A Student");
		add(k1);
		k1.setBounds(400,75,500,50);
		k1.setFont(font);
		k1.setForeground(Color.blue);
		add(k2);
		k2.setBounds(400,150,500,50);
		k2.setFont(font);
		k2.setForeground(Color.blue);
		add(k3);
		k3.setBounds(400,225,500,50);
		k3.setFont(font);
		k3.setForeground(Color.blue);
		add(k4);
		k4.setBounds(400,300,500,50);
		k4.setFont(font);
		k4.setForeground(Color.blue);
		add(k5);
		k5.setBounds(400,375,500,50);
		k5.setFont(font);
		k5.setForeground(Color.blue);
		add(k6);
		k6.setBounds(400,450,500,50);
		k6.setFont(font);
		k6.setForeground(Color.blue);
		add(k7);
		k7.setBounds(400,525,500,50);
		k7.setFont(font);
		k7.setForeground(Color.blue);
		k1.addActionListener(this);
        k2.addActionListener(this);
        k3.addActionListener(this);
        k4.addActionListener(this);
        k5.addActionListener(this);
        k6.addActionListener(this);
        k7.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		Object src=ae.getSource();
		if(src==k1)
		{
			setVisible(false);
			AddFrame af=new AddFrame();
		}
		else if(src==k2)
		{
			setVisible(false);
			RemoveFrame tf=new RemoveFrame();
		}
		else if(src==k3)
		{
			setVisible(false);
			SearchFrame rf=new SearchFrame();
		}
		else if(src==k4)
		{
			setVisible(false);
			CheckFrame rf=new CheckFrame();
		}
		else if(src==k5)
		{
			setVisible(false);
			ReturnFrame rf=new ReturnFrame();
		}
		else if(src==k6)
		{
			setVisible(false);
			AddFac rf=new AddFac();
		}
		else if(src==k7)
		{
			setVisible(false);
			AddSt rf=new AddSt();
		}
	}
	public static void main(String args[])
	{
			MainFrame main=new MainFrame();
			main.requestFocus();
			main.setResizable(true);
			main.setVisible(true);
			main.setExtendedState(JFrame.MAXIMIZED_BOTH);
			main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
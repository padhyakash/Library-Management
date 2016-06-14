import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddSt extends JFrame implements ActionListener
{
	JLabel sid,name,year;
	JTextField sidt,namet,yeart;
	JButton save,close;
	Font font=new Font("Arial",Font.BOLD,20);
	MainFrame m=new MainFrame();
	Connect cn;
	Label prompt;
	public AddSt()
	{
		super("Add A Student");//set the title
		setLayout(null);
		setSize(1200,750);
		setVisible(true);
		setForeground(Color.red);
		cn=new Connect();
		sid=new JLabel("Student ID");
		sid.setForeground(Color.blue);
		sid.setFont(font);
		name=new JLabel("Student Name");
        name.setForeground(Color.blue);
        name.setFont(font);
		year=new JLabel("Batch");
		year.setForeground(Color.blue);
		year.setFont(font);
		sidt=new JTextField(10);
		namet=new JTextField(10);
		yeart=new JTextField(10);
		save=new JButton("Save");
		close=new JButton("Close");
		add(sid);
		sid.setBounds(400,50,170,25);
		add(sidt);
		sidt.setBounds(700,50,100,25);
		add(name);
	    name.setBounds(400,100,170,25);
		add(namet);
		namet.setBounds(700,100,100,25);
		add(year);
		year.setBounds(400,150,100,25);
		add(yeart);
		yeart.setBounds(700,150,100,25);
		add(save);
		save.setBounds(600,250,80,25);
		save.addActionListener(this);
		add(close);
	    close.setBounds(700,250,80,25);
	    close.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==close)
		{
			m.setVisible(true);
			this.setVisible(false);
		}
		else
		if(ae.getSource()==save)
		{
			String query="Insert into studentinfo values('";
			query+=sidt.getText()+"','"+namet.getText()+"',"+yeart.getText()+")";
			try
			{
				int cnt=cn.smt.executeUpdate(query);
				if(cnt==1)
				{
					prompt=new Label("One record inserted");
					prompt.setBounds(600,400,400,25);
					prompt.setFont(font);
					prompt.setForeground(Color.red);
					add(prompt);
					Thread.sleep(1000);
					prompt.setText("");
					Thread.sleep(1000);
					prompt.setForeground(Color.blue);
					prompt.setText("One record inserted");
					prompt.setText("");
					remove(prompt);
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
	public static void main(String args[])
    {
		AddSt main=new AddSt();
		main.requestFocus();
		main.setResizable(true);
		main.setVisible(true);
		main.setExtendedState(JFrame.MAXIMIZED_BOTH);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
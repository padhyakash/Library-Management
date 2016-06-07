import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddFac extends JFrame implements ActionListener
{
	JLabel fid,name;
	JTextField fidt,namet;
	JButton save,close;
	Font font=new Font("Arial",Font.BOLD,20);
	MainFrame m=new MainFrame();
	Connect cn;
	Label prompt;
	public AddFac()
	{
		super("Add A Faculty");//set the title
		setLayout(null);
		setSize(1200,750);
		setVisible(true);
		setForeground(Color.red);
		cn=new Connect();
		fid=new JLabel("Faculty ID");
		fid.setForeground(Color.blue);
		fid.setFont(font);
		name=new JLabel("Faculty Name");
		name.setForeground(Color.blue);
        name.setFont(font);
		fidt=new JTextField(10);
		namet=new JTextField(10);
		save=new JButton("Save");
		close=new JButton("Close");
		add(fid);
		fid.setBounds(400,50,170,25);
		add(fidt);
		fidt.setBounds(700,50,100,25);
		add(name);
	    name.setBounds(400,100,170,25);
		add(namet);
		namet.setBounds(700,100,100,25);
		add(save);
		save.setBounds(600,200,80,25);
		save.addActionListener(this);
		add(close);
	    close.setBounds(700,200,80,25);
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
			String query="Insert into faculty values(";
			query+=fidt.getText()+",'"+namet.getText()+"')";
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
		AddFac main=new AddFac();
		main.requestFocus();
		main.setResizable(true);
		main.setVisible(true);
		main.setExtendedState(JFrame.MAXIMIZED_BOTH);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
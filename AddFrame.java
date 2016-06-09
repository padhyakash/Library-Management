import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class AddFrame extends JFrame implements ActionListener
{
	JLabel bno,bname,aut,pub,edi,eyear,pri;
	JTextField bnotf,bnametf,auttf,pubtf,editf,eyeartf,pritf;
	JButton save,close;
	Font font=new Font("Arial",Font.BOLD,20);
	MainFrame m=new MainFrame();
	Connect cn;
	Label prompt;
	public AddFrame()
	{
		super("Add");//set the title
		setLayout(null);
		setSize(1200,750);
		setVisible(true);
		setForeground(Color.red);
		cn=new Connect();
		bno=new JLabel("Book Number");
		bno.setFont(font);
		bno.setForeground(Color.blue);
		bname=new JLabel("Book Name");
        bname.setFont(font);
        bname.setForeground(Color.blue);
		aut=new JLabel("Author");
		aut.setFont(font);
		aut.setForeground(Color.blue);
		pub=new JLabel("Publisher");
		pub.setFont(font);
		pub.setForeground(Color.blue);
		edi=new JLabel("Edition");
		edi.setFont(font);
		edi.setForeground(Color.blue);
		eyear=new JLabel("Year Of Edition");
		eyear.setFont(font);
		eyear.setForeground(Color.blue);
		pri=new JLabel("Price");
		pri.setFont(font);
		pri.setForeground(Color.blue);
		bnotf=new JTextField(10);
		String s="Select max(bno) from book";
		ResultSet ss;
		try
		{
		ss=cn.smt.executeQuery(s);
		if(ss.next())
        {
			bnotf.setText(""+(Integer.parseInt(ss.getString(1))+1));
			bnotf.setEditable(false);
		}
		}
		catch(Exception e)
		{
		}
		bnametf=new JTextField(10);
		auttf=new JTextField(10);
		pubtf=new JTextField(10);
		editf=new JTextField(10);
		eyeartf=new JTextField(10);
		pritf=new JTextField(10);
		save=new JButton("Save");
		close=new JButton("Close");
		add(bno);
		bno.setBounds(400,50,170,25);
		bno.setForeground(Color.blue);
		add(bnotf);
		bnotf.setBounds(700,50,100,25);
		add(bname);
	    bname.setBounds(400,100,170,25);
		bname.setForeground(Color.blue);
		add(bnametf);
		bnametf.setBounds(700,100,100,25);
		add(aut);
		aut.setBounds(400,150,100,25);
		aut.setForeground(Color.blue);
		add(auttf);
		auttf.setBounds(700,150,100,25);
		add(pub);
		pub.setBounds(400,200,100,25);
		pub.setForeground(Color.blue);
		add(pubtf);
		pubtf.setBounds(700,200,100,25);
		add(edi);
		edi.setBounds(400,250,100,25);
		edi.setForeground(Color.blue);
		add(editf);
		editf.setBounds(700,250,100,25);
		add(eyear);
		eyear.setBounds(400,300,180,25);
		eyear.setForeground(Color.blue);
		add(eyeartf);
		eyeartf.setBounds(700,300,100,25);
		add(pri);
		pri.setBounds(400,350,100,25);
		pri.setForeground(Color.blue);
		add(pritf);
		pritf.setBounds(700,350,100,25);
		add(save);
		save.setBounds(600,400,80,25);
		save.addActionListener(this);
		add(close);
	    close.setBounds(700,400,80,25);
	    close.addActionListener(this);
	    bnametf.requestFocus();

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
			String query="Insert into book values(";
			query+=bnotf.getText()+",'"+bnametf.getText()+"','"+auttf.getText()+"','"+pubtf.getText()+"',"+editf.getText()+","+eyeartf.getText()+","+pritf.getText()+",'y')";
			System.out.println(query);
			try
			{
				int cnt=cn.smt.executeUpdate(query);
				if(cnt==1)
				{
					prompt=new Label("One record inserted");
					prompt.setBounds(600,500,400,25);
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
		AddFrame main=new AddFrame();
		main.requestFocus();
		main.setResizable(true);
		main.setVisible(true);
		main.setExtendedState(JFrame.MAXIMIZED_BOTH);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
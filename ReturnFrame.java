import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import java.util.Locale;
import java.text.*;
public class ReturnFrame extends JFrame implements ActionListener
{
	JLabel id,fin;
	JTextField idtf;
	JLabel fintf;
	JFrame Return;
	JButton o;
	String q="",idate,rdate;
	Label prompt;
	Connect cn=new Connect();
	MainFrame m=new MainFrame();
	Font font=new Font("Arial",Font.BOLD,20);
	public ReturnFrame()
	{
		super("Return");//set the title
		setLayout(null);
		setSize(1200,750);
		setVisible(true);
		id=new JLabel("Enter Book Number");
		id.setForeground(Color.blue);
		id.setFont(font);
		fin=new JLabel("Fine Amount");
		fin.setForeground(Color.blue);
		fin.setFont(font);
	    idtf=new JTextField(10);
		fintf=new JLabel("Rs. 0.00");
		fintf.setForeground(Color.red);
		o=new JButton("OK");
		add(id);
		id.setBounds(400,200,200,25);
		add(idtf);
		idtf.setBounds(700,200,100,25);
		add(fin);
	    fin.setBounds(400,400,200,25);
		add(fintf);
		fintf.setFont(font);
		fintf.setBounds(725,400,100,25);
		add(o);
		o.setBounds(570,300,75,25);
		o.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==o)
		{
			this.setVisible(true);
	        q="select * from issue where bookno="+idtf.getText();
	        try
			{
				ResultSet rs;
				rs=cn.smt.executeQuery(q);
		        if(rs.next())
                {
					q="delete from issue where bookno="+idtf.getText();
					int x=cn.smt.executeUpdate(q);
				  if(x==1)
				  {
					prompt=new Label("Book Is Returned");
					prompt.setBounds(600,500,400,25);
					prompt.setFont(font);
					prompt.setForeground(Color.red);
					add(prompt);
					Thread.sleep(1000);
					prompt.setText("");
					Thread.sleep(1000);
					prompt.setForeground(Color.blue);
					prompt.setText("Book is Returned");
					prompt.setText("");
					remove(prompt);
				 }
					q="update book set status='y' where bno="+idtf.getText();
					x=cn.smt.executeUpdate(q);
				}
				else
				{
					q="select * from student where bookno="+idtf.getText();
					rs=cn.smt.executeQuery(q);
		            if(rs.next())
                    {
						q="select dateofissue from student where bookno="+idtf.getText();
						rs=cn.smt.executeQuery(q);
						if(rs.next())
					    	idate=rs.getString(1);
					    Date today=new Date();
						idate=idate.substring(0,10);
						Date issdate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(idate);
						int ndays=(int)( (today.getTime() - issdate.getTime()) / (1000 * 60 * 60 * 24));
						if(ndays>7)
						   fintf.setText("Rs. "+(ndays-7)*1+".00");
						q="delete from student where bookno="+idtf.getText();
						int x=cn.smt.executeUpdate(q);
						if(x==1)
						{
								prompt=new Label("Book Is Returned");
								prompt.setBounds(600,500,400,25);
								prompt.setFont(font);
								prompt.setForeground(Color.red);
								add(prompt);
								Thread.sleep(1000);
								prompt.setText("");
								Thread.sleep(1000);
								prompt.setForeground(Color.blue);
								prompt.setText("Book is Returned");
								prompt.setText("");
								remove(prompt);
				        }
						q="update book set status='y' where bno="+idtf.getText();
						x=cn.smt.executeUpdate(q);
					}
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
		ReturnFrame main=new ReturnFrame();
		main.requestFocus();
		main.setResizable(true);
		main.setVisible(true);
		main.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
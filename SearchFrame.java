import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class SearchFrame extends JFrame implements ActionListener,ItemListener
{
	JLabel sea,sa,ca,bno,fid,did,iss;
	JTextField seatf,st,bnot,fidt,didt;
	JFrame Search;
	JButton c,o,i;
	JRadioButton fac,stu;
	int cnt;
	ButtonGroup gp=new ButtonGroup();
	Connect cn;
	Label prompt=new Label("");
	String s=new String(" ");
	MainFrame m=new MainFrame();
	Font font=new Font("Arial",Font.BOLD,20);
	String head[]={"Book No.","Book Name","Auther","Publisher","Edition","Edition Year","Price"};
	String data[][]=new String[25][7];
	JTable table;

	public SearchFrame()
	{
	    super("Search & Issue");//set the title
		setLayout(null);
		setSize(1200,750);
		setVisible(true);
		cn=new Connect();
		fac=new JRadioButton("Faculty",true);
		stu=new JRadioButton("Student");
		gp.add(fac);
		gp.add(stu);
		add(fac);
		fac.setFont(font);
        fac.setBounds(200,400,400,25);
        fac.setForeground(Color.blue);
		add(stu);
		stu.setFont(font);
		stu.setForeground(Color.blue);
        stu.setBounds(200,450,400,25);
		JComboBox com=new JComboBox();
		com.addItem("Book Number");
		com.addItem("Book Name");
		com.addItem("Author");
		com.addItem("Publisher");
        add(com);
		com.setBounds(500,100,120,25);
		com.addItemListener(this);
        sa=new JLabel("Enter Book Number");
        sa.setForeground(Color.blue);
        ca=new JLabel("Category");
        iss=new JLabel("ISSUE");
        st=new JTextField(10);
        add(sa);
        sa.setFont(font);
        sa.setBounds(200,150,500,25);
        add(iss);
		iss.setFont(font);
        iss.setBounds(350,350,500,25);
        iss.setForeground(Color.red);
        bno=new JLabel("Book Number");
        bno.setForeground(Color.blue);
		bnot=new JTextField(10);
		add(bno);
		bno.setFont(font);
        bno.setBounds(200,500,500,25);
        add(st);
        st.setBounds(500,150,120,25);
        add(bnot);
        bnot.setBounds(400,500,100,25);
        fid=new JLabel("Faculty ID");
		fidt=new JTextField(10);
		add(fid);
		fid.setFont(font);
		fid.setForeground(Color.blue);
		fid.setBounds(200,550,500,25);
		add(fidt);
        fidt.setBounds(400,550,100,25);
		c=new JButton("Cancel");
		o=new JButton("Search");
		i=new JButton("Issue");
		prompt.setFont(font);
		prompt.setForeground(Color.red);
		add(prompt);
        prompt.setBounds(300,700,400,25);
		sea=new JLabel("Search By");
		sea.setFont(font);
		add(sea);
		sea.setBounds(200,100,100,25);
		sea.setForeground(Color.blue);
		add(c);
		c.setBounds(500,225,75,25);
		add(o);
		o.setBounds(300,225,75,25);
		add(i);
		i.setBounds(300,600,75,25);
		i.addActionListener(this);
		c.addActionListener(this);
		o.addActionListener(this);
		fac.addActionListener(this);
		stu.addActionListener(this);
		data[0][0]=new String("Book Number");
		data[0][1]=new String("Book Name");
		data[0][2]=new String("Author");
		data[0][3]=new String("Publisher");
		data[0][4]=new String("Edition");
		data[0][5]=new String("Edition Year");
		data[0][6]=new String("Price");
		for(int i=1;i<20;i++)
		{
			for(int j=0;j<7;j++)
				   data[i][j]=new String(" ");
		}

		table=new JTable(data,head);
		table.setRowHeight(40);

		add(table);
		table.setBounds(670,020,600,750);
		table.setBackground(Color.white);
	}
	public void itemStateChanged(ItemEvent ie)
	{
			s=(String)ie.getItem();
			if(s.equals("Book Number"))
			{
				sa.setText("Enter Book Number:");
				st.requestFocus();
			}
			else
			  if(s.equals("Book Name"))
			  {
			      sa.setText("Enter Book Name:");
			      st.requestFocus();
			  }
			else
			  if(s.equals("Author"))
			  {
			  	  sa.setText("Enter Author's Name:");
			  	  st.requestFocus();
			  }
			else
			  if(s.equals("Publisher"))
			  {
			      sa.setText("Enter Publisher's Name:");
			      st.requestFocus();
			  }
	}
	public void actionPerformed(ActionEvent ae)
	{
		bnot.requestFocus();
		if(ae.getSource()==fac)
		{
			fid.setText("Faculty ID");
		}
		if(ae.getSource()==stu)
		{
			fid.setText("Student ID");
		}
		if(ae.getSource()==c)
		{
			m.setVisible(true);
			this.setVisible(false);
		}
		else
		if(ae.getSource()==o)
		{
			for(int i=1;i<20;i++)
			{
				for(int j=0;j<7;j++)
				   table.setValueAt("",i,j);
			}
			try
			{
				ResultSet rs;
				String query="Select * from book where bno="+st.getText()+" and status='y'";
                if(s.equals("Book Name"))
				{
			       query="Select * from book where bname='"+st.getText()+"'"+" and status='y'";
		        }
		        else if(s.equals("Author"))
				{
				   query="Select * from book where author='"+st.getText()+"'"+" and status='y'";
		        }
		        else if(s.equals("Publisher"))
				{
				   query="Select * from book where pubname='"+st.getText()+"'"+" and status='y'";
		        }
		        rs=cn.smt.executeQuery(query);

		        int i=1;
		        while(rs.next())
                {
					table.setValueAt(rs.getString(1),i,0);
					table.setValueAt(rs.getString(2),i,1);
					table.setValueAt(rs.getString(3),i,2);
					table.setValueAt(rs.getString(4),i,3);
					table.setValueAt(rs.getString(5),i,4);
					table.setValueAt(rs.getString(6),i,5);
					table.setValueAt(rs.getString(7),i,6);
					i++;
					repaint();
					table.requestFocus();
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else if(ae.getSource()==i)
		{
				if(fac.isSelected())
				{
					String query="Select * from faculty where facultyid='"+fidt.getText()+"'";
					String q="Select * from book where bno="+bnot.getText()+" and status='y'";
					ResultSet rs;
					try
					{
						rs=cn.smt.executeQuery(query);
						if(rs.next())
						{
							rs=cn.smt.executeQuery(q);
							if(rs.next())
							{
							query="Insert into issue(bookno,facultyid) values("+bnot.getText()+",'"+fidt.getText()+"')";
							cn.smt.executeUpdate(query);
							prompt.setText("Book Issued");
							prompt.setForeground(Color.red);
							add(prompt);
							Thread.sleep(1000);
							prompt.setText("");
							Thread.sleep(1000);
							prompt.setForeground(Color.blue);
							prompt.setText("Book Issued");
							prompt.setText("");
							remove(prompt);
							query="update book set status='n' where bno="+bnot.getText();
							cn.smt.executeUpdate(query);
							fidt.setText("");
							bnot.setText("");
							}
							else
							{
								System.out.println("");
								prompt.setText("Book is not present");
								prompt.setForeground(Color.red);
								add(prompt);
								Thread.sleep(1000);
								prompt.setText("");
								Thread.sleep(1000);
								prompt.setForeground(Color.blue);
								prompt.setText("Book is not present");
								prompt.setText("");
								remove(prompt);
						    	Thread.sleep(1000);
						    	fidt.setText("");
						    	bnot.setText("");
							}
						}
						else
						{
						    System.out.println("");
						    prompt.setText("Faculty is not present");
						    prompt.setForeground(Color.red);
							add(prompt);
							Thread.sleep(1000);
							prompt.setText("");
							Thread.sleep(1000);
							prompt.setForeground(Color.blue);
							prompt.setText("Faculty is not present");
							prompt.setText("");
							remove(prompt);
						    Thread.sleep(1000);
						    fidt.setText("");
						    bnot.setText("");
					     }
					 }
					catch(Exception e)
					{
						System.out.println("Error");
					}
				}
				else
				if(stu.isSelected())
				{
					String query="Select * from studentinfo where sid='"+fidt.getText()+"'";
					String qu="select count(*) from student where studentid='"+fidt.getText()+"'";
					try
					{
					ResultSet rr=cn.smt.executeQuery(qu);
					if(rr.next())
					   cnt=Integer.parseInt(rr.getString(1));
					System.out.println(cnt);
					}
					catch(Exception e)
					{
					}
					String q="Select * from book where bno="+bnot.getText()+" and status='y'";
					ResultSet rs;
					try
					{
						rs=cn.smt.executeQuery(query);
						if(rs.next())
						{
							rs=cn.smt.executeQuery(q);
							if(rs.next())
							{
								if(cnt<3)
								{
					            query="Insert into student(bookno,studentid) values("+bnot.getText()+",'"+fidt.getText()+"')";
							    cn.smt.executeUpdate(query);
							    prompt.setText("Book Issued");
							    prompt.setForeground(Color.red);
							    add(prompt);
							    Thread.sleep(1000);
							    prompt.setText("");
							    Thread.sleep(1000);
							    prompt.setForeground(Color.blue);
							    prompt.setText("Book Issued");
							    prompt.setText("");
							    remove(prompt);
							    query="update book set status='n' where bno="+bnot.getText();
							    cn.smt.executeUpdate(query);
							    fidt.setText("");
							    bnot.setText("");
							    }
							    else
							    {
								prompt.setText("Already Taken 3 Books");
								prompt.setForeground(Color.red);
								add(prompt);
								Thread.sleep(1000);
								prompt.setText("");
								Thread.sleep(1000);
								prompt.setForeground(Color.blue);
								prompt.setText("Already Taken 3 Books");
								prompt.setText("");
								remove(prompt);
						    	Thread.sleep(1000);
								}
								}
							else
							{
								System.out.println("");
								prompt.setText("Book is not present");
								prompt.setForeground(Color.red);
								add(prompt);
								Thread.sleep(1000);
								prompt.setText("");
								Thread.sleep(1000);
								prompt.setForeground(Color.blue);
								prompt.setText("Book is not present");
								prompt.setText("");
								remove(prompt);
						    	Thread.sleep(1000);
						    	fidt.setText("");
						    	bnot.setText("");
							}
						}
						else
						{
						    System.out.println("");
						    prompt.setText("Student is not present");
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
						    fidt.setText("");
						    bnot.setText("");
					     }
					 }
					catch(Exception e)
					{
						System.out.println("Error");
					}
				}
			}
      }

	public static void main(String args[])
    {
			SearchFrame main=new SearchFrame();
			main.requestFocus();
			main.setResizable(true);
			main.setVisible(true);
			main.setExtendedState(JFrame.MAXIMIZED_BOTH);
			main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
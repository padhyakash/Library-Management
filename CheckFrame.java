import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class CheckFrame extends JFrame implements ActionListener
{
	JLabel id;
	JTextField idt;
	JButton o;
	JRadioButton fac,stu;
	ButtonGroup gp=new ButtonGroup();
	Connect cn;
	String q=new String("");
	Label prompt=new Label("");
	String s=new String(" ");
	String x="",y="";
	MainFrame m=new MainFrame();
	Font font=new Font("Arial",Font.BOLD,20);
	String head[]={"Book No.","Name","Date Of Issue"};
	String data[][]=new String[25][3];
	JTable table;
	public CheckFrame()
	{
	    super("Check");//set the title
		setLayout(null);
		setSize(1200,750);
		setVisible(true);
		cn=new Connect();
		fac=new JRadioButton("Faculty");
		stu=new JRadioButton("Student");
		gp.add(fac);
		gp.add(stu);
		add(fac);
		fac.setForeground(Color.blue);
		fac.addActionListener(this);
		fac.setFont(font);
        fac.setBounds(200,200,400,25);
		add(stu);
		stu.addActionListener(this);
		stu.setFont(font);
		stu.setForeground(Color.blue);
        stu.setBounds(200,250,400,25);
        id=new JLabel("Enter Faculty ID");
        id.setForeground(Color.blue);
        idt=new JTextField(10);
        add(id);
        id.setFont(font);
        id.setBounds(200,300,200,25);
        add(idt);
        idt.setBounds(400,300,100,25);
        o=new JButton("Search");
        add(o);
		o.setBounds(300,350,75,25);
		o.addActionListener(this);
		data[0][0]=new String("Book Number");
		data[0][1]=new String("ID");
		data[0][2]=new String("Date Of Issue");
		for(int i=1;i<20;i++)
		{
			for(int j=0;j<=2;j++)
				   data[i][j]=new String(" ");
		}
		table=new JTable(data,head);
		table.setRowHeight(40);
		add(table);
		table.setBounds(670,020,600,750);
		table.setBackground(Color.white);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==fac)
		{
			id.setText("Enter Faculty ID");
			x="issue";
			y="facultyid";
			idt.requestFocus();
			idt.setText("");
		}
		if(ae.getSource()==stu)
		{
			id.setText("Enter Student ID");
			x="student";
			y="studentid";
			idt.setText("");
			idt.requestFocus();
		}
		if(ae.getSource()==o)
		{
			for(int i=1;i<20;i++)
			{
				for(int j=0;j<=2;j++)
				   table.setValueAt("",i,j);
			}
			try
			{
				ResultSet rs;
				q="Select * from "+x+" where "+y+"='"+idt.getText()+"'";
				rs=cn.smt.executeQuery(q);
				int i=1;
		        while(rs.next())
                {
					table.setValueAt(rs.getString(1),i,0);
					table.setValueAt(rs.getString(2),i,1);
					table.setValueAt(rs.getString(3),i,2);
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
	}
	public static void main(String args[])
    {
			CheckFrame main=new CheckFrame();
			main.requestFocus();
			main.setResizable(true);
			main.setVisible(true);
			main.setExtendedState(JFrame.MAXIMIZED_BOTH);
			main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

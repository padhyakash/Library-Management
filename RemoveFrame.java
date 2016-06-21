import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class RemoveFrame extends JFrame implements ActionListener
{
	JLabel ebn;
	JTextField ebntf;
	JButton del,c;
	Connect cn;
	Label prompt;
	Font font=new Font("Arial",Font.BOLD,20);
	MainFrame m=new MainFrame();
	public RemoveFrame()
	{
		super("Remove");//set the title
		setLayout(null);
		setSize(1200,750);
		setVisible(true);
		cn=new Connect();
		ebn=new JLabel("Enter Book Number");
		ebn.setFont(font);
		ebn.setForeground(Color.blue);
		ebntf=new JTextField(10);
		del=new JButton("Delete");
		c=new JButton("Cancel");
		add(ebn);
		ebn.setBounds(400,200,200,25);
		add(ebntf);
		ebntf.setBounds(700,200,100,25);
		add(c);
		c.setBounds(700,300,80,25);
		add(del);
		del.setBounds(500,300,80,25);
		c.addActionListener(this);
		del.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==del)
		{
			try
			{
				int cnt=cn.smt.executeUpdate("Delete from book where bno="+ebntf.getText());
				if(cnt==1)
				{
					prompt=new Label("One record deleted");
					prompt.setBounds(600,500,400,25);
					prompt.setFont(font);
					prompt.setForeground(Color.red);
					add(prompt);
					Thread.sleep(1000);
					prompt.setText("");
					Thread.sleep(1000);
					prompt.setForeground(Color.blue);
					prompt.setText("One record deleted");
					prompt.setText("");
					remove(prompt);
			}
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
        else
		if(ae.getSource()==c)
		{
			m.setVisible(true);
			this.setVisible(false);
		}

	}
	public static void main(String args[])
    {
		RemoveFrame main=new RemoveFrame();
		main.requestFocus();
		main.setResizable(true);
		main.setVisible(true);
		main.setExtendedState(JFrame.MAXIMIZED_BOTH);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
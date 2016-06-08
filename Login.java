import javax.swing.*;
import java.awt.*;
public class Login extends JFrame
{
	JSplitPane jsp;
	JPanel left,right;
	JLabel photo;
	public Login()
	{
		super("Library Management");
		left=new JPanel();
		left.setBackground(Color.white);
		photo=new JLabel(new ImageIcon("Desktop.JPG"));
		left.add(photo);
		right=new RightPanel(this);
		right.setBackground(Color.white);
		jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,left,right);
		Container cp=getContentPane();
  		cp.add(BorderLayout.CENTER,jsp);
		jsp.setDividerLocation(800);
		requestFocus();
	}
	public static void main(String args[])
	{
		Login login=new Login();
		login.requestFocus();
		login.setResizable(true);
		login.setVisible(true);
		login.setExtendedState(JFrame.MAXIMIZED_BOTH);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
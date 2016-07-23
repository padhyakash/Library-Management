import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Output extends JFrame
{
	public Output()
	{
		super("Search Result");
		requestFocus();
		setResizable(true);
		setVisible(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
	}
    public static void main(String args[])
    {
	    Output main=new Output();

	}
}
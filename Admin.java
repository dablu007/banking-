

import java.awt.Color;
import java.io.*;
import java.util.*;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class Admin extends JFrame implements ActionListener  
{
     
	private JLabel l1,l2,l3,l4;
	private JTextField tid;
	private JPasswordField tpass; 
	private JButton bok;
	private int m=0,n=0,ok=0;


	public Admin(String title)
	{           
		super(title);
		Container c=getContentPane();
		c.setLayout(new GridLayout(4,2));

		bok=new JButton("OK");
		bok.addActionListener(this);
		
		Font f3=new Font("Bookman Old Style",Font.ITALIC,30);
		bok.setFont(f3);
	
		Font f1=new Font("Lucida Calligraphy",Font.BOLD,26);
		l1=new JLabel("Log In");
		l1.setFont(f1);
		l1.setForeground(Color.BLUE);

		Font f2=new Font("Cambria",Font.BOLD,18);
		l2=new JLabel("Login ID:");
		l2.setFont(f2);
		l2.setForeground(Color.BLACK);
		tid=new JTextField(20);

		l3=new JLabel("Password:");
		l3.setFont(f2);
		l3.setForeground(Color.BLACK);
		tpass=new JPasswordField(20);

		l4=new JLabel("");

		c.add(l1);c.add(new JLabel(""));	
		c.add(l2);c.add(tid);
		c.add(l3);c.add(tpass);
		c.add(l4);c.add(bok);

		setSize(450, 200);
		setLocation(300,200);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==bok)
		{
			String id1=tid.getText();
			String pass1=tpass.getText();
			
			if(id1.equals("admin")&&pass1.equals("12345"))
		 do{	
		    String s1 = tid.getText();
                    String reg="^[a-zA-z0-9_@]";
                    Scanner sc = new Scanner(s1);
                    String result =sc.findInLine(reg);
 
                    if(result == null)
                    {
                        tid.setText("");
                        JOptionPane.showMessageDialog(this,"Enter Valid Name..");
                    }
		   else
		    {
			 m=1;
		    }
                    
                    String s2 = tpass.getText();
                    String reg1="^[0-9]";
                    Scanner sc1 = new Scanner(s2);
                    String result1 =sc1.findInLine(reg1); 
                    if(result1 == null)
                    {
                        tpass.setText("");
                        JOptionPane.showMessageDialog(this,"INVALID...");
                    }
		   else 
		    {	
			n=1;
		    }
			
		   if(m==1)
		    {
			if(n==1)
 			{
			ok=1; 
			break;
			}
		    }
       		}while(ok==1); 

		if(ok==1)		
	 	{
			{	
				new Login(" Signed In Administrator ");
			}
			else
			{
				JOptionPane.showMessageDialog(this,"wrong user name or password please re enter");
				tpass.setText("");
				tid.setText(" ");
			}

	    }	
	}
	 

	public static void main(String args[])
	{
		new Admin("Administrator");

	}

}
	
	

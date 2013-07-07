

/*
OPERATOR ID: operator
PASSWORD:	12345
 */

import java.awt.Color;
import java.io.*;
import java.util.*;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.*;

public class Operator extends JFrame implements ActionListener 
{
     
	private JLabel l1,l2,l3,l4;
	private JTextField tid;
	private JPasswordField tpass; 
	private JButton bok,b1;
	private int m=0,n=0,ok=0;
	
	
	

	public Operator(String title)
	{  
		super(title);

		Container c=getContentPane();
		c.setLayout(new GridLayout(4,2));

		bok=new JButton("OK");
		bok.addActionListener(this);

		
		Font f3=new Font("Bookman Old Style",Font.ITALIC,30);
		bok.setFont(f3);
		
		b1=new JButton("Log Out");
		b1.addActionListener(this);
		b1.setFont(f3);


		Font f1=new Font("Lucida Calligraphy",Font.BOLD,26);
		l1=new JLabel("  Sign In");
		l1.setFont(f1);
		l1.setForeground(Color.BLUE);

		Font f2=new Font("Cambria",Font.BOLD,18);
		l2=new JLabel("   User ID:");
		l2.setFont(f2);
		l2.setForeground(Color.BLACK);
		tid=new JTextField(20);

		l3=new JLabel("   Password:");
		l3.setFont(f2);
		l3.setForeground(Color.BLACK);
		tpass=new JPasswordField(20);

		l4=new JLabel("");

		c.add(l1);c.add(new JLabel(""));	
		c.add(l2);c.add(tid);
		c.add(l3);c.add(tpass);
		c.add(b1);c.add(bok);

		setSize(450, 200);
		setLocation(300,200);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	}
	 
	public void actionPerformed(ActionEvent ae)
	{
		String id1=tid.getText();
		String id2=tpass.getText();
		if(ae.getSource()==bok)
		{
			
			if(id1.equals("operator")&&id2.equals("12345"))
		do{	
		    String s1 = tid.getText();
                    String reg="^[a-zA-z0-9_@]";
                    Scanner sc = new Scanner(s1);
                    String result =sc.findInLine(reg);
 
                    if(result.equals(id))
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
                    if(result1.equals(pswrd))
                    {
                    tpass.setText("");
                    JOptionPane.showMessageDialog(this,"Invalid  password...");               
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
		new SignIn(" Signed In Operater"); 
			}
			else{
				JOptionPane.showMessageDialog(this,"Wrong username or pass word please re enter");
				tid.setText(" ");
				tpass.setText("");
			}
			}
		if(ae.getSource()==b1)
		{
			new GlobalBank(" ");
		
		}
				
			}
	
		

		
	


	public static void main(String args[])
	{
		new Operator("Welcome");

	}

}
	
	

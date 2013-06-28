

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

public class GlobalBank extends JFrame implements ActionListener 
 {

	
	private JButton list,boperator,badmin;
        private JLabel l1,l3;
	
	

	public GlobalBank(String title)
	{
		super(title);
		Container c=getContentPane();
		
		c.setLayout(new GridLayout(6,1));
		
		
		
		boperator=new JButton("Operator");
		boperator.addActionListener(this);
		
		
		Font f2=new Font("Bookman Old Style",Font.ITALIC,30);
		boperator.setFont(f2);
		
		badmin=new JButton("Administrator");
		badmin.addActionListener(this);
		
		Font f3=new Font("Bookman Old Style",Font.ITALIC,30);
		badmin.setFont(f3);
		
		Font f1=new Font("Bookman Old Style",Font.ITALIC,40);
		l1=new JLabel("      WELCOME TO GLOBAL BANK");
		l1.setFont(f1);
		l1.setForeground(Color.PINK);
		
		

		l3=new JLabel("");
		
		JPanel opanel=new JPanel();
		opanel.add(new JLabel(""));
		opanel.add(boperator);
		opanel.add(new JLabel(""));
		
		JPanel apanel=new JPanel();
		apanel.add(new JLabel(""));
		apanel.add(badmin);
		apanel.add(new JLabel(""));
		
		
		
		c.add(l1);
		c.add(new JLabel(""));	
		c.add(opanel);
		c.add(new JLabel(""));
		c.add(apanel);
		c.add(l3);
		
		
		setSize(700, 500);
		setLocation(200,100);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==boperator)
		{
			new Operator("  Operator ");
			setVisible(false);
		}

		if(ae.getSource()==badmin)
		{
			new Admin(" Administrator ");
		}
	}

		
	public static void main(String args[])
	{
		new GlobalBank("Global Bank");

	}


	
}
				
		
		
	

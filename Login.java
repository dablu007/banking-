
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


public class Login extends JFrame implements ActionListener 
{
	ArrayList<Transaction> folder;
	ArrayList<TransactionInfo> match;
	ArrayList<DraftRequest> draft;
	ArrayList<ChequeList> check;
	
	private JButton bcustinfo, btransinfo, bchkreq, bdrftreq;
	
	public Login(String title)
	{
		super(title);
		match=new ArrayList<TransactionInfo>();
		folder=new ArrayList<Transaction>();
		check=new ArrayList<ChequeList>();
		
		Container c=getContentPane();
		c.setLayout(new GridLayout(7,3));

		
		bcustinfo=new JButton("Complain Information");
		bcustinfo.addActionListener(this);

		
		Font f3=new Font("Bookman Old Style",Font.ITALIC,20);
		bcustinfo.setFont(f3);

		btransinfo=new JButton("Customer Transaction Information");
		btransinfo.addActionListener(this);

		
		btransinfo.setFont(f3);

		bchkreq=new JButton("Cheque Requests");
		bchkreq.addActionListener(this);

		
		bchkreq.setFont(f3);

	
		bdrftreq=new JButton("Draft Requests");		
		bdrftreq.addActionListener(this);

		
		bdrftreq.setFont(f3);		

		c.add(new JLabel(""));
		c.add(new JLabel(""));c.add(new JLabel(""));c.add(new JLabel(""));
		c.add(bcustinfo);
		c.add(new JLabel(""));
		c.add(new JLabel(""));c.add(new JLabel(""));c.add(new JLabel(""));
		c.add(btransinfo);c.add(new JLabel(""));
		
		c.add(bchkreq);c.add(new JLabel(""));
		c.add(new JLabel(""));c.add(new JLabel(""));c.add(new JLabel(""));
		c.add(bdrftreq);c.add(new JLabel(""));
		
		c.add(new JLabel(""));

		setSize(800, 400);
		setLocation(300,200);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==bcustinfo)
		{
			new AccountInfo();
		}
		if(ae.getSource()==btransinfo)
		{
			new CustTransInfo();
		}
		if(ae.getSource()==bchkreq)
		{
			new AdminCheque();
		}

		if(ae.getSource()==bdrftreq)		{
			new AdminDraft();
		}


	}
		
	public static void main(String args[])
	{
		
              new Login("View All Details");

	}
}

		


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


public class SignIn extends JFrame implements ActionListener
{

	
	private JButton bcreate, binfo, btransfer, bdebit, bcredit,bdelete,bcheque,bdraft;
	
	public SignIn(String title)
	{
		super(title);
		Container c=getContentPane();
		c.setLayout(new GridLayout(9,3));

		bcreate=new JButton("Create Account");
		bcreate.addActionListener(this);

		
		Font f3=new Font("Bookman Old Style",Font.ITALIC,30);
		bcreate.setFont(f3);

		binfo=new JButton("Account Info");
		binfo.addActionListener(this);

		
	 	binfo.setFont(f3);

		btransfer=new JButton("Fund Transfer");
		btransfer.addActionListener(this);

		
		btransfer.setFont(f3);

		bdebit=new JButton("Debit");
		bdebit.addActionListener(this);

		
		bdebit.setFont(f3);

		bcredit=new JButton("Credit");
		bcredit.addActionListener(this);

		
		bcredit.setFont(f3);

		bdelete=new JButton("Delete Account");
		bdelete.addActionListener(this);

		
		bdelete.setFont(f3);

                bcheque=new JButton("Cheque");
		bcheque.addActionListener(this);

		
		bcheque.setFont(f3);
	
		bdraft=new JButton("Draft");
		bdraft.addActionListener(this);

		
		bdraft.setFont(f3);
		
		
		c.add(new JLabel(""));c.add(new JLabel(""));c.add(new JLabel(""));
		
		c.add(bcreate);c.add(new JLabel(""));c.add(binfo);
		c.add(new JLabel(""));c.add(new JLabel(""));c.add(new JLabel(""));

		c.add(bcredit);c.add(new JLabel(""));c.add(bdebit);
		c.add(new JLabel(""));c.add(new JLabel(""));c.add(new JLabel(""));

		c.add(btransfer);c.add(new JLabel(""));c.add(bdelete);	
		c.add(new JLabel(""));c.add(new JLabel(""));c.add(new JLabel(""));

		c.add(bcheque);c.add(new JLabel(""));c.add(bdraft);
		c.add(new JLabel(""));c.add(new JLabel(""));c.add(new JLabel(""));
		
		setSize(800, 500);
		setLocation(300,100);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	}
	
	public void actionPerformed(ActionEvent ae)
	{

		
		

		if(ae.getSource()==bcreate)
		{
			new Register("Registration");
		}
	
		if(ae.getSource()==binfo)
		{
			new AccountInfo();		
		}

		if(ae.getSource()==btransfer)
		{
			new FundTransfer(" Fund Transfer");
		}

		if(ae.getSource()==bdebit)
		{
			new Debit(" Debit...");
		}

		if(ae.getSource()==bcredit)
		{
			new Credit(" Credit...");
		}

		if(ae.getSource()==bdelete)
		{
			new DeleteAccount(" Delete Account...");
		}

		if(ae.getSource()==bcheque)
		{
			new ChequeBook(" Cheque Details... ");
		}

		if(ae.getSource()==bdraft)
		{
			new Draft(" Draft Details... ");
		}
	}
	
	
		
	public static void main(String args[])
	{
		
              new SignIn(" Signed Operator... ");

	}
}

		

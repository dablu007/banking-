

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

public class Credit extends JFrame implements ActionListener
{
     
	private JLabel l1,l2,l3,l4,l5,l6;
	private JTextField taccountno,tamount,tnetbalance;
	private JButton bok;
	private JComboBox cday,cmonth,cyear;
	private int a, m=0,n=0,ok=0;
	
	ArrayList<Transaction> folder;
	ArrayList<TransactionInfo> match;

	public Credit(String title)
	{           
		super(title);
		
		folder=new ArrayList<Transaction>();
		match=new ArrayList<TransactionInfo>();
		
		Container c=getContentPane();
		c.setLayout(new GridLayout(5,2));

		String dvalue[]=new String[31];
		for(int i=0;i<=30;i++)
		{
			dvalue[i]=String.valueOf(i+1);
		}
		cday=new JComboBox(dvalue);
		
		String mvalue[]=new String[12];
		for(int i=0;i<=11;i++)
		{
			mvalue[i]=String.valueOf(i+1);
		}
		cmonth=new JComboBox(mvalue);
		
		String yvalue[]=new String[12];
		int cnt=0;
		for(int i=2000;i<=2011;i++)
		{
			yvalue[cnt]=String.valueOf(i);
			cnt++;	
		}
		cyear=new JComboBox(yvalue);
		
		JPanel cpanel=new JPanel();
		cpanel.add(cday);
		cpanel.add(cmonth);
		cpanel.add(cyear);


		bok=new JButton("OK");
		bok.addActionListener(this);	

		
		Font f3=new Font("Bookman Old Style",Font.ITALIC,30);
		bok.setFont(f3);

		Font f1=new Font("Lucida Calligraphy",Font.BOLD,26);
		l1=new JLabel("  Cash Deposit");
		l1.setFont(f1);
		l1.setForeground(Color.BLUE);

		Font f2=new Font("Cambria",Font.BOLD,18);
		l2=new JLabel("     Account No:");
		l2.setFont(f2);
		l2.setForeground(Color.BLACK);
		taccountno=new JTextField(20);

		l3=new JLabel("     Amount:");
		l3.setFont(f2);
		l3.setForeground(Color.BLACK);
		tamount=new JTextField(20);

		/*l4=new JLabel("     Net Balance:");
		l4.setFont(f2);
		l4.setForeground(Color.BLACK);
		tnetbalance=new JTextField(20);*/
		
		l5=new JLabel("     Date:");
		l5.setFont(f2);
		l5.setForeground(Color.BLACK);

		l6=new JLabel("");

		c.add(l1);c.add(new JLabel(""));	
		c.add(l2);c.add(taccountno);
		c.add(l3);c.add(tamount);
		//c.add(l4);c.add(tnetbalance);
		c.add(l5);c.add(cpanel);
		c.add(l6);c.add(bok);

		setSize(450, 325);
		setLocation(200,200);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	}
	 
	public void actionPerformed(ActionEvent ae)
	{
		
		String amount=tamount.getText();
		String accountno=taccountno.getText();
		String debit="";
	    //Transaction fd;
	    
		if(ae.getSource()==bok)
		{
			
		    String s1 = taccountno.getText();
                    String reg="^[0-9]";
                    Scanner sc = new Scanner(s1);
                    String result =sc.findInLine(reg);
 
                    if(result == null)
                    {
                        taccountno.setText("");
                        JOptionPane.showMessageDialog(this,"Enter Valid Account no..");
                        m=1;
			 if((m==0)&&(n==0))
		    JOptionPane.showMessageDialog(this,"your amount will be credited..");
		    }
		    
                    String s2 = tamount.getText();
                    String reg1="^[0-9]";
                    Scanner sc1 = new Scanner(s2);
                    String result1 =sc1.findInLine(reg1); 
                    if(result1 == null)
                    {
                        tamount.setText("");
                        JOptionPane.showMessageDialog(this,"Enter valid Amount...");
                        n=1;
			 if((m==0)&&(n==0))
		    JOptionPane.showMessageDialog(this,"your amount will be credited..");
		    }

		    if((result != null) && (result1 != null))
		    JOptionPane.showMessageDialog(this,"your amount will be credited..");
		    
		    Transaction ts=new Transaction(amount, accountno);
		    Search scr = new Search();
			 a = scr.searchaccountno(ts);

			 if(a == -1)
				{
					JOptionPane.showMessageDialog(this, "NO DATA FOUND");
				}
				else
				{
					new Deposit(ts,a);
					new AmountInfo();
					
					/*fd=folder.get(a);
					String str=fd.getdepositamount();*/
					
					TransactionInfo tr=new TransactionInfo(accountno,debit,amount);
					DataInfo dt=new DataInfo(tr);
					//new CustTransInfo();
				}
		    
		}
	}
	 


	public static void main(String args[])
	{
		new Credit("Credit");

	}

}
	
	

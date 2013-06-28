

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

public class FundTransfer extends JFrame implements ActionListener
{
	ArrayList<Transaction> folder;
	ArrayList<TransactionInfo> match;
     
	private JLabel l1,l2,l3,l4,l5,l6,l7;
	private JTextField tsourceaccount,ttargetaccount,tamount,tnetbalance;
	private JButton bok;
	private JComboBox cday,cmonth,cyear;
	private int a, b,m=0,n=0,l=0;

	public FundTransfer(String title)
	{           
		super(title);
		
		folder=new ArrayList<Transaction>();
		match=new ArrayList<TransactionInfo>();
		
		Container c=getContentPane();
		c.setLayout(new GridLayout(6,2));

		
		
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

		
		Font f4=new Font("Bookman Old Style",Font.ITALIC,30);
		bok.setFont(f4);

	
		Font f1=new Font("Lucida Calligraphy",Font.BOLD,26);
		l1=new JLabel("Fund Transfer");
		l1.setFont(f1);
		l1.setForeground(Color.BLUE);

		Font f2=new Font("Cambria",Font.BOLD,14);
		l2=new JLabel("Source Account No:");
		l2.setFont(f2);
		l2.setForeground(Color.BLACK);
		tsourceaccount=new JTextField(20);


		Font f3=new Font("Cambria",Font.BOLD,18);
		l7=new JLabel("Target Account No:");
		l7.setFont(f2);
		l7.setForeground(Color.BLACK);
		ttargetaccount=new JTextField(20);

		l3=new JLabel("Amount:");
		l3.setFont(f2);
		l3.setForeground(Color.BLACK);
		tamount=new JTextField(20);

		/*l4=new JLabel("Net Balance:");
		l4.setFont(f2);
		l4.setForeground(Color.BLACK);
		tnetbalance=new JTextField(20);*/
		
		l5=new JLabel("Date:");
		l5.setFont(f2);
		l5.setForeground(Color.BLACK);

		l6=new JLabel("");

		c.add(l1);c.add(new JLabel(""));	
		c.add(l2);c.add(tsourceaccount);
		c.add(l7);c.add(ttargetaccount);
		c.add(l3);c.add(tamount);
		
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
		String accountno1=tsourceaccount.getText();
		String accountno2=ttargetaccount.getText();
		String credit="";
		String debit="";
		
		
		if(ae.getSource()==bok)
		{
			
		    String s1 = tsourceaccount.getText();
                    String reg1="^[0-9]";
                    Scanner sc1 = new Scanner(s1);
                    String result1 =sc1.findInLine(reg1);
 
                    if(result1 == null)
                    {
                        tsourceaccount.setText("");
                        JOptionPane.showMessageDialog(this,"Enter Valid Source Account no..");
                        m=1;
			 if((m==0)&&(n==0)&&(l==0))
		    JOptionPane.showMessageDialog(this,"your amount will be credited..");
		    }

		     String s2 = ttargetaccount.getText();
                    String reg2="^[0-9]";
                    Scanner sc2 = new Scanner(s2);
                    String result2 =sc2.findInLine(reg2);
 
                    if(result2 == null)
                    {
                        ttargetaccount.setText("");
                        JOptionPane.showMessageDialog(this,"Enter Valid Target Account no..");
                        l=1;
			 if((m==0)&&(n==0)&&(l==0))
		    JOptionPane.showMessageDialog(this,"your amount will be credited..");
		    }
		    
                    String s3 = tamount.getText();
                    String reg3="^[0-9]";
                    Scanner sc3 = new Scanner(s3);
                    String result3 =sc3.findInLine(reg3); 
                    if(result3 == null)
                    {
                        tamount.setText("");
                        JOptionPane.showMessageDialog(this,"Enter valid Amount...");
                        n=1;
			 if((m==0)&&(n==0)&&(l==0))
		    JOptionPane.showMessageDialog(this,"your amount will be debited..");
		    }

		    if((result1 != null) && (result2 != null) && (result3 != null))
		    JOptionPane.showMessageDialog(this,"your amount will be updated..");
		    
		    Transaction ts1=new Transaction(amount, accountno1);
		    Search scr1 = new Search();
			 a = scr1.searchaccountno(ts1);

			 if(a == -1)
				{
					JOptionPane.showMessageDialog(this, "NO SUCH ACCOUNT NO.FOUND");
				}
				else
				{
					
					 Transaction ts2=new Transaction(amount, accountno2);
					    Search scr2 = new Search();
						 b= scr2.searchaccountno(ts2);

						 if(b == -1)
							{
								JOptionPane.showMessageDialog(this, "NO SUCH ACCOUNT NO.FOUND");
							}
						 else
							{
							 	new Withdrawal(ts1,a);
							 	TransactionInfo tn=new TransactionInfo(accountno1,amount,credit);
							 	DataInfo dh=new DataInfo(tn); 
							 	
							 	new Deposit(ts2,b);
							 	TransactionInfo tg=new TransactionInfo(accountno2,debit,amount);
							 	DataInfo da= new DataInfo(tg);
							 	//new CustTransInfo();
							 	new AmountInfo();
							}
				}
		}

	}
	 

	 

	public static void main(String args[])
	{
		new FundTransfer("Fund Transfer");

	}

}

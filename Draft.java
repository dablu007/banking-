

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

public class Draft extends JFrame implements ActionListener 
{
	ArrayList<Transaction> folder;
	ArrayList<DraftRequest> draft;
     
	private JLabel l1,l2,l3,l4,l5;
	private JTextField tacctno,tpay,tamt;
	private JButton bok;
	private JComboBox cday,cmonth,cyear;
	private int a, m=0,n=0,p=0,ok=0;

	public Draft(String title)
	{           
		super(title);
		Container c=getContentPane();
		
		folder=new ArrayList<Transaction>();
		draft=new ArrayList<DraftRequest>();
		
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

		
		Font f3=new Font("Bookman Old Style",Font.ITALIC,30);
		bok.setFont(f3);
	
		Font f1=new Font("Lucida Calligraphy",Font.BOLD,26);
		l1=new JLabel("  Draft");
		l1.setFont(f1);
		l1.setForeground(Color.BLUE);

		Font f2=new Font("Cambria",Font.BOLD,18);
		l2=new JLabel("     Account No:");
		l2.setFont(f2);
		l2.setForeground(Color.BLACK);
		tacctno=new JTextField(20);

		l3=new JLabel("     Payable At:");
		l3.setFont(f2);
		l3.setForeground(Color.BLACK);
		tpay=new JTextField(20);

		
		l4=new JLabel("    Amount:");
		l4.setFont(f2);
		l4.setForeground(Color.BLACK);
		tamt=new JTextField(20);

		l5=new JLabel("    Date:");
		l5.setFont(f2);
		l5.setForeground(Color.BLACK);

		c.add(l1);c.add(new JLabel(""));	
		c.add(l2);c.add(tacctno);
		c.add(l3);c.add(tpay);
		c.add(l4);c.add(tamt);
		c.add(l5);c.add(cpanel);
		c.add(new JLabel(""));c.add(bok);

		setSize(700, 325);
		setLocation(200,200);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	}
	 
	public void actionPerformed(ActionEvent ae)
	{
		

		String amount=tamt.getText();
		String accountno=tacctno.getText();
	
		
		if(ae.getSource()==bok)
		{
			
		    String s1 = tacctno.getText();
                    String reg="^[0-9]";
                    Scanner sc = new Scanner(s1);
                    String result =sc.findInLine(reg);
 
                    if(result == null)
                    {
                        tacctno.setText("");
                        JOptionPane.showMessageDialog(this,"Enter Valid Account No..");
                    }
		   else
		    {
			 m=1;
		    }
                    
                    String s2 = tpay.getText();
                    String reg1="^[a-zA-z0-9]";
                    Scanner sc1 = new Scanner(s2);
                    String result1 =sc1.findInLine(reg1); 
                    if(result1 == null)
                    {
                        tpay.setText("");
                        JOptionPane.showMessageDialog(this,"INVALID...");
                    }
		   else 
		    {	
			n=1;
		    }
		
		 String s3 = tamt.getText();
                    String reg2="^[0-9]";
                    Scanner sc2 = new Scanner(s3);
                    String result2=sc2.findInLine(reg2); 
                    if(result2 == null)
                    {
                        tamt.setText("");
                        JOptionPane.showMessageDialog(this,"INVALID...");
                    }
		   else 
		    {	
			p=1;
		    }
	
		  if((result != null) && (result1 != null) && (result2 != null))
		    JOptionPane.showMessageDialog(this,"OK");
		  
		  
		  Transaction ts=new Transaction(amount, accountno);
		    Search scr = new Search();
			 a = scr.searchaccountno(ts);

			 if(a == -1)
				{
					JOptionPane.showMessageDialog(this, "NO DATA FOUND");
				}
				else
				{
					DraftRequest dr=new DraftRequest(accountno);
					DraftList dt=new DraftList(dr);
					new Withdrawal(ts,a);
					new AmountInfo();
				}
		    
	}
 }

	public static void main(String args[])
	{
		new Draft("Draft Details...");

	}

}
	
	

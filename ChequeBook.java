

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

public class ChequeBook extends JFrame implements ActionListener 
{
	ArrayList<Transaction> folder; 
	ArrayList<ChequeList> check;
	
	private JLabel l1,l2,l3,l4,l5,l6,l7;
	private JTextField tacctno,tpages,tcost,tcourier,ttotamt;
	private JButton bok;
	private JRadioButton ryes,rno;
	private int a, m=0,n=0,p=0,ok=0,q=0;

	public ChequeBook(String title)
	{           
		super(title);
		Container c=getContentPane();
		
		folder=new ArrayList<Transaction>();
		check=new ArrayList<ChequeList>();
		
		c.setLayout(new GridLayout(7,2));

		
		
		bok=new JButton("OK");
		bok.addActionListener(this);
		
		
		Font f3=new Font("Bookman Old Style",Font.ITALIC,30);
		bok.setFont(f3);
	
		Font f1=new Font("Lucida Calligraphy",Font.BOLD,26);
		l1=new JLabel(" Cheque Book");
		l1.setFont(f1);
		l1.setForeground(Color.BLUE);

		Font f2=new Font("Cambria",Font.BOLD,18);
		l2=new JLabel("     Account No:");
		l2.setFont(f2);
		l2.setForeground(Color.BLACK);
		tacctno=new JTextField(20);

		l3=new JLabel("     No of pages of Cheque book:");
		l3.setFont(f2);
		l3.setForeground(Color.BLACK);
		tpages=new JTextField(20);

		l4=new JLabel("     Cost of Cheque Book(Rs.2 per page):");
		l4.setFont(f2);
		l4.setForeground(Color.BLACK);
		tcost=new JTextField(20);
		
		l5=new JLabel("     Courier Service(extra charge Rs.50):");
		l5.setFont(f2);
		l5.setForeground(Color.BLACK);
		
		ryes=new JRadioButton("Yes");
		//ryes.addActionListener(this);
		//ryes.setSelected(true);
		
		rno=new JRadioButton("No");
		//rno.addActionListener(this);
		//rno.setSelected(true);

		ButtonGroup rgroup=new ButtonGroup();

		rgroup.add(ryes);
		rgroup.add(rno);		

		JPanel cpanel=new JPanel();
		
		cpanel.add(ryes);
		cpanel.add(rno);
		
		
		l6=new JLabel("    Total amount deducted");
		l6.setFont(f2);
		l6.setForeground(Color.BLACK);
		ttotamt=new JTextField(20);


		/*l7=new JLabel("    Net Balance");
		l7.setFont(f2);
		l7.setForeground(Color.BLACK);
		tnetblnc=new JTextField(20);*/

		c.add(l1);c.add(new JLabel(""));	
		c.add(l2);c.add(tacctno);
		c.add(l3);c.add(tpages);
		c.add(l4);c.add(tcost);
		c.add(l5);c.add(cpanel);
		c.add(l6);c.add(ttotamt);
		//c.add(l7);c.add(tnetblnc);
		c.add(new JLabel(""));c.add(bok);

		setSize(700, 325);
		setLocation(200,200);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	}
	 
	public void actionPerformed(ActionEvent ae)
	{
		

		String amount=ttotamt.getText();
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
                        JOptionPane.showMessageDialog(this,"Enter Valid Account Number..");
                    }
		   else
		    {
			 m=1;
		    }
                    
                   String s2 = tpages.getText();
                    String reg1="^[0-9]";
                    Scanner sc1 = new Scanner(s2);
                    String result1 =sc1.findInLine(reg1); 
                    if(result1 == null)
                    {
                        tpages.setText("");
                        JOptionPane.showMessageDialog(this,"Enter no. of  pages...");
                    }
		   else 
		    {	
			n=1;
		    }
			
	String s3 = tcost.getText();
                    String reg2="^[0-9]";
                    Scanner sc2 = new Scanner(s3);
                    String result2 =sc2.findInLine(reg2); 
                    if(result2 == null)
                    {
                        tcost.setText("");
                        JOptionPane.showMessageDialog(this,"INVALID...");
                    }
		   else 
		    {	
			p=1;
		    }
	String s4= ttotamt.getText();
                    String reg3="^[0-9]";
                    Scanner sc3 = new Scanner(s4);
                    String result3 =sc3.findInLine(reg3); 
                    if(result3 == null)
                    {
                        ttotamt.setText("");
                        JOptionPane.showMessageDialog(this,"INVALID...");
                    }
		   else 
		    {	
			q=1;
		    }			   

		if((result != null) && (result1 != null) && (result2 != null) && (result3 != null))
		    JOptionPane.showMessageDialog(this,"OK");
	    }
		
		 
	    Transaction ts=new Transaction(amount, accountno);
	    Search scr = new Search();
		 a = scr.searchaccountno(ts);

		 if(a == -1)
			{
				JOptionPane.showMessageDialog(this, "NO DATA FOUND");
			}
			else
			{
				ChequeList chr=new ChequeList(accountno);
				Cheque c=new Cheque(chr);
				new Withdrawal(ts,a);
				new AmountInfo();
			}
		
	}

	public static void main(String args[])
	{
		new ChequeBook("Cheque Book Details...");

	}

}
	
	
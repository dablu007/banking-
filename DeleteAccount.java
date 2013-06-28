

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

public class DeleteAccount extends JFrame implements ActionListener 
{

	ArrayList<Registration> list;
	ArrayList<Transaction> folder;

	private JLabel laccountno;
	private JButton bok;
	private JTextField tacntno;
	private int a,a1,m=0;
	public DeleteAccount(String title)
	{
		super(title);
		
		
		list=new ArrayList<Registration>();
		folder=new ArrayList<Transaction>();
		
		Container c=getContentPane();
		c.setLayout(new GridLayout(5,2));

		
		Font f=new Font("Times New Roman",Font.BOLD,22);
		laccountno=new JLabel("  Enter Account No.:");
		laccountno.setFont(f);
		laccountno.setForeground(Color.BLACK);
		tacntno=new JTextField(20);
		
		bok=new JButton("OK");
		bok.addActionListener(this);	

		
		Font f3=new Font("Bookman Old Style",Font.ITALIC,30);
		bok.setFont(f3);	

		c.add(new JLabel(""));c.add(new JLabel(""));
		c.add(laccountno);c.add(tacntno);
		c.add(new JLabel(""));c.add(new JLabel(""));
		c.add(new JLabel(""));c.add(bok);
		c.add(new JLabel(""));c.add(new JLabel(""));

		setSize(400, 180);
		setLocation(200,200);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		String accountno=tacntno.getText();
		String amount="";
		
	String name=""; String phoneno=""; String address=""; String emailid="";
	String 	identityproof=""; String depositamount=""; String gender="";
	String occupation=""; String accounttype=""; String dob=""; String idproof=""; String 	fr="";
	




		if(ae.getSource()==bok)
		{
			
			
		                 String s1 = tacntno.getText();
                   		 String reg="^[0-9]";
                   		 Scanner sc = new Scanner(s1);
                   		 String result =sc.findInLine(reg);
 
                   		 if(result == null)
                  		  {
                      	      tacntno.setText("");
                      	   	  JOptionPane.showMessageDialog(this,"Enter Valid Account no..");
                              m=1;
                  		  }
                              if(m==0)
                              {
  		                           JOptionPane.showMessageDialog(this,"your account will be deleted..");
  		                      }
  			 
  						

			Registration r=new Registration(name, phoneno, address, emailid, 			identityproof, depositamount, accountno, gender, occupation, 			accounttype, dob, idproof, fr);

		    	SearchR scr = new SearchR();
			 a = scr.searchaccountno(r);

			Transaction tst=new Transaction(amount,accountno);
			Search sa=new Search();
			a1=sa.searchaccountno(tst);


			

			 if(a1 == -1)
				{
					JOptionPane.showMessageDialog(this, "NO SUCH ACCOUNT FOUND");
				}
				else
				{
					new Delete(a1);
					new AmountInfo();
				}

			 if(a == -1)
				{
					JOptionPane.showMessageDialog(this, "NO SUCH ACCOUNT FOUND");
				}
				else
				{
					new DeleteR(a);
					new AccountInfo();
				}
  			 
  		    }
         
	  }
	

	public static void main(String[] args) {
		new DeleteAccount(" Delete Account ");

	}

}
		

		
		

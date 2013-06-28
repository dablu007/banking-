
import java.awt.Color;
import java.io.*;
import java.util.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class Register extends JFrame implements ActionListener 
{
     
	private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
	private JTextField tname, tphoneno, taddress, temailid, tidentityproof, tdepositamount,taccountno;
	private JButton bsubmit, breset,bsearch,bupdate;
	private JComboBox day,month,year;
	private JCheckBox cvoterid, cdrivinglicense, cpancard, cpassport, ccollegeid, cuid, ccheque, catm, cnetbanking;
	private JRadioButton rmale,rfemale, rservice, rselfemployed, rhousewife, rstudent, rsaving, rcurrent, rfd, rnri;
	private int a,a1,mn=0,n=0,l=0,w=0,x=0,yn=0,z=0,withdrawalamount=0;
	
	ArrayList<Registration> list;
	ArrayList<Transaction> folder;
	ArrayList<TransactionInfo> match;
	
	
	public Register(String title)
	{
		super(title);
		list=new ArrayList<Registration>();
		match=new ArrayList<TransactionInfo>();
		folder=new ArrayList<Transaction>();
		
		
		Container c=getContentPane();
		c.setLayout(new GridLayout(16,2));
		
		tname=new JTextField(20);
		tphoneno=new JTextField(20);
		taddress=new JTextField(20);
		temailid=new JTextField(20);
		tidentityproof=new JTextField(20);
		tdepositamount=new JTextField(20);
		taccountno=new JTextField(20);

		rmale=new JRadioButton("Male");
		rmale.addActionListener(this);
		rmale.setSelected(true);
		
		rfemale=new JRadioButton("Female");
		rfemale.addActionListener(this);
		rfemale.setSelected(true);

		rservice=new JRadioButton("service");
		rservice.addActionListener(this);
		rservice.setSelected(true);
		
		rselfemployed=new JRadioButton("selfemployed");
		rselfemployed.addActionListener(this);
		rselfemployed.setSelected(true);

		rhousewife=new JRadioButton("housewife");
		rhousewife.addActionListener(this);
		rhousewife.setSelected(true);
		
		rstudent=new JRadioButton("student");
		rstudent.addActionListener(this);
		rstudent.setSelected(true);

		rsaving=new JRadioButton("saving");
		rsaving.addActionListener(this);
		rsaving.setSelected(true);

		rcurrent=new JRadioButton("current");
		rcurrent.addActionListener(this);
		rcurrent.setSelected(true);

		rfd=new JRadioButton("fd");
		rfd.addActionListener(this);
		rfd.setSelected(true);

		rnri=new JRadioButton("nri");
		rnri.addActionListener(this);
		rnri.setSelected(true);

		ButtonGroup rgroup=new ButtonGroup();

		rgroup.add(rmale);
		rgroup.add(rfemale);
		JPanel gpanel=new JPanel();
		
		gpanel.add(rmale);
		gpanel.add(rfemale);
		

		ButtonGroup rgroup1=new ButtonGroup();

		rgroup1.add(rservice);
		rgroup1.add(rselfemployed);
		rgroup1.add(rhousewife);
		rgroup1.add(rstudent);
		JPanel gpanel1=new JPanel();
		
		gpanel1.add(rservice);
		gpanel1.add(rselfemployed);
		gpanel1.add(rhousewife);
		gpanel1.add(rstudent);

		ButtonGroup rgroup2=new ButtonGroup();

		rgroup2.add(rsaving);
		rgroup2.add(rcurrent);
		rgroup2.add(rfd);
		rgroup2.add(rnri);
		JPanel gpanel2=new JPanel();
		
		gpanel2.add(rsaving);
		gpanel2.add(rcurrent);
		gpanel2.add(rfd);
		gpanel2.add(rnri);

		String dvalue[]=new String[31];
		for(int i=0;i<=30;i++)
		{
			dvalue[i]=String.valueOf(i+1);
		}
		day=new JComboBox(dvalue);
		
		String mvalue[]=new String[12];
		for(int i=0;i<=11;i++)
		{
			mvalue[i]=String.valueOf(i+1);
		}
		month=new JComboBox(mvalue);
		
		String yvalue[]=new String[12];
		int cnt=0;
		for(int i=2000;i<=2011;i++)
		{
			yvalue[cnt]=String.valueOf(i);
			cnt++;	
		}
		year=new JComboBox(yvalue);
		JPanel cpanel=new JPanel();
		cpanel.add(day);
		cpanel.add(month);
		cpanel.add(year);

		cvoterid=new JCheckBox("voter id");
		cdrivinglicense=new JCheckBox("driving license");
		cpancard=new JCheckBox("pan card");
		cpassport=new JCheckBox("passport");
		ccollegeid=new JCheckBox("college id");
		cuid=new JCheckBox("uid");
		ccheque=new JCheckBox("cheque");
		catm=new JCheckBox("atm");
		cnetbanking=new JCheckBox("netbanking");


		JPanel ipanel=new JPanel();
		ipanel.add(cvoterid);
		ipanel.add(cdrivinglicense);
		ipanel.add(cpancard);
		ipanel.add(cpassport);
		ipanel.add(ccollegeid);
		ipanel.add(cuid);


		JPanel fpanel=new JPanel();
		fpanel.add(ccheque);
		fpanel.add(catm);
		fpanel.add(cnetbanking);

		
		Font f1=new Font("Lucida Calligraphy",Font.ITALIC,26);
		l14=new JLabel("Registration");
		l14.setFont(f1);
		l14.setForeground(Color.BLACK);

		bsubmit=new JButton("Create");
		bsubmit.addActionListener(this);

		
		Font f3=new Font("Bookman Old Style",Font.ITALIC,30);
		bsubmit.setFont(f3);
		
		breset=new JButton("Show All");
		breset.addActionListener(this);

		
		breset.setFont(f3);
		
		bsearch=new JButton("Search");
		bsearch.addActionListener(this);

		
		bsearch.setFont(f3);

		bupdate=new JButton("Update");
		bupdate.addActionListener(this);

		
		bupdate.setFont(f3);

		Font f=new Font("Times New Roman",Font.BOLD,18);
		l1=new JLabel("   Name:");
		l1.setFont(f);
		l1.setForeground(Color.BLUE);
		
		l2=new JLabel("   DOB:");
		l2.setFont(f);
		l2.setForeground(Color.BLUE);
		
		l3=new JLabel("   Gender:");
		l3.setFont(f);
		l3.setForeground(Color.BLUE);
		
		l4=new JLabel("   Phone No.:");
		l4.setFont(f);
		l4.setForeground(Color.BLUE);
		
		l5=new JLabel("   Address:");
		l5.setFont(f);
		l5.setForeground(Color.BLUE);
		
		l6=new JLabel("   Email id:");
		l6.setFont(f);
		l6.setForeground(Color.BLUE);
		
		l7=new JLabel("   Occupation:");
		l7.setFont(f);
		l7.setForeground(Color.BLUE);
		
		l8=new JLabel("   Identity Proof:");
		l8.setFont(f);
		l8.setForeground(Color.BLUE);

		l9=new JLabel("   Identity Proof No.:");
		l9.setFont(f);
		l9.setForeground(Color.BLUE);

		l10=new JLabel("   Account type:");
		l10.setFont(f);
		l10.setForeground(Color.BLUE);

		l11=new JLabel("   Deposit Amount:");
		l11.setFont(f);
		l11.setForeground(Color.BLUE);

		l12=new JLabel("   Facilities Required:");
		l12.setFont(f);
		l12.setForeground(Color.BLUE);

		l13=new JLabel("   Account no.:");
		l13.setFont(f);
		l13.setForeground(Color.BLUE);

		c.add(l14);c.add(new JLabel(""));
		c.add(l1);c.add(tname);
		c.add(l2);c.add(cpanel);
		c.add(l3);c.add(gpanel);
		c.add(l4);c.add(tphoneno);
		c.add(l5);c.add(taddress);
		c.add(l6);c.add(temailid);
		c.add(l7);c.add(gpanel1);
		c.add(l8);c.add(ipanel);
		c.add(l9);c.add(tidentityproof);
		c.add(l10);c.add(gpanel2);
		c.add(l11);c.add(tdepositamount);
		c.add(l12);c.add(fpanel);
		c.add(l13);c.add(taccountno);
		c.add(bsubmit);c.add(breset);
		c.add(bsearch);c.add(bupdate);

		setSize(800, 650);
		setLocation(200,40);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
		
		
	}

public void actionPerformed(ActionEvent ae)
	{
		int f=-1;

			String name=tname.getText();
			String phoneno=tphoneno.getText();
			String address=taddress.getText();
			String emailid=temailid.getText();
			String identityproof=tidentityproof.getText();
			String depositamount=tdepositamount.getText();
			String accountno=taccountno.getText();
			//String totalamount=tdepositamount.getText();
			String gender="";
			if(rmale.isSelected())
			{
				gender="Male";
			}
			else if(rfemale.isSelected())
			{
				gender="Female";
			}

			String occupation="";
			if(rservice.isSelected())
			{
				occupation="service";
			}
			else if(rselfemployed.isSelected())
			{
				occupation="self employed";
			}
			else if(rhousewife.isSelected())
			{
				occupation="housewife";
			}
			else if(rstudent.isSelected())
			{
				occupation="student";
			}

			String accounttype="";
			if(rsaving.isSelected())
			{
				accounttype="saving";
			}
			else if(rcurrent.isSelected())
			{
				accounttype="current";
			}
			else if(rfd.isSelected())
			{
				accounttype="fixed deposit";
			}
			else if(rnri.isSelected())
			{
				accounttype="nri";
			}

			String d=(String)day.getSelectedItem();
			String m=(String)month.getSelectedItem();
			String y=(String)year.getSelectedItem();
			String dob=d + "-" + m + "-" + y;
			
			String idproof="";
			if(cvoterid.isSelected())
			{
				idproof="voter id ";
			}
			if(cdrivinglicense.isSelected())
			{
				idproof = idproof + "driving license";
			}
			if(cpancard.isSelected())
			{
				idproof = idproof+ "pan card";
			}
			if(cpassport.isSelected())
			{
				idproof = idproof+ "passport";
			}
			if(ccollegeid.isSelected())
			{
				idproof = idproof+ "college id";
			}
			if(cuid.isSelected())
			{
				idproof = idproof+ "uid";
			}

			String fr="";
			if(ccheque.isSelected())
			{
				fr="cheque ";
			}
			if(catm.isSelected())
			{
				fr = fr + "atm";
			}
			if(cnetbanking.isSelected())
			{
				fr = fr+ "net banking";
			}
			
			
			Registration r=new Registration(name, phoneno, address, emailid, identityproof, depositamount, accountno, gender, occupation, accounttype, dob, idproof, fr);
			Transaction ts=new Transaction(depositamount, accountno);
			
			
		
			SearchR scr = new SearchR();
			 a = scr.searchaccountno(r);

			Search scr1 = new Search();
			a1 = scr1.searchaccountno(ts);
			 
	
		

		 if(ae.getSource()==rmale)
		{
			JOptionPane.showMessageDialog(this, "Your Gender : Male");
		}
		else if(ae.getSource()==rfemale)
		{
			JOptionPane.showMessageDialog(this, "Your Gender : Female");
			
		}
		
		else if(ae.getSource()==rservice)
		{
			JOptionPane.showMessageDialog(this, "Your occupation : service");
		}
		else if(ae.getSource()==rselfemployed)
		{
			JOptionPane.showMessageDialog(this, "Your occupation : self employed");
		}
		else if(ae.getSource()==rhousewife)
		{
			JOptionPane.showMessageDialog(this, "Your occupation : housewife");
		}
		else if(ae.getSource()==rstudent)
		{
			JOptionPane.showMessageDialog(this, "Your occupation : student");
		}
		else if(ae.getSource()==rsaving)
		{


			JOptionPane.showMessageDialog(this, "Your account type : saving");
		}

		else if(ae.getSource()==rcurrent)
		{
			JOptionPane.showMessageDialog(this, "Your account type : current");
		}

		else if(ae.getSource()==rfd)
		{
			JOptionPane.showMessageDialog(this, "Your account type : fd");
		}

		else if(ae.getSource()==rnri)
		{
			JOptionPane.showMessageDialog(this, "Your account type : nri");
		}
		
		if(ae.getSource()==bsubmit)
		{

		int con=JOptionPane.showConfirmDialog(this, "Are You Sure to Register?");

		if(con==JOptionPane.YES_OPTION)
			{
		
		 String s1 = tname.getText();
         String reg1="^[a-za-z.]";
         Scanner sc1 = new Scanner(s1);
         String result1 =sc1.findInLine(reg1);

         if(result1 == null)
         {
             tname.setText("");
             JOptionPane.showMessageDialog(this,"Enter Valid Name..");
             mn=1;
             	if((mn==0)&&(n==0)&&(l==0))
             		JOptionPane.showMessageDialog(this,"your data saved..");
         }

         String s2 = tphoneno.getText();
         String reg2="^[0-9]";
         Scanner sc2 = new Scanner(s2);
         String result2 =sc2.findInLine(reg2);

         if(result2 == null)
         {
             tphoneno.setText("");
             JOptionPane.showMessageDialog(this,"Enter Valid phone no...");
             l=1;
             	if((mn==0)&&(n==0)&&(l==0))
             		JOptionPane.showMessageDialog(this,"your data saved..");
         }
 
         String s3 = taddress.getText();
         String reg3="^[a-zA-Z0-9.,]";
         Scanner sc3 = new Scanner(s3);
         String result3 =sc3.findInLine(reg3); 
         if(result3 == null)
         {
             taddress.setText("");
             JOptionPane.showMessageDialog(this,"Enter valid Address...");
             n=1;
             	if((mn==0)&&(n==0)&&(l==0))
             		JOptionPane.showMessageDialog(this,"your data saved..");
         }

        


         String s4 = temailid.getText();
         String reg4="^[a-zA-Z0-9_@.]";
         Scanner sc4 = new Scanner(s4);
         String result4 =sc4.findInLine(reg4); 
         if(result4 == null)
         {
        	 temailid.setText("");
        	 JOptionPane.showMessageDialog(this,"Enter valid emailid...");
        	 w=1;
        	 	if((mn==0)&&(n==0)&&(l==0)&&(w==0))
        	 		JOptionPane.showMessageDialog(this,"your data saved..");
         }



         String s5 = tidentityproof.getText();
         String reg5="^[0-9]";
         Scanner sc5 = new Scanner(s5);
         String result5 =sc5.findInLine(reg5); 
         if(result5 == null)
         {
        	 tidentityproof.setText("");
        	 JOptionPane.showMessageDialog(this,"Enter valid Idproof no....");
        	 x=1;
        	 	if((mn==0)&&(n==0)&&(l==0)&&(w==0)&&(x==0))
        	 		JOptionPane.showMessageDialog(this,"your data saved..");
         }


         String s6 = tdepositamount.getText();
         String reg6="^[0-9]";
         Scanner sc6 = new Scanner(s6);
         String result6 =sc6.findInLine(reg6); 
         if(result6 == null)
         {
        	 tdepositamount.setText("");
        	 JOptionPane.showMessageDialog(this,"Enter valid Deposit Amount....");
        	 yn=1;
        	 	if((mn==0)&&(n==0)&&(l==0)&&(w==0)&&(x==0)&&(yn==0))
        	 		JOptionPane.showMessageDialog(this,"your data saved..");
         }



         String s7 = taccountno.getText();
         String reg7="^[0-9]";
         Scanner sc7 = new Scanner(s7);
         String result7 =sc7.findInLine(reg7); 
         if(result7 == null)
         {
        	 taccountno.setText("");
        	 JOptionPane.showMessageDialog(this,"Enter valid Account no. ....");
        	 z=1;
        	 	if((mn==0)&&(n==0)&&(l==0)&&(w==0)&&(x==0)&&(yn==0)&&(z==0))
        	 		JOptionPane.showMessageDialog(this,"your data saved..");
         }

         if((result1 != null) && (result2 != null) && (result3 != null)&& (result4 !=null)&& (result5 !=null)&&(result6!=null)&&(result7!=null))
         {
        	 if(a!=-1)
        	 {
        	 JOptionPane.showMessageDialog(this,"this account no. already exists. please enter another ount no.acc...");
        	 }
        	 else
        	 {
        		 JOptionPane.showMessageDialog(this,"your data saved successfully...");
        		 new AddInfo(r);
        		 new TransAddInfo(ts);
			}
		}
 	
			}
		}

		else if(ae.getSource()==breset)
		{
			new AccountInfo();
		}

		
		else if(ae.getSource()==bsearch)
		{
			if(a == -1)
			{
				JOptionPane.showMessageDialog(this, "NO DATA FOUND");
			}
			else
			{
				new SearchDisp(a);
			}}

		else if(ae.getSource()==bupdate)
		{
			
			SearchR scr2 = new SearchR();
			 a = scr2.searchaccountno(r);

			
			if(a == -1)
			{
				JOptionPane.showMessageDialog(this, "Please Enter Valid Account no....");
			}
			else
			{
			
				new UpdateInfo(r,(a));
				
				
				JOptionPane.showMessageDialog(this, "Data Updated Successfully...");
			}
							
		}
	}
		

	public static void main(String args[]) 
	
	{
		new Register("Registration...");

	}

}





	

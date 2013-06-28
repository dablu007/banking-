

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.*;
import java.util.*;



public class AccountInfo extends JFrame {
	

		public AccountInfo()
		{
		super("Account Details");
		String heading[]={"Name","DOB","Gender","Phoneno","Address","emailid","occupation","identityproof","identityproofno","accounttype","depositamount","facilitiesrequired","accountno"};
		String data[][]=new String[30][13];
		ArrayList<Registration> list=new ArrayList<Registration>();
		
		try
		{
			FileInputStream fin=new FileInputStream("Banking.dat");
			ObjectInputStream oin=new ObjectInputStream(fin);
			list=(ArrayList<Registration>)oin.readObject();
			
			
			
			
			int r=0,c=0;
			for(Registration re : list)
			{
				data[r][0]=re.getName();
				data[r][1]=re.getdob();
				data[r][2]=re.getgender();
				data[r][3]=re.getphoneno();
				data[r][4]=re.getaddress();
				data[r][5]=re.getemailid();
				data[r][6]=re.getoccupation();
				data[r][7]=re.getidproof();
				data[r][8]=re.getidentityproofno();
				data[r][9]=re.getaccounttype();
				data[r][10]=re.getdepositamount();
				data[r][11]=re.getfr();
				data[r][12]=re.getaccountno();
				
				r++;
				c=0;
			}
			
			
			
			Container con=getContentPane();
			con.setLayout(new BorderLayout());

			JTable datatable=new JTable(data, heading);
			JScrollPane jsp=new JScrollPane(datatable);
			
			con.add(new JLabel("All Customer Details"),BorderLayout.NORTH);
			con.add(jsp,BorderLayout.CENTER);
			
			setSize(250, 300);
			
			setLocation(200, 200);
			setVisible(true);
			
			}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public static void main(String args[])
	{
		new AccountInfo();
	}
}




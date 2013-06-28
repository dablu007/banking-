

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.*;
import java.util.*;

public class CustTransInfo extends JFrame {
	
	public CustTransInfo()
	{
		super("Customer Transaction Information");
		String heading[]={"Account No.","Debit","Credit"};
		String data[][]=new String[20][3];
		ArrayList<TransactionInfo> match=new ArrayList<TransactionInfo>();
		try
		{
			FileInputStream fin=new FileInputStream("Banking3.dat");
			ObjectInputStream oin=new ObjectInputStream(fin);
			match=(ArrayList<TransactionInfo>)oin.readObject();
			
			int r=0;
			for(TransactionInfo re : match)
			{
				//data[r][0]=re.getDate();
				data[r][0]=re.getaccountno();
				data[r][1]=re.getDebit();
				data[r][2]=re.getCredit();
				//data[r][4]=re.getTotal();
				r++;
				
			}
			
			Container con=getContentPane();
			con.setLayout(new BorderLayout());
			
			JTable datatable=new JTable(data, heading);
			JScrollPane jsp=new JScrollPane(datatable);
			
			con.add(new JLabel("All Transaction Details"),BorderLayout.NORTH);
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
			new CustTransInfo();
		}

}


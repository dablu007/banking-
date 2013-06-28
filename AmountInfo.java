
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.*;
import java.util.*;



public class AmountInfo extends JFrame {
	

		public AmountInfo()
		{
		super("Amount Details");
		String heading[]={"depositamount","accountno"};
		String data[][]=new String[20][2];
		ArrayList<Transaction> folder=new ArrayList<Transaction>();
		try
		{
			FileInputStream fin=new FileInputStream("Banking2.dat");
			ObjectInputStream oin=new ObjectInputStream(fin);
			folder=(ArrayList<Transaction>)oin.readObject();
			
			int r=0,c=0;
			for(Transaction tn : folder)
			{
				
				data[r][0]=tn.getdepositamount();
				data[r][1]=tn.getaccountno();
				
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
			new AmountInfo();
		}

}

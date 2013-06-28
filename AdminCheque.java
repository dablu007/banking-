

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.*;
import java.util.*;



public class AdminCheque extends JFrame {
	

		public AdminCheque()
		{
		super("Account Details");
		String heading[]={"Account no."};
		String data[][]=new String[10][1];
		
		ArrayList<ChequeList> check=new ArrayList<ChequeList>();
		
		try
		{
			FileInputStream fin=new FileInputStream("Banking4.dat");
			ObjectInputStream oin=new ObjectInputStream(fin);
			check=(ArrayList<ChequeList>)oin.readObject();
			
			
			
			
			int r=0,c=0;
			for(ChequeList ch : check)
			{
				data[r][0]=ch.getaccountno();
			
				r++;
				c=0;
			}
		
		
		
		Container con=getContentPane();
		con.setLayout(new BorderLayout());

		JTable datatable=new JTable(data, heading);
		JScrollPane jsp=new JScrollPane(datatable);
		
		con.add(new JLabel("All Cheque Requests"),BorderLayout.NORTH);
		con.add(jsp,BorderLayout.CENTER);
		
		setSize(250, 300);
		
		setLocation(200, 200);
		setVisible(true);
		
		}catch(Exception e)
		{
		e.printStackTrace();
		}
	
	}

		/*public static Void main(String args[])
		{
			new AdminCheque();
		}*/
		
		
}
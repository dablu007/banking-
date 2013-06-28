
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.*;
import java.util.*;



public class AdminDraft extends JFrame {
	

		public AdminDraft()
		{
		super("Account Details");
		String heading[]={"Account no."};
		String data[][]=new String[10][1];
		
		ArrayList<DraftRequest> draft=new ArrayList<DraftRequest>();
		//ArrayList<Transaction> folder=new ArrayList<Transaction>();
		try
		{
			FileInputStream fin=new FileInputStream("Banking5.dat");
			ObjectInputStream oin=new ObjectInputStream(fin);
			draft=(ArrayList<DraftRequest>)oin.readObject();
			
			
			
			
			int r=0,c=0;
			for(DraftRequest d : draft)
			{
				data[r][0]=d.getaccountno();
			
				r++;
				c=0;
			}
		
		
		
		Container con=getContentPane();
		con.setLayout(new BorderLayout());

		JTable datatable=new JTable(data, heading);
		JScrollPane jsp=new JScrollPane(datatable);
		
		con.add(new JLabel("All Draft Requests"),BorderLayout.NORTH);
		con.add(jsp,BorderLayout.CENTER);
		
		setSize(250, 300);
		
		setLocation(200, 200);
		setVisible(true);
		
		}catch(Exception e)
		{
		e.printStackTrace();
		}
	
	}

	public static void main(String ar[])
	{
		new AdminDraft();
	}
		
		
}
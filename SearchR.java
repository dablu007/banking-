import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.*;
import java.util.*;

public class SearchR 
{
	private ArrayList<Registration> folder2;
	private int f = -1;
	public int searchaccountno(Registration rn)
	{
		try
		{
			FileInputStream fin=new FileInputStream("Banking.dat");
			ObjectInputStream oin=new ObjectInputStream(fin);
			folder2=(ArrayList<Registration>)oin.readObject();
			
			for(int p=0; p<folder2.size(); p++)
			{
				if((rn.getaccountno()).equals(folder2.get(p).getaccountno().trim()))
				{
				   f = p;
				   break;
				}	
			}
			 
			return(f);
				
		}catch(Exception e)
		{
			return(-1);
			
		}
		
	}
}

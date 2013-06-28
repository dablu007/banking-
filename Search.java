

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.*;
import java.util.*;

public class Search 
{
	private ArrayList<Transaction> folder1;
	private int f = -1;
	public int searchaccountno(Transaction tsn)
	{
		try
		{
			FileInputStream fin=new FileInputStream("Banking2.dat");
			ObjectInputStream oin=new ObjectInputStream(fin);
			folder1=(ArrayList<Transaction>)oin.readObject();
			
			for(int p=0; p<folder1.size(); p++)
			{
				if((tsn.getaccountno()).equals(folder1.get(p).getaccountno().trim()))
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



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TransAddInfo 
{
    ArrayList<Transaction> folder4;
	
	public TransAddInfo(Transaction rg1)
	{
		try
		{
		   FileInputStream fin=new FileInputStream("Banking2.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   folder4=(ArrayList<Transaction>)oin.readObject();
		}catch(Exception e)
		 {
			 folder4=new ArrayList<Transaction>();
		 }
		
		 folder4.add(rg1);
		 
		 try	
		 {
		       FileOutputStream fout=new FileOutputStream("Banking2.dat");
		       ObjectOutputStream oout=new ObjectOutputStream(fout);
		       oout.writeObject(folder4);
		}catch(Exception e){}
	
	}
}

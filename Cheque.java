

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Cheque
{
    ArrayList<ChequeList> check4;
	
	public Cheque(ChequeList rg1)
	{
		try
		{
		   FileInputStream fin=new FileInputStream("Banking4.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   check4=(ArrayList<ChequeList>)oin.readObject();
		}catch(Exception e)
		 {
			check4=new ArrayList<ChequeList>();
		 }
		
		check4.add(rg1);
		 
		 try	
		 {
		       FileOutputStream fout=new FileOutputStream("Banking4.dat");
		       ObjectOutputStream oout=new ObjectOutputStream(fout);
		       oout.writeObject(check4);
		}catch(Exception e){}
	
	}
}
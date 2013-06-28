


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AddInfo 
{
    ArrayList<Registration> list4;
	
	public AddInfo(Registration rg1)
	{
		try
		{
		   FileInputStream fin=new FileInputStream("Banking.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   list4=(ArrayList<Registration>)oin.readObject();
		}catch(Exception e)
		 {
			 list4=new ArrayList<Registration>();
		 }
		
		 list4.add(rg1);
		 
		 try	
		 {
		       FileOutputStream fout=new FileOutputStream("Banking.dat");
		       ObjectOutputStream oout=new ObjectOutputStream(fout);
		       oout.writeObject(list4);
		}catch(Exception e){}
	
	}

}

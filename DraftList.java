

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DraftList
{
    ArrayList<DraftRequest> draft4;
	
	public DraftList(DraftRequest rg1)
	{
		try
		{
		   FileInputStream fin=new FileInputStream("Banking5.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   draft4=(ArrayList<DraftRequest>)oin.readObject();
		}catch(Exception e)
		 {
			draft4=new ArrayList<DraftRequest>();
		 }
		
		draft4.add(rg1);
		 
		 try	
		 {
		       FileOutputStream fout=new FileOutputStream("Banking5.dat");
		       ObjectOutputStream oout=new ObjectOutputStream(fout);
		       oout.writeObject(draft4);
		}catch(Exception e){}
	
	}
}





import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UpdateInfo 
{
	ArrayList<Registration> list3;
	
	public UpdateInfo(Registration rg,int index)
	{
		try
		{
		   FileInputStream fin=new FileInputStream("Banking.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   list3=(ArrayList<Registration>)oin.readObject();
		   
		}catch(Exception e)
		 {
			 list3=new ArrayList<Registration>();
		 }
		
		 list3.set(index, rg);
		 
		 try	
		 {
		       FileOutputStream fout=new FileOutputStream("Banking.dat");
		       ObjectOutputStream oout=new ObjectOutputStream(fout);
		       oout.writeObject(list3);
		}catch(Exception e){}
	
	}
}



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DeleteR 
{
	ArrayList<Registration> list7;
    //ArrayList<Transaction> lst;
    
   public DeleteR(int index)
	{
		try
		{
		  /* FileInputStream fin=new FileInputStream("Banking2.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   lst=(ArrayList<Transaction>)oin.readObject();*/
		   
		   FileInputStream fin2=new FileInputStream("Banking.dat");
		   ObjectInputStream oin2=new ObjectInputStream(fin2);
		   list7=(ArrayList<Registration>)oin2.readObject();
		  
		   //lst.remove(index);
		   list7.remove(index);
		   
		  /* FileOutputStream fout=new FileOutputStream("Banking2.dat");
	       ObjectOutputStream oout=new ObjectOutputStream(fout);
	       oout.writeObject(lst);*/
	       
	       
	      FileOutputStream fout2=new FileOutputStream("Banking.dat");
	       ObjectOutputStream oout2=new ObjectOutputStream(fout2);
	       oout2.writeObject(list7);

		   
		}catch(Exception e)
		 {
			 list7=new ArrayList<Registration>();
		 }
		
	}
}